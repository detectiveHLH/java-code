package com.leonsh.java.code.framework.nettydemo;

import com.leonsh.java.code.framework.nettydemo.util.ByteBufferUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;

/**
 * 服务器 demo
 * 使用 NIO 来理解阻塞模式, 当前这个 server 是在阻塞模式下运行的
 */
@Slf4j
public class Server {
    public static void main(String[] args) throws IOException {
        // 创建缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(16);

        // 相当于创建了服务器
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        // 绑定端口
        serverSocketChannel.bind(new InetSocketAddress(8080));

        // 创建连接集合
        List<SocketChannel> channels = new ArrayList<>();
        while (true) {
            log.info("connecting......");

            // accept 建立与客户端的连接, SocketChannel 用来与客户端进行通信
            // 调用 accept 时这里会阻塞住, 如果没有连接, 就会返回 null
            SocketChannel socketChannel = serverSocketChannel.accept();

            log.info("connected.");

            channels.add(socketChannel);

            for (SocketChannel channel : channels) {
                // 将客户端传过来的数据, 读入到 buffer 中
                log.info("before buffer read... {}", channel);
                // read 也会阻塞, 如果客户端一直没有发送
                channel.read(buffer);
                // 切换成 buffer 的读模式
                buffer.flip();
                // 打印当前 buffer 的情况
                ByteBufferUtil.debugAll(buffer);
                // 清空 buffer
                buffer.clear();

                log.info("after buffer read...{}", channel);
            }
        }
    }
}
