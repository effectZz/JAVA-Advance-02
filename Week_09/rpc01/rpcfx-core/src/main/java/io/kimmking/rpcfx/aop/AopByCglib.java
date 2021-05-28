package io.kimmking.rpcfx.aop;

import io.kimmking.rpcfx.client.RpcfxInvocationHandler;
import org.springframework.cglib.proxy.Enhancer;

import java.lang.reflect.Proxy;

/**
 * @author：ZhaoWenXin
 * @date：2021-05-27 15:26
 */
public class AopByCglib {

    public static <T> T newCreate(Class<T> serviceClass, String url) {
        Enhancer enhancer = new Enhancer();
        enhancer.setCallback(new RpcfxInvocationHandler(serviceClass, url));
        enhancer.setSuperclass(serviceClass);
        return (T) enhancer.create();
    }
}
