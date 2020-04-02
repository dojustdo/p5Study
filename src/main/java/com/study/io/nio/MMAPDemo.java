package com.study.io.nio;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author dxq
 * @title: MMAPDemo
 * @projectName reflex
 * @description: 零拷贝
 * @date 2020/4/2 17:37
 */
public class MMAPDemo {

    public static void main(String[] args) throws IOException {
        FileChannel inChannel = FileChannel.open(Paths.get("E:/test.txt"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("E:/test_cp2.txt"), StandardOpenOption.CREATE,StandardOpenOption.WRITE, StandardOpenOption.READ);

        MappedByteBuffer inMappedByteBuffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
        MappedByteBuffer outMappedByteBuffer = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());

        byte[] bytes = new byte[inMappedByteBuffer.limit()];
        inMappedByteBuffer.get(bytes);
        outMappedByteBuffer.put(bytes);
        inChannel.close();
        outChannel.close();
    }
}
