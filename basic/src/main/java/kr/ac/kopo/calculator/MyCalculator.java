package kr.ac.kopo.calculator;

public class MyCalculator {
	private int firstNum;
	private int secondNum;
	private Calculator calculator;
	
	
	public MyCalculator(int firstNum, int secondNum, Calculator calculator) {
		super();
		this.firstNum = firstNum;
		this.secondNum = secondNum;
		this.calculator = calculator;
	}
	
	
	
	public MyCalculator(Calculator calculator) {
		super();
		this.calculator = calculator;
	}



	public void add(int firstNum, int secondNum) {
		calculator.add(firstNum, secondNum);		
	}
	
	public void sub(int firstNum,int secondNum) {
		calculator.sub(firstNum, secondNum);
	}
	public void mul(int firstNum,int secondNum) {
		calculator.mul(firstNum, secondNum);
	}
	public void divide(int firstNum,int secondNum) {
		calculator.divide(firstNum, secondNum);
	}
	
	public void getBrand() {
		calculator.getBrandName();
	}
	

	
	

}
