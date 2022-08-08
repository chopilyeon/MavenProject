package di.xml02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import di.xml02.Car;

public class DriverMain {

	public static void main(String[] args) {
		
		ApplicationContext context = new GenericXmlApplicationContext("di.xml02.xml");
		
		
		Car car = (Car)context.getBean("car");
		
		car.printTireBrand();

		
		
		Car car2 = (Car)context.getBean("car2");
		car2.printTireBrand();
		car2.printMsg();
		
		
		
		Car car3 = (Car)context.getBean("car3");
		car3.printMsg2();
		
		
		Car car4 = (Car)context.getBean("car4");
		car4.printMsg3();
		
		
		System.out.println("====setter 주입1====");
		Car car5 = (Car)context.getBean("car5");
		car5.printTireBrand();
		//즉 기본 생성자를 부르고 setter를 통해서 tire가 들어가게 됨!  
		
		
		

		System.out.println("====setter 주입2====");
		Car car6 = (Car)context.getBean("car6");
		System.out.println("car6:"+car6);
		//car6.printTireBrand();
		
		System.out.println("car6의 수는"+car6.getNum());
		
		
	}	

}
