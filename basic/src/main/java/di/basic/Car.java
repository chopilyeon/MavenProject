package di.basic;

public class Car {
	
	private HankookTire hankookTire;
	
	public Car() {
		//hankookTire = new HankookTire();
		//과연 내가 이렇게 생성자까지 만들어 주어야 할까? -> tire 가 바뀐다고 해서 car에서 일일이 바꿔야 정상일까?
		System.out.println("Car() 생성자 입니다.");
	}
	
	
	//setter 주입 -> setter 주입이라고 함. 
	public void setHankookTire(HankookTire hankookTire) {
		System.out.print("Car(HankookTire hankookTire) 생성자 입니다");
		this.hankookTire = hankookTire;
		
	}

	// 자동차 어디에서도 new를 하지 않았는데도 tire가 장착됨을 알 수 있음 
	
	
	
	//생성자 주입
	public Car(HankookTire hankookTire) {
		this.hankookTire = hankookTire;
		System.out.print("Car(HankookTire hankookTire) 생성자 입니다");
	}
	
	
	
	public void printTireBrand() {
		
		System.out.println("장착한 타이어 브랜드는 "+hankookTire.getTireBrand());
	}
	
}
//DI라는 것은 DEPENDENCY INJECTION임 