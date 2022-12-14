package basic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloMain {

	public static void main(String[] args) {
		
		//Hello hello = new Hello();
		//hello.Hello1
		ApplicationContext context = new GenericXmlApplicationContext("beanContainer.xml");
		Hello hello1 =(Hello) context.getBean("hello");
		hello1.hello1();
		Hello hello2 =(Hello) context.getBean(Hello.class);
		hello2.hello1();
		Hello hello3 =(Hello) context.getBean("hello",Hello.class);
		
		//더 이상 인간이 생성자등을 생성하지 않게 하겠다. 
		//spring을 이용하겠다는 의미임. 
		System.out.println(hello1);
		System.out.println(hello2);
		System.out.println(hello3);
		
		// bean container에서 2개의 Hello가 있게 디ㅗ면은? hello 생성자가 2번이 생성이 되면은 
		// Hello hello2 =(Hello) context.getBean("Hello.class"); 여기선 에러가 발생하게 됨. -> UNIQUE하지 않아서 발생하는 문제가 생김. 
		
		
	}

}
