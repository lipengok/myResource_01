package com.lp.redis_jpa.util;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.zip.*;

/**
 * @Author lipeng
 * @Date 2022/4/21 19:04
 * @Version 1.0
 */
public class JsonUtil {
    // 压缩json
    public static byte[] compressDeflater(Object object){
        Deflater deflater = new Deflater(9); // 0 ~ 9 压缩等级 低到高
        deflater.setInput(JSON.toJSONString(object).getBytes());
        deflater.finish();

        final byte[] bytes = new byte[256];
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(256);

        while (!deflater.finished()) {
            int length = deflater.deflate(bytes);
            outputStream.write(bytes, 0, length);
        }

        deflater.end();
        return outputStream.toByteArray();
    }
    /**
     * Inflater解压缩
     */
    public static String unCompressDeflater(byte[] decode) throws IOException {
        Inflater inflater = new Inflater();
        inflater.setInput(decode);

        final byte[] bytes = new byte[256];
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(256);

        try {
            while (!inflater.finished()) {
                int length = inflater.inflate(bytes);
                outputStream.write(bytes, 0, length);
            }
        } catch (DataFormatException e) {
            e.printStackTrace();
            return null;
        } finally {
            inflater.end();
        }

        return outputStream.toString();
    }

    public static <T> T unCompressDeflaterToObj(byte[] decode) throws IOException {
        Inflater inflater = new Inflater();
        inflater.setInput(decode);

        final byte[] bytes = new byte[256];
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(256);

        try {
            while (!inflater.finished()) {
                int length = inflater.inflate(bytes);
                outputStream.write(bytes, 0, length);
            }
        } catch (DataFormatException e) {
            e.printStackTrace();
            return null;
        } finally {
            inflater.end();
        }

        return JSON.parseObject(outputStream.toString(), (Type) Object.class);
    }


    // 压缩json
    public static String compressCJSON(Object object) throws IOException {
        String strObj = new ObjectMapper().writeValueAsString(object);
        // 创建一个新的输出流
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        // 使用默认缓冲区大小创建新的输出流
        GZIPOutputStream gzip = new GZIPOutputStream(out);
        gzip.write(strObj.getBytes("utf-8"));
        gzip.close();
        // 使用指定的编码格式
        return out.toString("ISO-8859-1");
    }
    public static byte[] compressCJSONToByte(Object object) throws IOException {
        String strObj = new ObjectMapper().writeValueAsString(object);
        // 创建一个新的输出流
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        // 使用默认缓冲区大小创建新的输出流
        GZIPOutputStream gzip = new GZIPOutputStream(out);
        gzip.write(strObj.getBytes("utf-8"));
        gzip.close();
        // 使用指定的编码格式
        return out.toByteArray();
    }
    public static String unCompressCJSONFromByte(byte[] bytes) throws IOException {
        // 创建一个新的输出流
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        // 创建一个 ByteArrayInputStream，使用 buf 作为其缓冲 区数组
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
        // 使用默认缓冲区大小创建新的输入流
        GZIPInputStream gzip = new GZIPInputStream(in);
        byte[] buffer = new byte[256];
        int n = 0;

        // 将未压缩数据读入字节数组
        while ((n = gzip.read(buffer)) >= 0) {
            out.write(buffer, 0, n);
        }
        // 使用指定的 charsetName，通过解码字节将缓冲区内容转换为字符串
        return out.toString("utf-8");
    }
}
