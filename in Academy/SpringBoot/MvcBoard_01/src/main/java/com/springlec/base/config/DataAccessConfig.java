package com.springlec.base.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
@MapperScan(basePackages = "com.springlec.base.dao")
public class DataAccessConfig {
	
	// 몬가 세팅한다.
	// sqlSession은 mybatis를 사용하기 위해 사용한다. 
	// sqlsessionfactory가 *.xml 부분을 가져오기 위해서 필요하다. 
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		sessionFactory.setMapperLocations(
				new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));		
		
		return sessionFactory.getObject();
	}
	
	
	// template은 select 인지, update 인지, delete 인지, insert인지 알기위해 필요한 것 
	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
	
	
	
	
	
	
} // --------
