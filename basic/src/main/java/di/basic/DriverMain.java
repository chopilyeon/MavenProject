package di.basic;

public class DriverMain {
	public static void main(String[] args) {
		
		//타이어 설정. 생성.
		HankookTire hankookTire = new HankookTire();
		//자동차야 너는 한국 타이어를 가져다 쓰렴 이라고 하고 싶음
		// -> setter라는 걸 우리는 배웠음. 
		
		
		
		//Car car = new Car();
		
		//car.setHankookTire(hankookTire);
		
		// -> 이런식으로 할 수는 있음. setter를 사용해서 자동차 내부에서 타이어를 만들지 않더라도 사용할 수 있게끔 할 수 있음. 
		
		// 자동차 어디에서도 new를 하지 않았는데도 tire가 장착됨을 알 수 있음 
		// 이런걸 di라고 함. 자동차가 있어야되는데 자동차 밖에서 이걸 집어넣는 것임. -> 의존주입이라고 함.
		
		
		
		//위의 방식이 아닌 생성자에서 아예 car를 만들 때 hankook tire를 넣어서 생성자를 만들고 싶다! 
		
		Car car = new Car(hankookTire);
		
		
		
		
		car.printTireBrand();
		
		

	}
}