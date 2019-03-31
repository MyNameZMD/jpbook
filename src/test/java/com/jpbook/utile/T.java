package com.jpbook.utile;

import java.io.File;

public class T {
    public static void main(String[] args) {
       /* String pathname = "F:\\books\\新建文件夹";
        File oldFile = new File(pathname);
        pathname = "F:\\books\\新建文件夹1";
        File newFile = new File(pathname);
        oldFile.renameTo(newFile);*/
        /*String oldName="网游之荒古时代\\\\第一卷\\\\第六章";
        String newName="网游之荒古时代\\\\第一卷\\\\第六章测试";
        System.out.println(oldName+"\n"+newName);
        File f=new File("f:\\books\\"+oldName+".txt");
        String c=f.getParent();
        System.out.println(c);
        File mm=new File("f:\\books\\"+newName+".txt");
        if(f.renameTo(mm))
        {
            System.out.println("修改成功!");
        }
        else
        {
            System.out.println("修改失败");
        }*/
        /*File file = new File("f:\\books\\网游之荒古时代\\第一卷\\第一章测试.txt");
        System.out.println(file);
        file.delete();*/
        String s="C:\\fakepath\\QQ图片20190228154423.png";
        System.out.println(s.substring(s.lastIndexOf('\\')+1));
    }
}
