//package com.example.demo.database.aspect;
//
//import com.example.demo.database.ManagementCenter;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//import java.util.Map;
//
//
//@Aspect
//@Component
//public class SwAspect {
//
//    @Autowired
//    ManagementCenter managementCenter;
//
//    @Pointcut("@annotation(com.example.demo.database.annotation.SwAnnotation)")
//    public void sw(){};
//
//    @Around("sw()")
//    public void setDatabaseSource(ProceedingJoinPoint point) throws Throwable {
//        Object[] argv = point.getArgs();
//        argv[0] = managementCenter.getSlaveDataSource();
//        point.proceed(argv);
//    }
//}
