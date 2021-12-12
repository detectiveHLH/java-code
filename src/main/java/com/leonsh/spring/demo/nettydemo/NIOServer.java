package com.leonsh.spring.demo.nettydemo;

import com.leonsh.spring.demo.nettydemo.util.ByteBufferUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;

/**
 * 当前服务器是运行在非阻塞模式下
 */
@Slf4j
public class NIOServer {
    public static void main(String[] args) throws IOException {
        // 创建缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(16);

        // 相当于创建了服务器
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        // 绑定端口
        serverSocketChannel.bind(new InetSocketAddress(8080));
        // 设置成非阻塞模式
        serverSocketChannel.configureBlocking(false);

        // 创建连接集合
        List<SocketChannel> channels = new ArrayList<>();
        while (true) {
            // 这里 accept 就不会阻塞了
            SocketChannel socketChannel = serverSocketChannel.accept();
            if (socketChannel != null) {
                log.info("connected...{}", socketChannel);
                socketChannel.configureBlocking(false);
                channels.add(socketChannel);
            }

            for (SocketChannel channel : channels) {
                int read = channel.read(buffer);
                if (read == 0) {
                    continue;
                }

                // 将客户端传过来的数据, 读入到 buffer 中
                log.info("before buffer read... {}", channel);
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
