package com.leonsh.java.code.niodemo.bytebuffer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * 通过 fileChannel 完成数据传输, 通过 transferTo 转移数据的效率较高
 * 带了 transferTo 的, 都会使用操作系统的零拷贝进行优化, 简洁、效率高
 * transferTo 最多只能传输 2G 的数据, 如果传输的数据大于 2G, 可以多次传输
 *
 * @author leonsh
 * @date 2021-12-10 10:00
 **/
public class TestFileChannelTransferTo {
    public static void main(String[] args) {
        try (
                FileChannel from = new FileInputStream("data.txt").getChannel();
                FileChannel to = new FileOutputStream("to.txt").getChannel();
        ) {
            from.transferTo(0, from.size(), to);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}