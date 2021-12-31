package com.leonsh.spring.demo.niodemo.channeldemo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.charset.Charset;

/**
 * DatagramClientDemo
 *
 * @author leonsh
 * @date 2021-12-31 09:56
 **/
public class DatagramClientDemo {
    public static void main(String[] args) throws IOException {
        DatagramChannel datagramChannel = DatagramChannel.open();

        // 构建 buffer 数据
        ByteBuffer buffer = ByteBuffer.allocate(16);
        buffer.put(Charset.defaultCharset().encode("test"));

        // 切换到 buffer 的读模式
        buffer.flip();
        datagramChannel.send(buffer, new InetSocketAddress("localhost", 8080));
    }
}
