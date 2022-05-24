package com.leonsh.java.code.nettydemo.bytebuffer;

import com.leonsh.java.code.nettydemo.util.ByteBufferUtil;

import java.nio.ByteBuffer;

public class Test {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(16);
        buffer.put(new byte[]{'a', 'b', 'c', 'd'});
        buffer.put(new byte[]{'a', 'b', 'c', 'd'});
        buffer.put(new byte[]{'a', 'b', 'c', 'd'});
        buffer.put(new byte[]{'a', 'b', 'c', 'd'});
        System.out.println(buffer.hasRemaining());
        buffer.put(new byte[]{'s','h'});
        System.out.println(buffer.hasRemaining());
        ByteBufferUtil.debugAll(buffer);
    }
}
