package com.jpbook.util;

public class text {
    public static void main(String[] args) {
        String str="网游之荒古时代\\第一卷\\第六章测试我.txt";
        System.out.println(str.substring(str.lastIndexOf("\\")+1));
    }
}
