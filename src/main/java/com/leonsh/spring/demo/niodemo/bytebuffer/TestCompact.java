package com.leonsh.spring.demo.niodemo.bytebuffer;

import com.leonsh.spring.demo.nettydemo.util.ByteBufferUtil;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

/**
 * TestCompact
 *
 * @author leonsh
 * @date 2021-12-27 15:36
 **/
public class TestCompact {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(16);
        buffer.put("abcd".getBytes(StandardCharsets.UTF_8));

        buffer.flip();
        System.out.println((char) buffer.get()); // a
        ByteBufferUtil.debugAll(buffer);

        buffer.compact();
        ByteBufferUtil.debugAll(buffer);
    }
}
