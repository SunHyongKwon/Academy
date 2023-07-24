package com.springlec.base.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springlec.base.service.CalcService;

// IoC container에 등록될 애들 지정해 주는 곳
@Configuration
public class DataAccessConfig {
	
	@Bean
	public CalcService calcService() {
		
		return new CalcService() {

			@Override
			public int addAction(int num1, int num2) throws Exception {
				// TODO Auto-generated method stub
				return num1 + num2;
			}

			@Override
			public int minusAction(int num1, int num2) throws Exception {
				// TODO Auto-generated method stub
				return num1 - num2;
			}

			@Override
			public int multiAction(int num1, int num2) throws Exception {
				// TODO Auto-generated method stub
				return num1 * num2;
			}

			@Override
			public double divideAction(int num1, int num2) throws Exception {
				// TODO Auto-generated method stub
				return (double) num1 / num2;
			}
		};
		
	}

}
