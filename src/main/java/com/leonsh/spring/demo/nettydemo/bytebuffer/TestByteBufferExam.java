package com.leonsh.spring.demo.nettydemo.bytebuffer;

import com.leonsh.spring.demo.nettydemo.util.ByteBufferUtil;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

/**
 * TestByteBufferExam
 *
 * @author leonsh
 * @date 2021-12-09 14:08
 **/
public class TestByteBufferExam {
    public static void main(String[] args) {
        ByteBuffer source = ByteBuffer.allocate(32);
        source.put("Hello,world\nI'm zhangsan\nHo".getBytes(StandardCharsets.UTF_8));
        split(source);
        source.put("w are you?\n".getBytes(StandardCharsets.UTF_8));
        split(source);
    }

    // 这个处理黏包、半包的方式效率较低,
    private static void split(ByteBuffer source) {
        // 切换成读模式, get(i) 不会造成 position 的位移
        source.flip();
        for (int i = 0; i < source.limit(); i++) {
            if (source.get(i) == '\n') {
                int length = i + 1 - source.position();
                ByteBuffer target = ByteBuffer.allocate(length);
                for (int j = 0; j < length; j++) {
                    target.put(source.get());
                }
                ByteBufferUtil.debugAll(target);
            }
        }

        // 没有读的, 留给下条数据
        source.compact();
    }
}
