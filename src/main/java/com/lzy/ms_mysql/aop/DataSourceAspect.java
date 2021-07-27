package com.lzy.ms_mysql.aop;

import com.lzy.ms_mysql.annotation.DiyDataSource;
import com.lzy.ms_mysql.config.DataSourceHolder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
@Order(1)
public class DataSourceAspect {
    @Pointcut("execution(* com.lzy.ms_mysql.service..*.*(..))")
    public void service() {}

    @Before("service()")
    public void before(JoinPoint joinPoint) throws NoSuchMethodException {
        Object target = joinPoint.getTarget();
        String methodName = joinPoint.getSignature().getName();
        Class[] parameterTypes = ((MethodSignature)joinPoint.getSignature()).getMethod().getParameterTypes();
        Class clazz = target.getClass();
        Method m = clazz.getMethod(methodName, parameterTypes);
        if(m != null && m.isAnnotationPresent(DiyDataSource.class)) {
            DiyDataSource data = m.getAnnotation(DiyDataSource.class);
            String dataSourceName = data.value();
            DataSourceHolder.putDataSource(dataSourceName);
        }
    }

    @After("service()")
    public void after(JoinPoint joinPoint) {
        DataSourceHolder.clearDataSourceType();
    }
}
