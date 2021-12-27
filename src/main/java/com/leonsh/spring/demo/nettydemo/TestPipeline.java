package com.leonsh.spring.demo.nettydemo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import lombok.extern.slf4j.Slf4j;

/**
 * TestPipeline
 *
 * @author leonsh
 * @date 2021-12-27 09:45
 **/
@Slf4j
public class TestPipeline {
    public static void main(String[] args) {
        new ServerBootstrap()
                .group(new NioEventLoopGroup())
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel nioSocketChannel) throws Exception {
                        ChannelPipeline pipeline = nioSocketChannel.pipeline();
                        // 会自动添加 head、tail 两个 handler
                        // head -> h1 -> h2 -> h3 -> tail
                        pipeline.addLast("Handler 1", new ChannelInboundHandlerAdapter() {
                            @Override
                            public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                                log.debug("in channel 1 read");
                                super.channelRead(ctx, msg);
                            }
                        });
                        pipeline.addLast("Handler 2", new ChannelInboundHandlerAdapter() {
                            @Override
                            public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                                log.debug("in channel 2 read");
                                super.channelRead(ctx, msg);
                            }
                        });
                        pipeline.addLast("Handler 3", new ChannelInboundHandlerAdapter() {
                            @Override
                            public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                                log.debug("in channel 3 read");
                                super.channelRead(ctx, msg);
                            }
                        });
                    }
                })
                .bind(8080);
    }
}
