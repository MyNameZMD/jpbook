package com.jpbook.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

import java.io.File;

import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
public class FileDown {

    public void createZIP(String bookname, String[] picname, HttpServletResponse resp, HttpServletRequest req) {
        String filepath = "F:\\books\\";
        DataInputStream in = null;
        OutputStream out = null;
        try {
            resp.reset();// 清空输出流
            String resultFileName = bookname + ".zip";
            resultFileName = URLEncoder.encode(resultFileName, "UTF-8");
            resp.setCharacterEncoding("UTF-8");
            resp.setHeader("Content-disposition", "attachment; filename=" + resultFileName);// 设定输出文件头
            resp.setContentType("application/msexcel");// 定义输出类型

            // mafengworiben2 拼接城市准备输出到页面下载输出名字
            File resultPath = new File(filepath + bookname + ".zip");


            if(!resultPath.exists()) {
                String imageFolderPath = "F:\\books";
                File sourceFile = new File(imageFolderPath);
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                FileOutputStream fos = null;
                ZipOutputStream zos = null;

                if (sourceFile.exists() == false) {
                    System.out.println("文件目录不存在.");
                } else {
                    try {
                        File[] sourceFiles = sourceFile.listFiles();
                        if (null == sourceFiles || sourceFiles.length < 1) {
                            System.out.println("文件目录里面不存在文件，无需压缩.");
                        } else {
                            fos = new FileOutputStream(resultPath);
                            zos = new ZipOutputStream(new BufferedOutputStream(fos));
                            byte[] bufs = new byte[1024 * 10];
                            // 添加正确顺序的循环
                            for(int j = 0; j < picname.length; j++){

                                for (int i = 0; i < sourceFiles.length; i++) {
                                    String thispic = sourceFiles[i].toString().substring(imageFolderPath.length() + 1);
                                    //判断是否是正确顺序对应的图片
                                        System.out.println("picname"+picname[j]);
                                        //创建ZIP实体，并添加进压缩包
                                        // ZipEntry zipEntry = new ZipEntry(sourceFiles[i].getName());
                                        ZipEntry zipEntry = new ZipEntry(picname[j]);
                                        zos.putNextEntry(zipEntry);
                                        //读取待压缩的文件并写进压缩包里
                                        fis = new FileInputStream(sourceFiles[i]);
                                        bis = new BufferedInputStream(fis, 1024 * 100000);
                                        int read = 0;
                                        while ((read = bis.read(bufs, 0, 1024 * 10)) != -1) {
                                            zos.write(bufs, 0, read);
                                        }
                                        /*fis.close();
                                        fs[i].delete();*/

                                }

                            }
                        }
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                        throw new RuntimeException(e);
                    } catch (IOException e) {
                        e.printStackTrace();
                        throw new RuntimeException(e);
                    } finally {
                        try {
                            if (null != bis) bis.close();
                            if (null != zos) zos.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                            throw new RuntimeException(e);
                        }
                    }
                }
            }



            in = new DataInputStream(new FileInputStream(resultPath));
            out = resp.getOutputStream();
            int bytes = 0;
            byte[] bufferOut = new byte[1024];
            while ((bytes = in.read(bufferOut)) != -1) {
                out.write(bufferOut, 0, bytes);
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.reset();
            try {

                OutputStreamWriter writer = new OutputStreamWriter(resp.getOutputStream(), "UTF-8");
                String data = "<script language='javascript'>alert(\"\\u64cd\\u4f5c\\u5f02\\u5e38\\uff01\");</script>";
                writer.write(data);
                writer.close();
            }catch (IOException ie){}
        } finally {
            if (null != in) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != out) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
