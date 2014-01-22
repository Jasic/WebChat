package com.lemontree.test;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: Jasic
 * Date: 14-1-6
 */
public class TestExport {

    public static void main(String[] args) throws Exception {
        File pre_0663 = new File("E:\\deskTop\\1/pre_0663.txt");
        File pre_0755 = new File("E:\\deskTop\\1/pre_0755.txt");

        List<String> phone_0663 = getPhones(pre_0663);
        List<String> phone_0755 = getPhones(pre_0755);

        File inputDir = new File("E:\\deskTop\\1\\input");

        String base = "E:\\deskTop\\1\\output";

        for (File file : inputDir.listFiles()) {
            Map<String, List<String>> result = new HashMap<String, List<String>>();
            result.put("0663", new ArrayList<String>());
            result.put("0755", new ArrayList<String>());
            result.put("other", new ArrayList<String>());

            List<String> phones = getPhones(file);
            System.out.println(file + " size: " + phones.size());

            boolean numBreak = false;
            for (String phone : phones) {
                numBreak = false;
                for (String s : phone_0663) {
                    if (phone.startsWith(s)) {
                        result.get("0663").add(phone);
                        numBreak = true;
                        break;
                    }
                }
                if (numBreak) continue;
                for (String s : phone_0755) {
                    if (phone.startsWith(s)) {
                        result.get("0755").add(phone);
                        numBreak = true;
                        break;
                    }
                }

                if (numBreak) continue;
                result.get("other").add(phone);
            }

            for (String key : result.keySet()) {
                File f = new File(base + "/" + file.getName().replace("(1).txt", "") + key + ".txt");
                if (!f.exists()) {
                    f.getParentFile().mkdirs();
                    f.createNewFile();
                }
                FileWriter writer = new FileWriter(f, true);
                for (String pho : result.get(key)) {
                    writer.write(pho + "\n");
                }
                writer.flush();

                System.out.println(f + " : " + key + ":" + result.get(key).size());
            }
        }
    }


    public static List<String> getPhones(File file) throws IOException {

        BufferedReader br1 = new BufferedReader(new FileReader(file));

        List<String> list = new ArrayList<String>();
        String phone = br1.readLine();
        while (phone != null) {
            list.add(phone);
            phone = br1.readLine();
        }
        return list;
    }
}
