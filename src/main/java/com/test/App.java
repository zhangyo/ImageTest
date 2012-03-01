package com.test;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        try {

            BufferedImage originalImage =
                    ImageIO.read(new File("e:\\tmp\\2011 Gold Coast 156.jpg"));

            File fbaos = new File("e:\\tmp\\myimage.jpg");
            ImageOutputStream baos = ImageIO.createImageOutputStream(fbaos);
            //FileOutputStream baos = new FileOutputStream(fbaos);
            ImageWriter imageWriter = ImageIO.getImageWritersByFormatName("JPG").next();
            ImageWriteParam param = imageWriter.getDefaultWriteParam();
            param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
            int width = originalImage.getWidth();
            int height = originalImage.getHeight();
            System.out.println("Image width: " + width + "    height: " + height);
            param.setCompressionQuality(getBestCompressionQualityForSize(width));
            imageWriter.setOutput(baos);
            imageWriter.write(null, new IIOImage(originalImage, null, null), param);
            //ImageIO.write(originalImage, "jpg", baos);
//            baos.flush();
//            byte[] imageInByte = baos.toByteArray();
//            baos.close();

        } catch (IOException e) {
            System.out.println(e.getMessage() + "test");
        }
    }


    static private float getBestCompressionQualityForSize(int width) {
      if (width >= 2560) {
          return .4f;
      }
      else if (width >= 1920) {
          return .5f;
      }
      else if (width >= 1680) {
          return .6f;
        }
      else if (width >= 1311) {
          return .65f;
        }
      else if (width >= 1280) {
        return .75f;
      } else if (width >= 940) {
        return .78f;
      } else if (width >= 700) {
        return .80f;
      } else if (width >= 340) {
        return .85f;
      } else if (width >= 160) {
        return .88f;
      } else {
        return .9f;
      }
    }

}
