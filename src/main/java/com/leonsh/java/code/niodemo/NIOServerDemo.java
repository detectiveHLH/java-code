package com.leonsh.java.code.niodemo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * NIOServerDemo
 *
 * @author leonsh
 * @date 2021-12-30 18:28
 **/
public class NIOServerDemo {
    public static void main(String[] args) throws IOException {
        // 打开一个 ServerSocketChannel
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        // 绑定 8080 端口
        serverSocketChannel.bind(new InetSocketAddress(8080));

        // 开始接受客户端连接
        SocketChannel socketChannel = serverSocketChannel.accept();
        // 获取连接成功
        System.out.printf("socketChannel %s connected\n", socketChannel);
        // 准备 ByteBuffer 以从 socketChannel 中读取数据
        ByteBuffer buffer = ByteBuffer.allocate(16);

        // 开始读取数据
        System.out.println("before read");
        int read = socketChannel.read(buffer);
        System.out.printf("read complete, read bytes length: %s \n", read);

//        ByteBufferUtil.debugAll(buffer);
        printBuffer(buffer);
    }

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
