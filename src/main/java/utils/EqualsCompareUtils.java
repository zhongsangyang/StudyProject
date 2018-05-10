package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class EqualsCompareUtils {
    public static void main(String[] args) {
        try {
            String s1="Hello";
            String s2="Hello";
            String s3="Good-bye";
            String s4="HELLO";
            System.out.println(s1+"\t"+"equals"+"\t"+s2+"->"+s1.equals(s2));
            System.out.println(s1+"\t"+"equals"+"\t"+s3+"->"+s1.equals(s3));
            System.out.println(s1+"\t"+"equals"+"\t"+s4+"->"+s1.equals(s4));
            System.out.println(s1+"\t"+"equalsIgnoreCases"+"\t"+s4+">"+s1.equalsIgnoreCase(s4));
            SimpleDateFormat sdf=new SimpleDateFormat();
            sdf.parseObject(s1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
