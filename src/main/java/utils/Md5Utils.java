package utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Utils {
    public static void main(String[] args) {
        try {
            String str="123456";
            MessageDigest messageDigest=MessageDigest.getInstance("MD5");
//            信息摘要对象是对字节数组进行摘要的,所以先获取字符串的字节数组.
            byte  bytes[]=str.getBytes();
//            息摘要对象对字节数组进行摘要,得到摘要字节数组
            byte digest[] =messageDigest.digest(bytes);
            String resultStr=getMD5(str);
            System.out.println(resultStr);//827ccb0eea8a706c4c34a16891f84e7b
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static String getMD5(String str) throws Exception {

        String MD5 = "";

        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] bytes = str.getBytes();
        byte[] digest = md5.digest(bytes);
        StringBuffer sb=new StringBuffer();
        for (int i = 0; i < digest.length; i++) {
            //摘要字节数组中各个字节的"十六进制"形式.
            int j = digest[i];
            j = j & 0x000000ff;

            String s1 = Integer.toHexString(j);

            if (s1.length() == 1) {
                s1 = "0" + s1;
            }
//            MD5 += s1;
            sb.append(s1);
        }
        MD5=sb.toString();
        return MD5;
    }

}
