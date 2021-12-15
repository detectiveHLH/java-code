package com.leonsh.spring.demo.nettydemo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * MultiThreadServer
 *
 * @author leonsh
 * @date 2021-12-15 09:56
 **/
public class MultiThreadServer {
    public static void main(String[] args) throws IOException {
        // 给主线程设置名称方便区分
        Thread.currentThread().setName("boss");

        // 创建 serverSocketChannel, 并绑定端口&设置为非阻塞
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.bind(new InetSocketAddress(8080));
        ssc.configureBlocking(false);

        // 创建 selector
        Selector boss = Selector.open();
        SelectionKey bossKey = ssc.register(boss, 0, null);
        bossKey.interestOps(SelectionKey.OP_ACCEPT);

        while (true) {
            boss.select();
            Iterator<SelectionKey> iterator = boss.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                iterator.remove();

                // boss 只负责建立连接, work 线程负责读写
                if (key.isAcceptable()) {
                    SocketChannel sc = ssc.accept();
                    sc.configureBlocking(false);
                }
            }
        }
    }

    class Worker implements Runnable {
        private Thread thread;
        private Selector worker;
        private String name;

        public Worker(String name) {
            this.name = name;
        }

        // 初始化线程和 selector
        public void register() throws IOException {
            thread = new Thread(this, name);
            thread.start();
            worker = Selector.open();
        }

        @Override
        public void run() {
            while (true) {
                try {
                    worker.select();
                    Iterator<SelectionKey> iterator = worker.selectedKeys().iterator();
                    while (iterator.hasNext()) {
                        SelectionKey key = iterator.next();
                        iterator.remove();

                        if (key.isReadable()) {
                            ByteBuffer buffer = ByteBuffer.allocate(16);
                            SocketChannel channel = (SocketChannel) key.channel();
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
