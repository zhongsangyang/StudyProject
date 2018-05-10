package utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import model.FiveElements;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Hashtable;

public class QrCodeUtils {
    public static final String CHARTSET = "utf-8";
    public static final int WIDTH=300;
    public static final String FORMAT="png";
    public static final int HEIGHT=300;
    public static void main(String[] args) {
        String filepath="D://zhao.png";
//        createQRcode(filepath);
//        testReadQRcode(filepath);
        try {
            System.out.println(decode(new File(filepath)));
//            testReadQRcode(filepath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void createQRcode(String filepath){
        FiveElements fiveElements = new FiveElements();
        fiveElements.setName("zhao");
        fiveElements.setGender("M");
        fiveElements.setIdType("I");
        fiveElements.setIdNo("370983");
        fiveElements.setMobile("1805310");
        String contents= JSON.toJSONString(fiveElements);
        HashMap<EncodeHintType,Object> hints=new HashMap<EncodeHintType, Object>();
        hints.put(EncodeHintType.CHARACTER_SET,CHARTSET);
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
        hints.put(EncodeHintType.MARGIN,2);
        try {
            BitMatrix bitMatrix=new MultiFormatWriter().encode(contents,BarcodeFormat.QR_CODE,WIDTH,HEIGHT,hints);
            Path path=new File(filepath).toPath();
            MatrixToImageWriter.writeToPath(bitMatrix,FORMAT,path);
            System.out.println("二维码完成");
        } catch (WriterException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Path path=new File(filepath).toPath();

    }
    private static void testReadQRcode(String filepath){
        Result result=getRequest(filepath);
        if(result!=null){
            System.out.println("二维码内容"+result.getText());
            FiveElements fiveElements= JSONObject.parseObject(result.getText(),FiveElements.class);
            System.out.println(fiveElements);
        }
    }
    private static Result getRequest(String filepath) {
        /**
         * 如果用的jdk是1.9，需要配置下面这一行。
         */
        //System.setProperty("java.specification.version", "1.9");
        Result result = null;
        try {
            File file = new File(filepath);
            System.out.println(file.getName());
            BufferedImage bufferedImage = ImageIO.read(file);
            BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(
                    new BufferedImageLuminanceSource(bufferedImage)
            ));
            HashMap hints = new HashMap();
            hints.put(EncodeHintType.CHARACTER_SET, CHARTSET);
            result = new MultiFormatReader().decode(binaryBitmap, hints);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }
    public static String decode(File file) throws Exception {
        BufferedImage image;
        image = ImageIO.read(file);
        if (image == null) {
            return null;
        }

        BufferedImage bufferedImage = ImageIO.read(file);
        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(
                new BufferedImageLuminanceSource(bufferedImage)
        ));
        Result result;
        Hashtable<DecodeHintType, Object> hints = new Hashtable<DecodeHintType, Object>();
        hints.put(DecodeHintType.CHARACTER_SET, CHARTSET);
        result = new MultiFormatReader().decode(binaryBitmap, hints);
        String resultStr = result.getText();
        return resultStr;
    }
}
