package di.xml01;

public class Car {
	private Tire tire;
	public Car() {
		System.out.println("car() 생성자");
		
	}
	


	//setter 주입 -> setter 주입이라고 함. 
	public void setTire(Tire tire) {
		System.out.print("Car(HankookTire hankookTire) 생성자 입니다");
		this.tire = tire;
		
	}

	// 자동차 어디에서도 new를 하지 않았는데도 tire가 장착됨을 알 수 있음 
	
	
	
	//생성자 주입
	public Car(Tire tire) {
		this.tire = tire;
		System.out.print("Car(HankookTire hankookTire) 생성자 입니다");
	}
	
	
	
	public void printTireBrand() {
		
		System.out.println("장착한 타이어 브랜드는 "+ tire.getTireBrand());
		
	}



	
	
	

}
