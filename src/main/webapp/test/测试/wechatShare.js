/**
 * 微信分享代码模块
 */


function ShowMessageOK() {
    $j("#operate-ok").show(100, function () { setTimeout(function () { $j("#operate-ok").fadeOut(500); }, 1000); });
}

var dataForWeixin = {
    appId: "",
    MsgImg: "",
    TLImg: "",
    url: "",
    title: "",
    desc: "",
    fakeid: "",
    weibodesc:"",
    callback: function () { }
};
function SetupWeiXinShareInfo(img, url, title, desc, weibodesc) {
    dataForWeixin.MsgImg = img;
    dataForWeixin.TLImg = img;
    dataForWeixin.url = url;
    dataForWeixin.title = title;
    dataForWeixin.desc = desc;
    dataForWeixin.weibodesc = weibodesc;
}
(function () {
    var onBridgeReady = function () {
        WeixinJSBridge.on('menu:share:appmessage', function (argv) {
            WeixinJSBridge.invoke('sendAppMessage', {
                "appid": dataForWeixin.appId,
                "img_url": dataForWeixin.MsgImg,
                "img_width": "120",
                "img_height": "120",
                "link": dataForWeixin.url,
                "desc": dataForWeixin.desc,
                "title": dataForWeixin.title
            }, function (res) { if (res.err_msg == "send_app_msg:ok") { (dataForWeixin.callback)(); } });
        });
        WeixinJSBridge.on('menu:share:timeline', function (argv) {
            (dataForWeixin.callback)();
            WeixinJSBridge.invoke('shareTimeline', {
                "img_url": dataForWeixin.TLImg,
                "img_width": "120",
                "img_height": "120",
                "link": dataForWeixin.url,
                "desc": dataForWeixin.title,
                "title": dataForWeixin.title
            }, function (res) { (dataForWeixin.callback)(); });
        });
        WeixinJSBridge.on('menu:share:weibo', function (argv) {
            WeixinJSBridge.invoke('shareWeibo', {
                "content": dataForWeixin.weibodesc + ' ' + dataForWeixin.url,
                "url": dataForWeixin.url
            }, function (res) { (dataForWeixin.callback)(); });
        });
        WeixinJSBridge.on('menu:share:facebook', function (argv) {
            (dataForWeixin.callback)();
            WeixinJSBridge.invoke('shareFB', {
                "img_url": dataForWeixin.TLImg,
                "img_width": "120",
                "img_height": "120",
                "link": dataForWeixin.url,
                "desc": dataForWeixin.desc,
                "title": dataForWeixin.title
            }, function (res) { (dataForWeixin.callback)(); });
        });
    };
    
    
  //分享
	/*DWREngine.setAsync(false);
	syouDwr.getShareArgs(
		function(jsonText) {
			var result = eval(jsonText);
			var imgUrl = "";
			var oucode = result.oucode;
			var weixinappid = result.weixinappid;
			var shareLink = window.location.href;
			//if(window.location.href.indexOf("oucode") == -1){
			var whIndex = window.location.href.indexOf("?");
			if(whIndex != -1){
				shareLink =  shareLink.substr(0,whIndex);
			}else{
				shareLink =  shareLink;
			}
			shareLink = shareLink + "?oucode=" + oucode;
			//alert(shareLink);
			//}
			if(weixinappid){
				shareLink = encodeURIComponent(shareLink);
				shareLink ="https://open.weixin.qq.com/connect/oauth2/authorize?appid="+ weixinappid +"&redirect_uri="+ shareLink +"&response_type=code&scope=snsapi_userinfo&state=MsgType_Share";
			}
			
			var ms_title = $j("title").text();
			var ms_desc = $j("description").text();
			var ms_weibodesc = $j("description").text();
			SetupWeiXinShareInfo(imgUrl, shareLink, ms_title, ms_desc, ms_weibodesc);
			
			var btn = $j("div[class='btn']");
			var shareBtn = $j('.share-btn');
			shareBtn.click(function(){
				$j("#sharebox").css({ "top": 0});
		        $j("#sharebg").css({ "top": 0 });
		        $j("#sharebg,#sharebox").show();
			});
			
			btn.append(shareBtn); 
			var shareBoxDiv = '<div id="sharebg">&nbsp;</div>' +
							'<div id="sharebox">' +
							'    <img src="/m/scripts/probiz/wechat/share/follow1.png" />' +
							'</div>' +
							'<div id="operate-ok"></div>';
			 $j("body").append(shareBoxDiv);
			  
			 $j("#sharebg,#sharebox").click(function () {
		         $j("#sharebg,#sharebox,#SignUpBox").hide();
		     });
			 
			 
			 if (document.addEventListener) {
		        document.addEventListener('WeixinJSBridgeReady', onBridgeReady, false);
		    } else if (document.attachEvent) {
		        document.attachEvent('WeixinJSBridgeReady', onBridgeReady);
		        document.attachEvent('onWeixinJSBridgeReady', onBridgeReady);
		    }
		}
	);*/
    
   
})();



ms_PostSuccess = "";
dataForWeixin.callback = function () {
    setTimeout(function () {
        /*$.post("/Book/UpdateShareNum", { id: '52f99cfac3378f3a9403bcc0' }, function () {
            $("#sharebg,#sharebox").hide();
            window.location.reload();
        });*/
    	
    	//此处可以关注后与服务器交互
    	
    }, 1500);
}

