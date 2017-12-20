package com.mybatistest.common.AspectController;

import com.mybatistest.Controller.baseClass.BaseController;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by zhang_jian on 2017/12/20.
 */
@Aspect
@Component
public class AspectUserCon extends BaseController{

    @Pointcut("execution(* com.mybatistest.Controller.UserController.*(..))")
    public void executionUserController() {

    }

    @Before("executionUserController()")
    public void beforeFunction() {
        logger.info("before Function ");
    }

    @After("executionUserController()")
    public void afterFuncion() {
        logger.info("after Function ");
    }
}
