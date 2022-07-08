package com.leonsh.java.code.fundamental.niodemo.bytebuffer;

import com.leonsh.java.code.framework.nettydemo.util.ByteBufferUtil;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

/**
 * 将多个 ByteBuffer 组合到一起, 一次性的写入到文件中
 * 避免了多次的文件数据拷贝
 *
 * @author leonsh
 * @date 2021-12-09 13:55
 **/
public class TestGatheringWrites {
    public static void main(String[] args) {
        ByteBuffer buffer1 = StandardCharsets.UTF_8.encode("hello");
        ByteBuffer buffer2 = StandardCharsets.UTF_8.encode("world");
        // 你好一共是 6 个字节, 汉字一个是占用 3 个字节
        ByteBuffer buffer3 = StandardCharsets.UTF_8.encode("你好");

        try (FileChannel channel = new RandomAccessFile("word2.txt", "rw").getChannel()) {
            channel.write(new ByteBuffer[]{buffer1, buffer2, buffer3});
            ByteBufferUtil.debugAll(buffer1);
            ByteBufferUtil.debugAll(buffer2);
            ByteBufferUtil.debugAll(buffer3);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
