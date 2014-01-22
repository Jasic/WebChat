package com.lemontree.test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * User: Jasic
 * Date: 13-12-31
 */
public class TestUrlCodex {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String test = "111sfsafksafjsa;dfka;slfdjalfdadf";
        System.out.println(test);
        System.out.println(URLDecoder.decode(test, "GBK"));
        System.out.println(URLDecoder.decode(test, "UTF-8"));
    }
}
