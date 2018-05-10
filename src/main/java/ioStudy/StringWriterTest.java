package ioStudy;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class StringWriterTest {
    public static void main(String[] args) {
        try{
            StringReader sr=new StringReader("This is a just a test");
            StringWriter sw=new StringWriter();
            int c=-1;
//            char buffbyte[]=new char[1024];
            while((c=sr.read())!=-1){
                sw.write(c);
            }
            System.out.println(sw.getBuffer().toString());
        }catch (Exception e){

        }
    }
}
