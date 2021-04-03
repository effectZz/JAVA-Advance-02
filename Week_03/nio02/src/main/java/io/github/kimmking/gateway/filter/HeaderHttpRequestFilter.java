package io.github.kimmking.gateway.filter;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpHeaders;

import java.util.List;
import java.util.Map;

import static io.netty.handler.codec.http.HttpResponseStatus.METHOD_NOT_ALLOWED;
import static io.netty.handler.codec.http.HttpResponseStatus.NOT_FOUND;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;

public class HeaderHttpRequestFilter implements HttpRequestFilter {

    @Override
    public void filter(FullHttpRequest fullRequest, ChannelHandlerContext ctx) {
        fullRequest.headers().set("mao", "soul");

        String uri = fullRequest.uri();
        System.out.println("uri: " + uri);
        //todo 不知道什么原因 访问url 回调用两次 "/favicon.ico"
        if ("/favicon.ico".equals(uri)) {
            DefaultFullHttpResponse response = new DefaultFullHttpResponse(HTTP_1_1, NOT_FOUND);
            ctx.write(response);
            ctx.flush();
            ctx.close();
        }

//        List<Map.Entry<String, String>> entries = fullRequest.headers().entries();
//        for (Map.Entry<String, String> entry : entries) {
//            System.out.println("getKey = " + entry.getKey());
//            System.out.println("getValue = " + entry.getValue());
//        }
//        System.out.println(fullRequest.method().name());
    }
}
