package utils;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import com.sun.xml.internal.messaging.saaj.soap.GifDataContentHandler;
import sun.awt.image.ImageFormatException;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class FileIntertorUtils {
    public static void saveImage(Component com){
        int comH=com.getHeight();
        int comW=com.getWidth();
        BufferedImage bufferImage=new BufferedImage(comW,comH,BufferedImage.TYPE_INT_RGB);
        Graphics2D g2=bufferImage.createGraphics();
        g2.setBackground(Color.white);
        com.paint(g2);
        g2.dispose();
        FileFilter filter = new FileFilter() {
            @Override
            public boolean accept(File f) {
                // TODO Auto-generated method stub
                return f.isFile() && f.getName().endsWith("jpg")
                        || f.getName().endsWith("JPG");
            }

            @Override
            public String getDescription() {
                // TODO Auto-generated method stub
                return "JPG or jpg";
            }
        };
        JFileChooser fileChoose = new JFileChooser();
        fileChoose.setFileFilter(filter);
        int result = fileChoose.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChoose.getSelectedFile();
            String path = file.getPath();
            try {

                FileOutputStream output = new FileOutputStream(path);
                JPEGImageEncoder jpg = JPEGCodec.createJPEGEncoder(output);
                jpg.encode(bufferImage);
                output.close();
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }  catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

    }
}
