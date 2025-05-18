package com.example.springboottest.demo.aop;

import com.example.springboottest.annotation.SpelA;
import com.example.springboottest.entity.Payment;
import com.example.springboottest.enums.DefaultStatus;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Author: Ryan
 * @Date: 2024/11/13 10:26
 * @Version: 1.0
 * @Description: spel 测试切面类
 */
@Slf4j
@Aspect
@Component
public class SpelAspect {

    // spel 表达式解析器
    private final ExpressionParser parser = new SpelExpressionParser();

    @Pointcut("@annotation(com.example.springboottest.annotation.SpelA)")
    public void pointCut() {

    }

    @Before("pointCut()")
    public void before(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();

        SpelA spelA = method.getAnnotation(SpelA.class);

        // 构建上下文参数，把方法中的参数属性放入上下文并命名
        StandardEvaluationContext context = new StandardEvaluationContext();

        Object[] args = joinPoint.getArgs();

        for (int i = 0; i < args.length; i++) {
            context.setVariable("p" + i, args[i]);
        }

        // 通过 Spel 表达式把数据取出来
        String strVal = parser.parseExpression(spelA.strVaule()).getValue(context, String.class);
        Integer intVal = parser.parseExpression(spelA.intValue()).getValue(context, Integer.class);
        Boolean booVal = parser.parseExpression(spelA.booValue()).getValue(context, Boolean.class);
        DefaultStatus enumVal = parser.parseExpression(spelA.enumValue()).getValue(context, DefaultStatus.class);
        Payment objVal = parser.parseExpression(spelA.objValue()).getValue(context, Payment.class);
        Boolean strCompareVal = parser.parseExpression(spelA.strCompareValue()).getValue(context, Boolean.class);
        Boolean enumCompareVal = parser.parseExpression(spelA.enumComparevalue()).getValue(context, Boolean.class);

        log.info("strVal:{}, intVal:{} booVal:{}, enumVal:{}, objVal:{}, strCompareVal:{}, enumCompareVal:{}",
                strVal, intVal, booVal, enumVal, objVal, strCompareVal, enumCompareVal);


    }

}
