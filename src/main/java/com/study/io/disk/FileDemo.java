package com.study.io.disk;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author dxq
 * @title: FileDemo
 * @projectName p5study
 * @description: TODO
 * @date 2020/2/25 15:32
 */
public class FileDemo {
    // 通过结合前面的部分内容。来整一个案列
    // 根据用户端输入的路径进行目录的遍历
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(reader);
        try {
            String path = bufferedReader.readLine();
            File file = new File(path);
            if (file.isDirectory() && file.exists()) {
                fileList(file);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            bufferedReader.close();
            reader.close();
        }
    }

    public static void fileList(File filePath) {
        File[] files = filePath.listFiles();
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                if (files[i].isFile()) {
                    System.out.println(files[i].getName()); // 输出文件名
                } else {
                    fileList(files[i]); // 递归遍历
                }
            }
        }
    }

}
