package com.leonsh.java.code.niodemo.channeldemo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

/**
 * DatagramDemo
 *
 * @author leonsh
 * @date 2021-12-31 09:50
 **/
public class DatagramDemo {
    public static void main(String[] args) throws IOException {
        DatagramChannel datagramChannel = DatagramChannel.open();
        datagramChannel.bind(new InetSocketAddress(8080));

        ByteBuffer buffer = ByteBuffer.allocate(16);
        datagramChannel.receive(buffer);

        printBuffer(buffer);
    }

    /**
     * 简单打印一下 buffer 中的内容
     *
     * @param buffer
     */
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
