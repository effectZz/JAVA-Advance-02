package io.github.kimmking.gateway.outbound.netty4;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.FullHttpRequest;

import java.util.List;

public class NettyHttpClientOutboundHandler  extends ChannelInboundHandlerAdapter {


    public NettyHttpClientOutboundHandler(List<String> proxyServer){

    }

    public void temp(final FullHttpRequest request, final ChannelHandlerContext ctx){

    }
    
    @Override
    public void channelActive(ChannelHandlerContext ctx)
            throws Exception {
        
        
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)
            throws Exception {
        
    }
}