package com.leonsh.spring.demo.nettydemo;

import com.leonsh.spring.demo.nettydemo.util.ByteBufferUtil;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 将一个文件内的内容, 直接分散存储在多个 ByteBuffer 中,
 * 这样一来就不用读取多次文件了
 *
 * @author leonsh
 * @date 2021-12-09 13:50
 **/
public class TestScatteringRead {
    public static void main(String[] args) {
        // RandomAccessFile 既可以读取文件内容, 也可以向文件输出内容
        try (FileChannel channel = new RandomAccessFile("word.txt", "r").getChannel()) {
            ByteBuffer b1 = ByteBuffer.allocate(3);
            ByteBuffer b2 = ByteBuffer.allocate(3);
            ByteBuffer b3 = ByteBuffer.allocate(5);

            channel.read(new ByteBuffer[]{b1, b2, b3});
            b1.flip();
            b2.flip();
            b3.flip();

            ByteBufferUtil.debugAll(b1);
            ByteBufferUtil.debugAll(b2);
            ByteBufferUtil.debugAll(b3);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
