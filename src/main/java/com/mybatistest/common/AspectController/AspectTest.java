package com.mybatistest.common.AspectController;

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
public class AspectTest {

    private Logger logger = LoggerFactory.getLogger(AspectTest.class.getName());
    @Pointcut("execution(* com.mybatistest.Controller.*.*(..))")
    public void executionServer() {

    }

    @Before("executionServer()")
    public void testAOP() {
        logger.info("testAOP111");
    }
}
