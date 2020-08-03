package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.example.demo.entity.CibilScore;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class CibilScoreServiceApplication {

	public static void main(String[] args) {
	ConfigurableApplicationContext ctx=	SpringApplication.run(CibilScoreServiceApplication.class, args);
	
	   // CibilScore score =(CibilScore) ctx.getBean("cibilScore");

	//    CibilScore score = ctx.getBean(CibilScore.class);

         CibilScore score = ctx.getBean("shyamScore",CibilScore.class);

	    log.info(score.toString());
	    
	}


	@Bean
	public CibilScore ramScore() {
		
		// Setter DI
		
	   CibilScore score = new CibilScore();
	   
	       score.setId(20);
	       score.setPanNumber("aa11");
	       
	       return score;
	}
	
	@Bean
	public CibilScore shyamScore() {
		
		// Constructor DI
		
	   CibilScore score = new CibilScore(202,"bb22","Shyam",549);
	   
	      
	       
	       return score;
	}
	
}
