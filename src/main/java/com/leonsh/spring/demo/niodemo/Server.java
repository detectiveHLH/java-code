package com.leonsh.spring.demo.niodemo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;

/**
 * Server
 *
 * @author leonsh
 * @date 2021-12-01 10:14
 **/
public class Server {
    private int remoteClientNum = 0;
    private Selector selector;
    private ByteBuffer byteBuffer;
    private int bufferSize = 1024;
    private ServerSocketChannel serverSocketChannel;

    public Server(int port) {
        try {
            initChannel(port);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initChannel(int port) throws Exception {
        // 创建 serverSocketChannel
        serverSocketChannel = ServerSocketChannel.open();
        // 设置为非阻塞模式
        serverSocketChannel.configureBlocking(false);
        // 绑定端口
        serverSocketChannel.bind(new InetSocketAddress(port));

        System.out.println("server is listening on port: " + port);

        // 创建 selector
        selector = Selector.open();
        // 把 channel 注册到 selector 上去
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        // 分配 buffer 的大小
        byteBuffer = ByteBuffer.allocate(bufferSize);
    }

    private void listener() throws Exception {
        while (true) {
            int readyChannelCount = selector.select();
            if (readyChannelCount == 0) {
                continue;
            }

            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();

                // 如果这个 selectionKey 处于连接就绪状态, 则开始接收客户端的连接
                if (key.isAcceptable()) {
                    // 拿到对应的 channel
                    ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    registerChannel(selector, socketChannel, SelectionKey.OP_READ);
                    remoteClientNum++;
                    System.out.println("online client num=" + remoteClientNum);
                    write(socketChannel, "hello client".getBytes(StandardCharsets.UTF_8));
                }

                if (key.isReadable()) {
                    read(key);
                }

                iterator.remove();
            }
        }
    }

    private void read(SelectionKey key) throws Exception {
        SocketChannel socketChannel = (SocketChannel) key.channel();
        int count;
        byteBuffer.clear();
        while ((count = socketChannel.read(byteBuffer)) > 0) {
            byteBuffer.flip();
            while (byteBuffer.hasRemaining()) {
                System.out.println((char) byteBuffer.get());
            }
            byteBuffer.clear();
        }
        if (count < 0) {
            socketChannel.close();
        }
    }

    private void write(SocketChannel socketChannel, byte[] writeData) throws IOException {
        byteBuffer.clear();
        byteBuffer.put(writeData);
        byteBuffer.flip();
        socketChannel.write(byteBuffer);
    }

    private void registerChannel(Selector selector, SocketChannel socketChannel, int opRead) throws Exception {
        if (socketChannel == null) {
            return;
        }

        socketChannel.configureBlocking(false);
        socketChannel.register(selector, opRead);
    }

    public static void main(String[] args) {
        try {
            Server server = new Server(9999);
            server.listener();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
