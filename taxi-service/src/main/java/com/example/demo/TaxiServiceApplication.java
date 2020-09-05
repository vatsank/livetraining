package com.example.demo;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

import com.example.demo.model.Driver;
import com.example.demo.model.Taxi;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class TaxiServiceApplication {

	public static void main(String[] args) {
	
		ConfigurableApplicationContext ctx=	SpringApplication.run(TaxiServiceApplication.class, args);
	
//		 Taxi indica = ctx.getBean("taxi",Taxi.class);
//		 
//		log.info(indica.toString()); 
		
		
		 Taxi ritz = ctx.getBean("ritz",Taxi.class);
		 
			log.info(ritz.toString()); 
			
			
//			 Taxi ritzTwo =(Taxi) ctx.getBean("ritz");
//			 
//				log.info(ritz.toString()); 
				
	
//			Driver vicky = ctx.getBean("cabdriver",Driver.class);
//			
//			log.info(vicky.toString());
//			
		
			
			
//       Driver nicky = ctx.getBean("nick",Driver.class);
//			
//			log.info(nicky.toString());
//			
//			
//			System.out.println("Is Singleton :="+ctx.isSingleton("nick"));
//			System.out.println("Is Prototype :="+ctx.isPrototype("nick"));
//			
		//	ctx.close();
	}

	
	// Factory Method For Creating Bean
//	@Bean
//	@Lazy(value=true)
//	public Taxi taxi() {
//		
//		// Constructor DI
//		
//		return new Taxi(1203,"Tata Indica","Vishal");
//	}
	
	// Factory Method For Creating Bean
		@Bean
	
		public Taxi ritz() {
			
			// Setting  DI
			
			Taxi ritz = new Taxi();
			
			ritz.setModelName("maruti-ritz");
			ritz.setTaxiNumber(1205);
			
			return ritz;
			
		}
	
//		@Bean
//		@Scope(scopeName =ConfigurableBeanFactory.SCOPE_PROTOTYPE)
//		public Driver nick() {
//			
//			return new Driver(3030,"Nikil",494949L);
//		}
//		
//		@Bean
//		@Primary
//		public Driver magy() {
//			
//			return new Driver(4040,"Magesh",595979L);
//		}
}
