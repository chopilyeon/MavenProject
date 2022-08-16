package di.xml01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DriverMain {

	public static void main(String[] args) {
		
		ApplicationContext context = new GenericXmlApplicationContext("di.xml01.xml");
		
		
		Car car = (Car)context.getBean("car");
		car.printTireBrand();
		
		//Tire kumho = (KumhoTire)context.getBean("kumho");
		//Tire hankook =(HankookTire)context.getBean("hankook");
		
		
		
		//context.getBean("kumho",kumhoTire.class); 이렇게 쓰면 형변환 안해도 됨.
	
		//car.setTire(hankook);
		//car.printTireBrand();
		
		
	}	

}
