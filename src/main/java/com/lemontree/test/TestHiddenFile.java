package com.lemontree.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Author Jasic
 * Date 13-12-16.
 */
public class TestHiddenFile {

    public static void main(String[] args) throws IOException {

        File file = new File("/tmp/.1.txt");
        FileReader fr = new FileReader(file);

        BufferedReader reader = new BufferedReader(fr);
        String line = reader.readLine();
        while (line != null) {
            System.out.println(line);
            line = reader.readLine();
        }
    }
}
