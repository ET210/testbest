package com.cyy.aop;

import com.cyy.annotation.Idempotent;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/**
 * @author:CYY
 * @create: 2023-05-30 20:26:44
 * @Description:
 */
@Aspect
@Component
public class IdempotentAspect {
    private final RedisTemplate redisTemplate;

    @Autowired
    public IdempotentAspect(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Around("@annotation(com.cyy.annotation.Idempotent)")
    public Object process(ProceedingJoinPoint pjp) throws Throwable {
        //获取请求参数
        Object[] args = pjp.getArgs();
        //获取请求方法
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = signature.getMethod();
        //获取注解信息
        Idempotent idempotent = method.getAnnotation(Idempotent.class);
        String key = getKey(pjp);
        //检查Redis中是否有该key
        if (redisTemplate.hasKey(key)) {
            throw new RuntimeException("请勿重复提交！");
        }

        //标记请求已经处理过
        redisTemplate.opsForValue().set(key, "1", idempotent.expire(), TimeUnit.MILLISECONDS);

        //处理请求
        return pjp.proceed(args);
    }

    /*
     * 获取redis key方法
     *
     * */
    public String getKey(ProceedingJoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        String methodName = method.getName();
        String className = joinPoint.getTarget().getClass().getSimpleName();
        Object[] args = joinPoint.getArgs();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(className).append(":").append(methodName);
        for (Object arg : args) {
            stringBuilder.append(":").append(arg.toString());
        }
        return stringBuilder.toString();

    }

}
