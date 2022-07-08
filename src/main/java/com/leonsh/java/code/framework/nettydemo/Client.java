package com.leonsh.java.code.framework.nettydemo;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

/**
 * 客户端 demo
 */
@Slf4j
public class Client {
    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("localhost", 8080));

        ByteBuffer buffer = ByteBuffer.allocate(16);
        buffer.put("test".getBytes(StandardCharsets.UTF_8));

        buffer.flip();
        socketChannel.write(buffer);
        // 如果这里一直没有返回, 一直没有发送数据, 服务端的 buffer read 也会阻塞住
        log.info("waiting...");
    }
}
