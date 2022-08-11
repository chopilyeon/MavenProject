package di.anno02;

import org.springframework.stereotype.Component;

@Component
public class KumhoTire implements Tire {

	
	public KumhoTire() {
		System.out.println("KumhoTire() 생성자");
	}
	
	public String getTireBrand() {
		
		
		
		return "금호타이어";
	}

}
