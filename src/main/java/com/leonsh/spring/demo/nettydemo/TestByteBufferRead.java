package com.leonsh.spring.demo.nettydemo;

import com.leonsh.spring.demo.nettydemo.util.ByteBufferUtil;
import lombok.extern.slf4j.Slf4j;

import java.nio.ByteBuffer;

/**
 * TestByteBufferRead
 *
 * @author leonsh
 * @date 2021-12-09 10:13
 **/
@Slf4j
public class TestByteBufferRead {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.put(new byte[]{'a', 'b', 'c', 'd'});

        // 切换到读模式
        buffer.flip();
        ByteBufferUtil.debugAll(buffer);


        byte[] dst = new byte[4];
        // 将 buffer 中的数据写入 dst
        buffer.get(dst);
        // 这个地方的下标会移动
        ByteBufferUtil.debugAll(buffer);
//        log.info("{}", dst);

        // 调用 rewind 开始重头读取
        buffer.rewind();
        // position 此时又变成了 0, limit 变成了 4, 又可以开始读了
        ByteBufferUtil.debugAll(buffer);

        // 接下来开始是 mark 和 reset 的使用
        log.info("{}", (char) buffer.get());
        log.info("{}", (char) buffer.get());
        ByteBufferUtil.debugAll(buffer);
        // 给当前的 position 加了哥标记
        buffer.mark();
        log.info("{}", (char) buffer.get());
        log.info("{}", (char) buffer.get());
        // 将 position 重置到刚刚打标记的位置
        buffer.reset();
        // 这两应该会打印出 c 和 d
        log.info("{}", (char) buffer.get());
        log.info("{}", (char) buffer.get());

        // get() 会改变当前 buffer 中的下标
        // get(i) 不会改变当前 buffer 的下标, 只会按照索引去找
    }
}
