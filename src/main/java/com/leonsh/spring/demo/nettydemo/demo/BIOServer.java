package com.leonsh.spring.demo.nettydemo.demo;

import com.leonsh.spring.demo.nettydemo.util.ByteBufferUtil;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * BIOServer
 *
 * @author leonsh
 * @date 2021-12-22 17:51
 **/
public class BIOServer {
    public static void main(String[] args) throws IOException {
        // 打开 serverSocketChannel, 可以理解为现在服务器启起来了, 可以接受客户端的连接
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        // 绑定本机的 8080 端口
        serverSocketChannel.bind(new InetSocketAddress(8080));

        ByteBuffer buffer = ByteBuffer.allocate(32);
        while (true) {
            // 开始接收客户端的连接
            System.out.println("[BIOServer] waiting for connections...");
            SocketChannel socketChannel = serverSocketChannel.accept();
            System.out.println("[BIOServer] reading data from channel...");
            // 从这个通道将数据读入 buffer
            socketChannel.read(buffer);
            System.out.println("[BIOServer] data read complete.");
            printBuffer(buffer);
            buffer.clear();
        }
    }

    /**
     * 简单打印一下 buffer 中的内容
     * @param buffer
     */
    public static void printBuffer(ByteBuffer buffer) {
        System.out.print("BUFFER VALUE: ");
        for (int i = 0; i < buffer.limit(); i++) {
            if (buffer.get(i) == 0) {
                continue;
            }
            System.out.print((char)buffer.get(i));
        }
        System.out.println();
    }
}
