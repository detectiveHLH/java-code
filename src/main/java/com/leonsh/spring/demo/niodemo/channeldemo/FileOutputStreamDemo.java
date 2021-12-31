package com.leonsh.spring.demo.niodemo.channeldemo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

/**
 * FileOutputStreamDemo
 *
 * @author leonsh
 * @date 2021-12-30 09:54
 **/
public class FileOutputStreamDemo {
    public static void main(String[] args) throws IOException {
        // 指定需要生成的文件名称
        String generateFileName = "generate-file.txt";
        // 创建一个输出流
        FileOutputStream fileOutputStream = new FileOutputStream(generateFileName);
        // 通过输出流获取到 channel
        FileChannel fileChannel = fileOutputStream.getChannel();

        // 准备好 ByteBuffer, 并向里面写入数据
        ByteBuffer buffer = ByteBuffer.allocate(16);
        buffer.put("shDEQuanZhanBiJi".getBytes(StandardCharsets.UTF_8));

        // 将 输入流 的 channel 的数据读入 buffer 中
        buffer.flip();
        fileChannel.write(buffer);

        fileChannel.close();
    }
}
