package com.leonsh.spring.demo.nettydemo;

import com.leonsh.spring.demo.nettydemo.util.ByteBufferUtil;
import lombok.extern.slf4j.Slf4j;

import java.nio.ByteBuffer;

/**
 * TestByteBufferReadWrite
 *
 * @author leonsh
 * @date 2021-12-08 19:49
 **/
@Slf4j
public class TestByteBufferReadWrite {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        // 写入一个 a 字符
        buffer.put((byte) 0x61);
        ByteBufferUtil.debugAll(buffer);
        // 写入 b,c,d 字符
        buffer.put(new byte[]{0x62, 0x63, 0x64});
        ByteBufferUtil.debugAll(buffer);

        // 这里由于还是在写模式, 是获取不到任何东西的
//        log.info("{}", (char) buffer.get());

        // 切换到读模式
        buffer.flip();
        log.info("{}", (char) buffer.get());
        ByteBufferUtil.debugAll(buffer);

        // compact 会将没有读的数据移动到前面去
        buffer.compact();
        ByteBufferUtil.debugAll(buffer);

        buffer.put(new byte[]{0x65, 0x66});
        ByteBufferUtil.debugAll(buffer);


    }
}
