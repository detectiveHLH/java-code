package com.leonsh.spring.demo.nettydemo.bytebuffer;

import java.io.FileInputStream;
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
            ByteBuffer buffer = ByteBuffer.allocate(10);
            while (true) {
                // 向 buffer 写入数据, 对应的是 channel.write 是从 buffer 中读数据, 写入 channel 所以叫 write
                int len = channel.read(buffer);
                // -1 代表没有内容了
                if (len == -1) {
                    break;
                }

                // flip 切换到 buffer 的读模式
                buffer.flip();
                // get 无参数代表就读一个字节
                while (buffer.hasRemaining()) {
                    byte b = buffer.get();
                    System.out.println((char) b);
                }
                // 切换到 buffer 的写模式
                buffer.clear();
            }
        } catch (IOException e) {

        }
    }
}
