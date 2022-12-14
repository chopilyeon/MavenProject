package di.basic2;

public class DriverMain {
	public static void main(String[] args) {
		
		
		Tire hankook = new HankookTire();
		Tire kumho = new KumhoTire();
		
		
		Car car = new Car();
		//이제 이 자동차에게 의존주입을 할 수 있다! ->  setter를 우선 써보자! 
		
		//car.setTire(kumho);
		//협상이 안되어서  hankook으로 바꾸려면? 개발자는 한국 타이어로만 바꾸면 된다! 
		car.setTire(hankook);
		
		
		car.printTireBrand();
		
		
		//di를 쓸 때 유연하게 가져가고 싶으면 interface를 통해 인자값들을 만들어야 함 -> 그래야 그 값은 변함이 없으므로 하위가 아무리 바뀌더라도 interface로 형변환이 가능하므로 유지보수가 편함. 
		

	}
}