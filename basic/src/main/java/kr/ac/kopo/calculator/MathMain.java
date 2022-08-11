package kr.ac.kopo.calculator;

public class MathMain {

	public static void main(String[] args) {
		SamsungCalculator samsung = new SamsungCalculator();
		LGCalculator lg = new LGCalculator();
		
		MyCalculator cal= new MyCalculator(samsung);
		
		cal.getBrand();
		cal.add(3, 4);
		cal.sub(7,3);

	}

}
