package com.jpbook.utile;

import com.jpbook.util.FileUtil;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageFilter;
import java.awt.image.ImageObserver;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        int imageWidth = 600;// 图片的宽度

        int imageHeight = 800;// 图片的高度

        BufferedImage image = new BufferedImage(imageWidth, imageHeight,
                BufferedImage.TYPE_INT_RGB);
        Graphics graphics = image.getGraphics();
        graphics.setColor(Color.white);
        graphics.fillRect(0, 0, imageWidth, imageHeight);
        graphics.setColor(Color.black);
        Font f = new Font("宋体", Font.BOLD, 75);
        FontMetrics fm = sun.font.FontDesignMetrics.getMetrics(f);
        int stringWidth = fm.stringWidth("网游之荒古时代");
        graphics.setFont(f);
        graphics.drawString("网游之荒古时代", 300-(stringWidth/2), 600);

        f = new Font("宋体", Font.BOLD, 20);
        fm = sun.font.FontDesignMetrics.getMetrics(f);
        stringWidth = fm.stringWidth("爱色鬼 著");
        graphics.setFont(f);
        graphics.drawString("爱色鬼 著", 300-(stringWidth/2), 650);

        f = new Font("宋体", Font.BOLD, 30);
        fm = sun.font.FontDesignMetrics.getMetrics(f);
        stringWidth = fm.stringWidth("江派书城");
        graphics.setFont(f);
        graphics.drawString("江派书城", 300-(stringWidth/2), 750);

        graphics.setFont(new Font("宋体", Font.BOLD, 20));

        createImage("F:\\PICS\\4.jpg", image);


    }
    private static void createImage(String fileLocation, BufferedImage image) {
        try {
            FileOutputStream fos = new FileOutputStream(fileLocation);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(bos);
            encoder.encode(image);
            bos.close();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
