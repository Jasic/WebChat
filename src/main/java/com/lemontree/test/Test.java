package com.lemontree.test;

import org.jasic.util.ByteUtil;

/**
 * Author Jasic
 * Date 14-3-8.
 */
public class Test {

    public static void main(String[] args) {

        byte[] bs = new byte[]{20,88,2,0};
        byte[] aa = new byte[100];
        System.out.println(ByteUtil.byteArrToBitString(bs));

        System.out.println(ByteUtil.bytesToString(bs, 0, bs.length));

        String s = ByteUtil.bytesToString(bs, 0, bs.length);

        System.out.println(s);
        ByteUtil.stringToBytes(aa, s, 0, s.length());

        System.out.println(ByteUtil.byteArrToBitString(aa));
    }
}
