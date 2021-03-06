package com.serket.cloud.util;

import java.security.MessageDigest;
import java.util.Random;
import java.util.UUID;

/**
 * Created by Administrator on 2015/5/10.
 */
public class Encryption {
    public static String QRCode() {
        String uuid = UUID.randomUUID().toString();
        //去掉uuid中的-
        uuid = uuid.replace("-", "");
        // 给uuid 随机添加一些特殊符号
        return addRandomString(uuid);
    }



    private static Random r = new Random();


    //用于生成二维码
    public static char[] cs = {'`', '~', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '_', '+', '-', '=', '{', '}', '[', ']', '|', '\'', ':', ';', '"', '<', '>', '.', '?', '/', '"'};
    private static String addRandomString(String uuid) {
        StringBuffer sb= new StringBuffer(uuid);
        for (int i = 0; i < 8; i++) {
            sb.insert(r.nextInt(31),cs[r.nextInt(30)]);
        }
        return sb.toString();
    }
    public static String SHA(String decript) {
        try {
            MessageDigest digest = java.security.MessageDigest
                    .getInstance("SHA");
            digest.update(decript.getBytes());
            byte messageDigest[] = digest.digest();
            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            // 字节数组转换为 十六进制 数
            for (int i = 0; i < messageDigest.length; i++) {
                String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }
                hexString.append(shaHex);
            }
            return hexString.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
