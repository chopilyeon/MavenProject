package di.anno01;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Car {
	
	@Autowired
	@Qualifier("hankook")
	private Tire tire;
	
	
	
	private String msg;
	
	private String error;
	
	private int num;
	
	private List<String> list;
	
	public Car() {
		System.out.println("car() 생성자");
		
	}
	

	
	//aaa,bbb,ccc, ... 
	public Car(List<String> list) {
		System.out.println("Car(List<String> list) 생성자입니다.");
		this.list = list;
	}
	
	
	

	//setter 주입 -> setter 주입이라고 함. 
	@Autowired
	@Qualifier("kumho")
	public void setTire(Tire tire) {
		System.out.println("setter주입중입니다");
		System.out.println("Car(kumho kumho) 생성자 입니다");
		this.tire = tire;
		
	}

	// 자동차 어디에서도 new를 하지 않았는데도 tire가 장착됨을 알 수 있음 
	
	
	//생성자 주입
	@Autowired
	public Car(@Qualifier("kumho")Tire tire) {
		System.out.println("생성자에 주입중입니다");
		this.tire = tire;
		System.out.println("Car(kumho kumhoTire) 생성자 입니다");
	}
	
	
	public Car(Tire tire,String msg) {
		System.out.println("Car(Tire tire,String msg) 생성자입니다.");
		this.tire = tire;
		this.msg = msg;
	}
	
	
	public Car(String error,Tire tire) {
		this.error = error;
		this.tire = tire;
		
	}
	public Car(int num,String msg) {
		System.out.println("Car(int num,String msg) 생성자입니다.");
		this.num = num;
		this.msg = msg;
	}
	
	
	
	
	public void printTireBrand() {
		System.out.println("장착한 타이어 브랜드는 "+ tire.getTireBrand());
	}
	
	

	public Tire getTire() {
		return tire;
	}
	
	
	
	
	

}
