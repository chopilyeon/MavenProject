package di.java;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = {"di.java"})
@Configuration
public class Config {
	
	
	/*
	 * <context:component-scan base-package:>
	 * 
	 * @Bean public HankookTire hankookTire(){
	 * 
	 * return new HankookTire();
	 * 
	 * }
	 * 
	 * @Bean
	 * 
	 * @Qualifier("kumho") public KumhoTire kumhoTire() {
	 * 
	 * return new KumhoTire(); }
	 * 
	 * @Bean
	 * 
	 * @Qualifier("car") public Car car() { return new Car(); }
	 */		
}
