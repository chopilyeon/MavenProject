package di.java;

import org.springframework.stereotype.Component;

@Component
public class NexenTire {
	public NexenTire() {
		System.out.println("넥센 타이어 생성자입니다.");
	}
	public String getTireBrand() {
		
		return "넥센타이어";
	}

}
