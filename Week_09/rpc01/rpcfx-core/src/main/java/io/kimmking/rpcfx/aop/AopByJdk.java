package io.kimmking.rpcfx.aop;

import io.kimmking.rpcfx.client.RpcfxInvocationHandler;

import java.lang.reflect.Proxy;

/**
 * @author：ZhaoWenXin
 * @date：2021-05-27 14:24
 */
public class AopByJdk {


    public static <T> T newCreate(Class<T> serviceClass, String url) {
        ClassLoader loader = AopByJdk.class.getClassLoader();
        Class[] classes = new Class[]{serviceClass};
        return (T) Proxy.newProxyInstance(loader, classes, new RpcfxInvocationHandler(serviceClass, url));
    }
}
