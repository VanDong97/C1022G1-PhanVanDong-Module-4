package com.example.player_management.aop;

import com.example.player_management.dto.PlayerSoccerDTO;
import com.example.player_management.model.PlayerSoccer;
import com.example.player_management.service.IPlayerSoccerService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.List;

@Component
@Aspect
public class LoggingAspect {

    @Autowired
    private IPlayerSoccerService iPlayerSoccerService;

    @Pointcut("execution(* com.example.player_management.controller.PlayerSoccerController.*(..))")
    public void loggingPerformRegisterPointCut() {

    }

    @Pointcut("execution(* com.example.player_management.controller.PlayerSoccerController.*(..))")
    public void loggingPerformUnsubscribePointCut() {

    }

    @AfterReturning(pointcut = "loggingPerformRegisterPointCut()")
    public void handleAfterReturningPerformRegister(JoinPoint joinPoint) {
        String registerMethod = joinPoint.getSignature().getName();
        System.out.println("Cầu Thủ" + registerMethod + "đã đăng kí");
    }

    @AfterReturning(pointcut = "loggingPerformUnsubscribePointCut()")
    public void handleAfterReturningPerformUnsubscribe(JoinPoint joinPoint) {
        String unsubscribeMethod = joinPoint.getSignature().getName();
        System.out.println("Cầu thủ" + unsubscribeMethod + "đã bị hủy");
    }

    @Pointcut("execution(* com.example.player_management.controller.PlayerSoccerController.*(..))")
    public void loggingPerformQuantityPointCut() {

    }

    @AfterReturning(pointcut = "loggingPerformQuantityPointCut()")
    public void handleAfterReturningPerformQuantity(JoinPoint joinPoint) {
        List<PlayerSoccer> list = iPlayerSoccerService.footballTeam();
        int number = list.size();
        String methodName = joinPoint.getSignature().getName();
        try {
            File file = new File("E:\\\\Module 4\\extra_exercises\\ss9_AOP\\player_management\\src\\main\\java\\com\\example\\player_management\\file\\football.txt");
            FileInputStream fileInputStream = new FileInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream));
            String line;
            if ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            File file = new File("E:\\Module 4\\extra_exercises\\ss9_AOP\\player_management\\src\\main\\java\\com\\example\\player_management\\file\\football.txt");
            FileOutputStream outputStream = new FileOutputStream(file, true);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
            writer.write(methodName + " Số lượng cầu thủ đăng ký đá : " + number + "\n");
            writer.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
