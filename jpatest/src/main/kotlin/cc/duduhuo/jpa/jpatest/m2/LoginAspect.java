package cc.duduhuo.jpa.jpatest.m2;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * =======================================================
 * Author: liying - liruoer2008@yeah.net
 * Datetime: 2018/12/9 18:05
 * Description:
 * Remarks:
 * =======================================================
 */
@Aspect
@Component
@Order(100)
public class LoginAspect {
    private final Logger logger = LoggerFactory.getLogger(LoginAspect.class);

    @Pointcut("execution(@LoginRequired * *(..))")
    public void loginRequired() {
    }


    @Before("loginRequired()||CurrentUserAspect.currentUser()||OpLogAspect.opLog()")
    public void checkLogin(JoinPoint joinPoint) {
        logger.info("===checkLogin===");
    }
}
