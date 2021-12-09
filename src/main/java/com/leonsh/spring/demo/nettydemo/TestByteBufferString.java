package com.leonsh.spring.demo.nettydemo;

import com.leonsh.spring.demo.nettydemo.util.ByteBufferUtil;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

/**
 * 将字符串转换成 ByteBuffer
 *
 * @author leonsh
 * @date 2021-12-09 13:41
 **/
public class TestByteBufferString {
    public static void main(String[] args) {
        // 字符串转换成 ByteBuffer
        ByteBuffer buffer = ByteBuffer.allocate(16);
        buffer.put("hello".getBytes(StandardCharsets.UTF_8));
        ByteBufferUtil.debugAll(buffer);

        // 通过 charset
        ByteBuffer buffer2 = StandardCharsets.UTF_8.encode("hello");
        ByteBufferUtil.debugAll(buffer2);

        // 通过 wrap
        ByteBuffer buffer3 = ByteBuffer.wrap("hello".getBytes(StandardCharsets.UTF_8));
        ByteBufferUtil.debugAll(buffer3);
    }
}
