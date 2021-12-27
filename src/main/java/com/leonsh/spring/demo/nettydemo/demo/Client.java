package com.leonsh.spring.demo.nettydemo.demo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * Client
 *
 * @author leonsh
 * @date 2021-12-22 18:09
 **/
public class Client {
    public static void main(String[] args) throws Exception {
        // 这里可以理解为初始化对 localhost:8080 的连接
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("localhost", 8080));

        // 这里模拟数据的准备
        System.out.println("[Client] preparing data...");
//        Thread.sleep(15000);
        System.out.println("[Client] prepare data complete, ready to send data.");

        // 将要发送给服务器的数据写入 ByteBuffer 中
//        ByteBuffer buffer = StandardCharsets.UTF_8.encode("abc");
        // 向 channel 中写入数据
//        socketChannel.write(buffer);
        System.out.println("[Client] data send complete.");
    }
}
