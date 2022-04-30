package com.spring.We_Fly_Project.Aspect;

import com.spring.We_Fly_Project.Controllers.AdminController;
import com.spring.We_Fly_Project.DB_Repository.DTO.InfoLogger;
import com.spring.We_Fly_Project.DB_Repository.Service.InfoLoggerService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
@Aspect
public class AspectManager {
    @Autowired
    InfoLoggerService logService;

    @Pointcut("execution(* com.spring.We_Fly_Project.Controllers.*.add*(..))")
    public void allAddMethod() {
        System.out.println("allAddMethods");
    }


    public void bbb(){
        System.out.println("TESTINGINGINGG");
    }
    @Around("execution(* com.spring.We_Fly_Project.Controllers.*.add*(..))")
    public void myAdviceMethod(ProceedingJoinPoint pjp) throws Throwable {
        String message = pjp.getSignature().getDeclaringTypeName();
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm:ss");
        String currentTime = myDateObj.format(myFormatObj);
        long id = AdminController.logID;
        AdminController.incrementLogId();
        logService.addLog(new InfoLogger(id,currentTime,message));
        System.out.println("log added");
    }
}

