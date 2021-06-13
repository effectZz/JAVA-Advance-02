package io.kimmking.rpcfx.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author：ZhaoWenXin
 * @date：2021-05-26 17:13
 */
@Aspect
@Component
public class CreateAop {

    private final Logger logger =LoggerFactory.getLogger(CreateAop.class);


//    @Pointcut("execution(public * io.kimmking.rpcfx.client.Rpcfx.createAop(..)) )")
    @Pointcut("execution(public * io.kimmking.rpcfx.client..*.*(..)) )")
    public void point(){}

    @Around(value = "point()")
    public <T> T around(ProceedingJoinPoint joinPoint) throws Throwable {
        //获取方法参数值数组
        Object[] args = joinPoint.getArgs();
        //得到其方法签名
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        //获取方法参数类型数组
        Class[] paramTypeArray = methodSignature.getParameterTypes();


        for (Class aClass : paramTypeArray) {
        }
        Object proceed = joinPoint.proceed();
        System.out.println("proceed = " + proceed);

        logger.info("请求参数为{}",args);
        //动态修改其参数
        //注意，如果调用joinPoint.proceed()方法，则修改的参数值不会生效，必须调用joinPoint.proceed(Object[] args)
        Object result = joinPoint.proceed(args);
        logger.info("响应结果为{}",result);
        //如果这里不返回result，则目标对象实际返回值会被置为null
        return (T)result;
    }

}
