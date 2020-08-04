package com.example.demo.aop.utils;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
public class PointCutConfig {

	
	@Pointcut(value="execution(* com.example.demo.*.*.*(..))")
	public void logging() {}
}
