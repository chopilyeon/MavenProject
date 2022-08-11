package di.java;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DriverMain {
	public static void main(String[] args) {
		
		ApplicationContext context =
		new AnnotationConfigApplicationContext(Config.class);
				
				//new GenericXmlApplicationContext("di.anno01.xml");
		
		Car car = (Car)context.getBean("car");
		car.printTireBrand();
		
	}

}
