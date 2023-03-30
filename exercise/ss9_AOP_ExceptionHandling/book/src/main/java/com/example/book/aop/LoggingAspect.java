package com.example.book.aop;

import com.example.book.controller.BookController;
import com.example.book.dto.BookDTO;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    @Pointcut("execution(* com.example.book.controller.BookController.performBorrow(..))")
    public void loggingPerformBorrowPointCut(){
    }
    @Pointcut("execution(* com.example.book.controller.BookController.performGiveBack(..))")
    public void loggingPerformGiveBackPointCut() {}

    @AfterReturning(pointcut = "loggingPerformBorrowPointCut()")
    public void handleAfterReturningPerformBorrow(JoinPoint joinPoint) {
        BookDTO bookDTO = ((BookController)joinPoint.getTarget())
                .ibookService.findById(((Integer) joinPoint.getArgs()[0]).intValue());
        System.out.println("Sach "+ bookDTO.getTitle() + " da bi muon di 1, con lai: "
                + bookDTO.getQuantity() +" quyen sach");
    }

    @AfterReturning(pointcut = "loggingPerformGiveBackPointCut()")
    public void handleAfterReturningPerformGiveBack(JoinPoint joinPoint1) {
        BookDTO bookDTO = ((BookController)joinPoint1.getTarget())
                .ibookService.findById(((Integer) joinPoint1.getArgs()[1]).intValue());
        System.out.println("Sach "+ bookDTO.getTitle() + " da bi tra lai 1, con lai: "
                + bookDTO.getQuantity() +" quyen sach");
    }
}
