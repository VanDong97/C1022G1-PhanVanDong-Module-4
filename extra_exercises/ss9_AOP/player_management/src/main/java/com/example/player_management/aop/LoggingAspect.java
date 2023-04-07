package com.example.player_management.aop;

import com.example.player_management.dto.PlayerSoccerDTO;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    @Pointcut("execution(* com.example.player_management.controller.PlayerSoccerController.*(..))")
    public void loggingPerformRegisterPointCut(){

    }
    @Pointcut("execution(* com.example.player_management.controller.PlayerSoccerController.*(..))")
    public void loggingPerformUnsubscribePointCut(){

    }

    @AfterReturning(pointcut = "loggingPerformRegisterPointCut()")
    public void handleAfterReturningPerformRegister(JoinPoint joinPoint){
        String registerMethod = joinPoint.getSignature().getName();
        System.out.println("Cầu Thủ" + registerMethod + "đã đăng kí");
    }

    @AfterReturning(pointcut = "loggingPerformUnsubscribePointCut()")
    public void handleAfterReturningPerformUnsubscribe(JoinPoint joinPoint){
        String unsubscribeMethod = joinPoint.getSignature().getName();
        System.out.println("Cầu thủ" + unsubscribeMethod + "đã bị hủy");
    }

    @Pointcut("execution(* com.example.player_management.controller.PlayerSoccerController.*(..))")
    public void loggingPerformQuantityPointCut(){

    }

    @AfterReturning(pointcut = "loggingPerformQuantityPointCut()")
    public void handleAfterReturningPerformQuantity(JoinPoint joinPoint){
        String quantityMethod = joinPoint.getSignature().getName();
        System.out.println("Số lượng" + quantityMethod + "đã đăng kí");
    }
}
