package com.leonsh.spring.demo.nettydemo;

import com.leonsh.spring.demo.nettydemo.util.ByteBufferUtil;
import io.netty.buffer.ByteBuf;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Slf4j
public class SelectorServer {
    public static void main(String[] args) throws IOException {
        // 创建 selector, 管理多个 channel
        Selector selector = Selector.open();

        // 创建 ByteBuffer
        ByteBuffer buffer = ByteBuffer.allocate(16);
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.bind(new InetSocketAddress(8080));

        // 将 channel 注册到 selector 上
        // 因为是一个 selector 管理多个 channel, 所以这里的 selectionKey 是代表哪个 channel, 0 表示不关注任何事件
        SelectionKey serverSocketChannelKey = serverSocketChannel.register(selector, 0, null);
        // 由于总共有 4 种事件, 分别是 accept、connect、read 和 write,
        // 分别代表有连接请求时触发、客户端建立连接时触发、可读事件、可写事件
        // 我们可以使用 interestOps 来表明只处理有连接请求的事件
        serverSocketChannelKey.interestOps(SelectionKey.OP_ACCEPT);

        log.info("register key: {}", serverSocketChannel);

        List<SocketChannel> channels = new ArrayList<>();
        while (true) {
            // 没有事件发生, 线程会阻塞; 有事件发生, 就会让线程继续执行
            selector.select();
            // 换句话说, 有连接过来了, 就会继续往下走

            // 通过 selectedKeys 包含了所有发生的事件, 可能会包含 READ 或者 WRITE
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                log.info("key: {}", key);

                // 这里需要进行事件区分
                if (key.isAcceptable()) {
                    // 触发此次事件的 channel, 拿到事件一定要处理, 否则会进入非阻塞模式, 空转占用 CPU
                    // 例如你可以使用 key.cancel()
                    ServerSocketChannel channel = (ServerSocketChannel) key.channel();
                    SocketChannel socketChannel = channel.accept();
                    socketChannel.configureBlocking(false);

                    // 这个 socketChannel 也需要注册到 selector 上, 相当于把控制权交给 selector
                    SelectionKey socketChannelKey = socketChannel.register(selector, 0, null);
                    socketChannelKey.interestOps(SelectionKey.OP_READ);
                    log.info("{}", socketChannel);
                } else if (key.isReadable()) {
                    SocketChannel channel = (SocketChannel) key.channel();
                    ByteBuffer buf = ByteBuffer.allocate(16);
                    channel.read(buf);
                    buf.flip();
                    ByteBufferUtil.debugRead(buf);
                }

            }
        }
    }
}
