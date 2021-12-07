package com.leonsh.spring.demo.nettydemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * TestByteBuffer
 *
 * @author leonsh
 * @date 2021-12-07 13:49
 **/
public class TestByteBuffer {
    public static void main(String[] args) throws IOException {
        try (FileChannel channel = new FileInputStream("data.txt").getChannel();) {
            ByteBuffer buffer = ByteBuffer.allocate(13);
            // 向 buffer 写入, 意思是将这个 channel 的数据
            channel.read(buffer);
            // 打印 buffer, flip 切换到 buffer 的读模式
            buffer.flip();

            // get 无参数代表就读一个字节
            while (buffer.hasRemaining()) {
                byte b = buffer.get();
                System.out.println((char) b);
            }
        } catch (IOException e) {

        }
    }
}
