package com.leonsh.java.code.fundamental.niodemo.channeldemo;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * FileChannel
 *
 * @author leonsh
 * @date 2021-12-30 09:36
 **/
public class FileInputStreamDemo {
    public static void main(String[] args) throws IOException {
        // 创建一个输入流
        FileInputStream fileInputStream = new FileInputStream("test-file.txt");
        // 通过输入流获取到 channel
        FileChannel fileChannel = fileInputStream.getChannel();

        // 准备好 ByteBuffer
        ByteBuffer buffer = ByteBuffer.allocate(16);
        // 将 输入流 的 channel 的数据读入 buffer 中
        fileChannel.read(buffer);

        // 简单打印 buffer 的内容
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
