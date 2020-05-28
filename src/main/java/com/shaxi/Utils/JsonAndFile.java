package com.shaxi.Utils;

import java.io.*;

public class JsonAndFile {

    /**
     * 读文件
     * @return
     */
    public static String readFileToString(String caseName) {
        String fileName = String.format("%s_basedata.html", caseName);
        int len = 0;
        StringBuffer str = new StringBuffer();

        File file = new File("src/main/resources/baseresult/" + fileName);
        try {
            FileInputStream is = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader in = new BufferedReader(isr);
            String line = null;
            while ((line = in.readLine()) != null) {
                if (len != 0) { // 处理换行符的问题
                    str.append("\r\n" + line);
                } else {
                    str.append(line);
                }
                len++;
            }
            in.close();
            is.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str.toString();
    }

    /**
     * 写文件
     * @param data
     */
    public static void WriteStringToFile(String data,String caseName) {
        String fileBaseDataName = String.format("%s_basedata.html", caseName);
        File fileBase = new File("src/main/resources/baseresult/" + fileBaseDataName);
        System.out.println(fileBase.getPath());
        if (!fileBase.exists()) { //如果存在不写入
            try {
                FileOutputStream fos = new FileOutputStream(fileBase.getPath());
                String s = data;
                if (s.isEmpty()){
                    return;
                }else {
                    fos.write(s.getBytes());
                    System.out.println("写入" + fileBaseDataName + "成功！");
                    fos.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                String fileContrastDataName=String.format("%s_contrastdata.html", caseName);
                File fileContrast = new File("src/main/resources/contrastresult/" + fileContrastDataName);
                FileOutputStream fos = new FileOutputStream(fileContrast.getPath());
                String s = data;
                if (s.isEmpty()){
                    return;
                }else {
                    fos.write(s.getBytes());
                    System.out.println("写入" + fileContrastDataName + "成功！");
                    fos.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}