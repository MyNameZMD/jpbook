package com.jpbook.utile;

import javax.swing.*;
import java.awt.*;

public class RePanel extends JPanel {
    protected void paintComponent(Graphics g){//重写paintComponent方法以实现jPanel加背景
        super.paintComponent(g);
        ImageIcon image=new ImageIcon(this.getClass().getResource("F:\\PICS\\default_5c7e43aa6e422.png"));        //获取图像
        image.setImage(image.getImage().getScaledInstance(this.getWidth(),this.getHeight(),Image.SCALE_FAST)); //调整图像的分辨率以适应容器
        image.paintIcon(this, g,0, 0);
    }
}
