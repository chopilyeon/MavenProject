package di.anno02;

import org.springframework.stereotype.Component;

@Component
public class HankookTire implements Tire {
	
	
	
	public HankookTire() {
		System.out.println("KumhoTire() 생성자");
	}
	
	

	public String getTireBrand() {

		
		
		return "한국타이어";
	}

}
