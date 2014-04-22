package com.lemontree.test;

import cn.tisson.framework.utils.JsonUtils;
import com.lemontree.daemon.domm.cmd.Account;
import com.lemontree.daemon.domm.cmd.Command;
import com.lemontree.daemon.domm.cmd.PushServiceInfoCmd;
import com.lemontree.util.MessageUtil;
import com.lemontree.webchat.protocol.bean.Event;
import com.lemontree.webchat.protocol.req.TextReqMsg;
import com.lemontree.webchat.protocol.req.event.ScanNotSubEventReqMsg;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.junit.*;

import java.io.IOException;
import java.util.ArrayList;

/**
 * User: Jasic
 * Date: 13-12-30
 */
public class TestClient {

    public static void main(String[] args) throws IOException {
//        testGet();
//        testPost();
//        System.out.println(testJsonCmd());
        System.out.println( testJsonCmd());
    }

    public static void testGet() throws IOException {
        HttpClient client = new DefaultHttpClient();

        StringBuffer url = new StringBuffer("http://bassice.gicp.net/webchat/token/gh_b817172873c4");
        url.append("?")
                .append("signature=5cbeee310990d9c54d9843b9a2dff96ec30d3565")
                .append("&")
                .append("timestamp=1371608072")
                .append("&")
                .append("nonce=1372170854")
                .append("&")
                .append("echostr=5976194625791363975");


        HttpGet get = new HttpGet(url.toString());
        System.out.println(get);
        HttpResponse response = client.execute(get);
        System.out.println(EntityUtils.toString(response.getEntity()));
    }

    public static void testPost() throws IOException {
        // 客户端
        HttpClient client = new DefaultHttpClient();

        ArrayList<NameValuePair> pairs = new ArrayList<NameValuePair>();

//        HttpPost post = new HttpPost("http://127.0.0.1/login");
//        HttpPost post = new HttpPost("http://jasic.vicp.net/platform/token/gh_b817172873c4");
        HttpPost post = new HttpPost("http://localhost:8080/terminal/cmd");

        Header Agent = new BasicHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/27.0.1453.116 Safari/537.36");
//        Header referer = new BasicHeader("Referer", "http://hg0088.com/app/member/");
        Header connection = new BasicHeader("Connection", "keep-alive");


        Header accept;
//        accept = new BasicHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
        accept = new BasicHeader("Accept", "application/json");


        Header contentType;
//        contentType= new BasicHeader("Content-Type", "application/x-www-form-urlencoded");
        contentType = new BasicHeader("Content-Type", "application/json");

        Header cacheControl = new BasicHeader("Cache-Control", "max-age=0");
//        Header origin = new BasicHeader("Origin", "http://hg0088.com");
        Header acceptEncoding = new BasicHeader("Accept-Encoding", "gzip,deflate,sdch");
        Header acceptLanguage = new BasicHeader("Accept-Language", "zh-CN,zh;q=0.8");

        post.setHeaders(new Header[]{Agent, connection, accept, cacheControl, contentType, acceptEncoding, acceptLanguage});
        String msg = null;
        //================================================================设置内容============================================
//        msg = testTextMessage();
        msg = testScanHasSubEventReqMsg();
        msg = testJsonCmd();
        //================================================================设置内容============================================
        post.setEntity(new StringEntity(msg, "UTF-8"));

//        System.out.println("1_-------------------------------------------------------------");
//        System.out.println(URLEncoder.encode(msg, "UTF-8"));
//        System.out.println(URLEncoder.encode(msg, "ISO8859-1"));
//        System.out.println(URLEncoder.encode(msg, "GBK"));
//        System.out.println("2_-------------------------------------------------------------");
//        System.out.println(URLDecoder.decode(URLEncoder.encode(msg, "ISO8859-1")));
//        System.out.println("3_-------------------------------------------------------------");

        //返回
        HttpResponse response = client.execute(post);
        int statusCode = response.getStatusLine().getStatusCode();

        System.out.println("statusCode:" + statusCode);
        /*4 判断访问的状态码*/
        if (statusCode != HttpStatus.SC_OK) {
            System.err.println("Method failed: ");
            return;
        }
        System.out.println("Response success~...");
        String contend = EntityUtils.toString(response.getEntity());
        System.out.println(contend);
    }


    public static String testTextMessage() {
        TextReqMsg textReqMsg = new TextReqMsg();

        textReqMsg.setFromUserName("gh_b817172873c4");
        textReqMsg.setToUserName("LemonTree");
        textReqMsg.setContent("Test Content测试内容");
        textReqMsg.setMsgType(MessageUtil.REQ_MESSAGE_TYPE_TEXT);
        textReqMsg.setMsgId(1);
        textReqMsg.setCreateTime(System.currentTimeMillis() / 1000);

        String reqBody = MessageUtil.textMessageToXml(textReqMsg);
        System.out.println(reqBody);
        return reqBody;
    }


    public static String testScanHasSubEventReqMsg() {
        ScanNotSubEventReqMsg scanEventMsg = new ScanNotSubEventReqMsg();

        scanEventMsg.setFromUserName("Fan_Jasic");
        scanEventMsg.setToUserName("LemonTree");
        scanEventMsg.setMsgId(11111);
        scanEventMsg.setEvent(Event.subscribe);
        scanEventMsg.setEventKey("qrscene_120");
        scanEventMsg.setTicket("Ticket");
        scanEventMsg.setCreateTime(System.currentTimeMillis() / 1000);

        String reqBody = MessageUtil.scanEventMessageToXml(scanEventMsg);
        return reqBody;
    }


    public static String testJsonCmd() {

        PushServiceInfoCmd cmd = new PushServiceInfoCmd();
        Account account = new Account();
        account.setShopID("ZCX");
        account.setPwd("123456");
        cmd.setCmd(Command.ZJWXSH);
        cmd.setWebChatID("gh_b817172873c4");
        cmd.setAccount(account);
        cmd.setOper(PushServiceInfoCmd.PushServiceOper.BIND);

        String jsonStr = JsonUtils.parseToString(cmd);

        return jsonStr;
    }

}
