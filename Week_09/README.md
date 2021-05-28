##### 尝试将服务端写死查找接口实现类变成泛型和反射

添加了@Component 注入到Bean。

添加了ApplicationContext 自动装配。

使用applicationContext.getBean(serviceClass)；获取实现类。

路径：src\main\java\io\kimmking\rpcfx\server\RpcfxInvoker.java





##### 改写客户端动态代理改成 AOP

1.单独把内部静态类 RpcfxInvocationHandler 抽离出来。

2.为了使用Cglib方式则实现了MethodInterceptor接口。

3.把调用请求方法单独抽离出来intercept();，方便动态代理和Cglib方式。

4.在Rpcfx类里创建create0方法作为Cglib方式(可以不用新建，这里偷懒了)。

路径：src\main\java\io\kimmking\rpcfx\aop 

​			src\main\java\io\kimmking\rpcfx\client





##### 尝试使用 Netty+HTTP 作为 client 端传输方式

创建了EchoClient作为客户端的类。

Netty有些不太会写了。。。、、

路径：src\main\java\io\kimmking\rpcfx\client\EchoClient.java



