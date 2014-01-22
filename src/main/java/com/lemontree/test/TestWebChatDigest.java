package com.lemontree.test;

import com.lemontree.common.WebChatDigest;

/**
 * User: Jasic
 * Date: 14-1-8
 */
public class TestWebChatDigest {

    public static void main(String[] args) {

        String signature = "5cbeee310990d9c54d9843b9a2dff96ec30d3565";//加密需要验证的签名
        String timestamp = "1371608072";//时间戳
        String nonce = "1372170854";//随机数
        String token = "gh_b817172873c4";

        WebChatDigest wxDigest = WebChatDigest.getInstance();
        boolean bValid = wxDigest.validate(signature, timestamp, nonce, token);
        if (bValid) {
            System.out.println("token 验证成功!");
        } else {
            System.out.println("token 验证失败!");
        }
    }
}
