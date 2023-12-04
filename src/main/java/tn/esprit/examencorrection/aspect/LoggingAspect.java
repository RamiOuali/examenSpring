package tn.esprit.examencorrection.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LoggingAspect {
@After("execution(* tn.esprit.examencorrection.services.Services.*.get(..))")  //all methods in services that have get
public  void logMethodEnty(JoinPoint joinPoint){

    String name = joinPoint.getSignature().getName();
    log.info("bon Cou");
}
}

