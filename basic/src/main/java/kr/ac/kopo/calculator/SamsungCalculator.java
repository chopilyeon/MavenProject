package kr.ac.kopo.calculator;

public class SamsungCalculator implements Calculator {
	
	

	public String getBrandName() {
		System.out.println("samsung입니다");
		return "samsung";
	}

	public int add(int firstNum, int secondNum) {
		System.out.println(firstNum+secondNum);
		return firstNum + secondNum;
	}

	public int sub(int firstNum, int secondNum) {
		
		System.out.println(firstNum-secondNum);
		return firstNum - secondNum;
	}

	public int mul(int firstNum, int secondNum) {
		System.out.println(firstNum*secondNum);
		return firstNum * secondNum;
	}

	public int divide(int firstNum, int secondNum) {
		System.out.println(firstNum/secondNum);
		return firstNum / secondNum;
	}


}
