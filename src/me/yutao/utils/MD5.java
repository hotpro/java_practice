package me.yutao.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;

public class MD5 {
    public static String MD5EncodeFile(String fileUri) {
        String md5 = null;
        FileInputStream fileInputStream = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            fileInputStream = new FileInputStream(fileUri);
            byte[] buffer = new byte[1024];
            int b = 0;
            while ((b = fileInputStream.read(buffer)) > 0) {
                messageDigest.update(buffer, 0, b);
            }
            md5 = byteArrayToHexString(messageDigest.digest());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return md5;
    }

    public static String byteArrayToHexString(byte[] toencode) {
        StringBuilder sb = new StringBuilder(toencode.length * 2);
        for(byte b: toencode){
            sb.append(hexDigits[(b & 0xf0) >>> 4]);// 无符号右移
            sb.append(hexDigits[b & 0x0f]);
        }
        return sb.toString();
    }

    public static String MD5Encode(String s)
    {
        String md5 = null;
        try
        {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            md5 = byteArrayToHexString(messageDigest.digest(s.getBytes()));
        }
        catch (Exception localException)
        {
        }
        return md5;
    }

    private static final String[] hexDigits = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };
}
