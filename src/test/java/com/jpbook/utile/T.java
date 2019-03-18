package com.jpbook.utile;

import java.io.File;

public class T {
    public static void main(String[] args) {
        String pathname = "F:\\books\\新建文件夹";
        File oldFile = new File(pathname);
        pathname = "F:\\books\\新建文件夹1";
        File newFile = new File(pathname);
        oldFile.renameTo(newFile);
    }
}
