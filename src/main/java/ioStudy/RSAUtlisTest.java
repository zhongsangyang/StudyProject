package ioStudy;

import net.sf.json.JSONObject;
import utils.RSAUtils;

public class RSAUtlisTest {
    public static void main(String[] args) {
      /*  先对str的长度/算出一个x，再取模看实际长度是否是大于还是等于于x*len，
        如果str.leng/len==0代表刚好等于0代表 x*len=str.len，
        如果!=0代表x*len<str.len;
        就要初始化 x+1的数组才能容纳下分割生成的数组大小 String splitArray[]=new String[x+1];
        这个算法分为两种情况，第一中是len的刚好倍数，然后利用 subString(len,len*i+len);
        分割出字符出来，另外一种，利用subString(len,len*i+y);对数字%取模以后剩余的y(注y<len)
        利用subString(len,len*i+y);分割
       */
        String str[] = RSAUtils.splitString("sys,admin,user,role,permission3", 5);
        for (String s : str) {
            System.out.println(s);
        }
        JSONObject json=new JSONObject();
        json.put(1,2);
        json.put(2,2);
        json.put(3,2);
        json.put(4,2);
        json.put(5,2);
        System.out.println(json.toString());

    }

}
