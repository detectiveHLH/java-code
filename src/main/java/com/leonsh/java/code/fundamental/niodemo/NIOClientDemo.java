package com.leonsh.java.code.fundamental.niodemo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * NIOClientDemo
 *
 * @author leonsh
 * @date 2021-12-30 19:15
 **/
public class NIOClientDemo {
    public static void main(String[] args) throws IOException {
        // 打开一个 SocketChannel
        SocketChannel socketChannel = SocketChannel.open();
        // 连接到 localhost 的 8080 端口
        socketChannel.connect(new InetSocketAddress("localhost", 8080));

        // 准备 ByteBuffer
        ByteBuffer buffer = ByteBuffer.allocate(16);
        buffer.put(Charset.defaultCharset().encode("test"));

        System.out.println("test");

        // 将 buffer 切换成读模式 & 向 channel 中写入数据
        buffer.flip();
        socketChannel.write(buffer);

    }
}
