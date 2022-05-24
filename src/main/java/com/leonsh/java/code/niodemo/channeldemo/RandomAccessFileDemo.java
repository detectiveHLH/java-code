package com.leonsh.java.code.niodemo.channeldemo;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

/**
 * RandomAccessFileDemo
 *
 * @author leonsh
 * @date 2021-12-30 13:16
 **/
public class RandomAccessFileDemo {
    public static void main(String[] args) throws IOException, InterruptedException {
        // 指定需要生成的文件名称
        String targetFileName = "target-file.txt";
        // 创建 RandomAccessFile, 赋予可读(r)、可写(w)的权限
        RandomAccessFile accessFile = new RandomAccessFile(targetFileName, "rws");
        FileChannel fileChannel = accessFile.getChannel();

        // 创建 ByteBuffer 并写入数据
        ByteBuffer buffer = ByteBuffer.allocate(16);
        buffer.put("shDEQuanZhanBiJi".getBytes(StandardCharsets.UTF_8));
        // 切换到 buffer 的读模式
        buffer.flip();
        // 调用 write 写数据到文件
        fileChannel.write(buffer);


        // 相当于清空 buffer
        buffer.clear();
        // 将之前写入到 channel 的数据再读入到 buffer
        fileChannel.read(buffer);

        // 打印 buffer 中的内容
        printBuffer(buffer);

        fileChannel.close();
    }

    /**
     * 简单打印一下 buffer 中的内容
     *
     * @param buffer
     */
    public static void printBuffer(ByteBuffer buffer) {
        System.out.print("BUFFER VALUE: ");
        for (int i = 0; i < buffer.limit(); i++) {
            if (buffer.get(i) == 0) {
                continue;
            }
            System.out.print((char) buffer.get(i));
        }
        System.out.println();
    }
}
