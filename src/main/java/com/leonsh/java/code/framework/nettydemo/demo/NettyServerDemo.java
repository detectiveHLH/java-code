package com.leonsh.java.code.framework.nettydemo.demo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;

/**
 * NettyServerDemo
 *
 * @author leonsh
 * @date 2022-01-07 09:52
 **/
public class NettyServerDemo {
    public static void main(String[] args) {
        // 启动器, 负责组装 Netty 组件, 启动服务器
        new ServerBootstrap()
                // BossEventLoop
                .group(new NioEventLoopGroup())
                // 选择使用服务器的 ServerSocketChannel 的实现
                .channel(NioServerSocketChannel.class)
                // boss（也就是 group） 负责处理连接, worker 负责处理读写
                // childHandler 决定了 worker 能执行哪些操作
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    // head 处理器 -> 我们添加的 handler -> tail 处理器
                    protected void initChannel(NioSocketChannel nioSocketChannel) throws Exception {
                        // 将 ByteBuf 转换为字符串
                        nioSocketChannel.pipeline().addLast(new StringDecoder());
                        // 自定义 handler, 重写读事件, 并将读到的内容打印出来
                        nioSocketChannel.pipeline().addLast(new ChannelInboundHandlerAdapter() {
                            @Override
                            public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                                System.out.println(msg);
                            }
                        });
                    }
                })
                .bind(8080);
    }
}
