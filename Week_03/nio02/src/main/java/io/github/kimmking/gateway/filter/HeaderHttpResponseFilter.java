package io.github.kimmking.gateway.filter;

import io.netty.handler.codec.http.FullHttpResponse;

import static io.netty.handler.codec.http.HttpResponseStatus.RESET_CONTENT;

public class HeaderHttpResponseFilter implements HttpResponseFilter {
    @Override
    public void filter(FullHttpResponse response) {
        response.headers().set("kk", "java-1-nio");
        //添加过滤 ,如果响应头不包含 secret
        if (!response.headers().names().contains("secret")){
            response.setStatus(RESET_CONTENT);
        }
    }
}
