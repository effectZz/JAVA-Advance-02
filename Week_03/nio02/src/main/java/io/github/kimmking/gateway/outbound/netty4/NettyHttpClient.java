package io.github.kimmking.gateway.outbound.netty4;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.*;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;

import static io.netty.handler.codec.http.HttpResponseStatus.NO_CONTENT;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;
import static io.netty.handler.codec.http.HttpResponseStatus.OK;

public class NettyHttpClient {
    public void connect(String host, int port) throws Exception {
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            Bootstrap b = new Bootstrap();
            b.group(workerGroup);
            b.channel(NioSocketChannel.class);
            b.option(ChannelOption.SO_KEEPALIVE, true);
            b.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                public void initChannel(SocketChannel ch) throws Exception {
                    // 客户端接收到的是httpResponse响应，所以要使用HttpResponseDecoder进行解码
                    ch.pipeline().addLast(new HttpResponseDecoder());
//                     客户端发送的是httprequest，所以要使用HttpRequestEncoder进行编码
                    ch.pipeline().addLast(new HttpRequestEncoder());
                    ch.pipeline().addLast(new NettyHttpClientOutboundHandler(new ArrayList<>()));
                }
            });

            // Start the client.
            ChannelFuture f = b.connect(host, port).sync();

            FullHttpResponse response = null;
            try {
                String value = "hello,6666666666666";
                response = new DefaultFullHttpResponse(HTTP_1_1, OK, Unpooled.wrappedBuffer(value.getBytes("UTF-8")));
                response.headers().set("Content-Type", "text/html;charset=UTF-8");
                response.headers().setInt("Content-Length", response.content().readableBytes());
            } catch (Exception e) {
                e.printStackTrace();
                response = new DefaultFullHttpResponse(HTTP_1_1, NO_CONTENT);
            } finally {
                f.channel().write(response);
                f.channel().flush();
                f.channel().closeFuture().sync();
            }


        } finally {
            workerGroup.shutdownGracefully();
        }

    }

    public static void main(String[] args) throws Exception {
        NettyHttpClient client = new NettyHttpClient();
        client.connect("127.0.0.1", 8808);
    }
}