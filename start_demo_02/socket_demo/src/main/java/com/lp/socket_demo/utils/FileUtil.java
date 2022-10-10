package com.lp.socket_demo.utils;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author lipeng
 * @Date 2022/10/9 9:19
 * @Version 1.0
 */
public class FileUtil {

    private static String basePath = System.getProperty("user.dir");
    private static SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-hh-mm");
    private static SimpleDateFormat sSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
    private static SimpleDateFormat hSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-hh");
    // 获取两位的随机数
    private static int i = (int) (Math.random() * 100);

    private static FileWriter fw;
    private static BufferedWriter bw;
    private static String date = hSimpleDateFormat.format(new Date());
    private static String dir = "socket/server";
    private static String path = basePath + "/" + dir + "/" + date + ".txt";
    // 分步骤文件写入
    public static void strStart() throws IOException {
        File file = new File(path);
        File d = new File(basePath + "/" + dir);
        if (!d.exists()) {
            file.mkdirs();
        }
        if (!file.exists()) {
            file.createNewFile();
        }
        fw = new FileWriter(file.getAbsoluteFile());
        bw = new BufferedWriter(fw);
    }
    public static void strWrite(String str) throws IOException {
        bw.write(str);
        bw.newLine();
    }
    public static void close() throws IOException {
        bw.flush();
        bw.close();
        fw.close();
    }

    /**
     * 文件读取。
     * @param fileUrl
     * @return
     */
    public static String readFileByUrl(String fileUrl) {
        File file = new File(fileUrl);
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder("");
        try {
            //GBK解决中文乱码问题
            br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "GBK"));
            String b = null;
            sb = new StringBuilder();
            // 逐行读取
            while ((b = br.readLine()) != null) {
                sb.append(b+"\n");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    /**
     * 文件写入。
     * 如果是已存在的文件将对文件内容进行追加
     * 如果是新文件就直接写入
     * @param dir
     * @param str
     * @throws IOException
     */
    public static void writeAppend(String dir, String str) throws IOException {
        String date = hSimpleDateFormat.format(new Date());
        String nowDate = sSimpleDateFormat.format(new Date());
        String path = basePath + "/" + dir + "/" + date + ".txt";
        File d = new File(basePath + "/" + dir);
        File file = new File(path);
        if (!d.exists()) {
            d.mkdirs();
        }
        if (!file.exists()) {
            file.createNewFile();
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(nowDate+"=>"+str);
            bw.newLine();
            bw.flush();
            bw.close();
            fw.close();
        }else {
            String fileStr = readFileByUrl(path);
            System.out.println(fileStr);
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(fileStr+nowDate+"=>"+str);
            bw.newLine();
            bw.flush();
            bw.close();
            fw.close();
        }
    }

    public static void main(String[] args) throws IOException {
        String test = "hello world !";
        /*strStart();
        strWrite(test);
        strWrite(test);
        close();*/

        writeAppend("socket/server", test);
        // System.out.println(readFileByUrl(path));
    }
}
