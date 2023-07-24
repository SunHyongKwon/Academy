
/*
 * DB 사용을 위한 설정 파일로 application.properties에 선언된 spring.datasource.* 값들을 DataSource를 빌드한다. 
 * DB 연동은 다른 방법으로도 가능하지만 보다 나은 유지 보수를 위해 클래스 파일로 분리하는 작업.
 * configuration은 전부 세팅 파일이라고 보면 된다. 
 */

package com.springlec.base.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}
}
