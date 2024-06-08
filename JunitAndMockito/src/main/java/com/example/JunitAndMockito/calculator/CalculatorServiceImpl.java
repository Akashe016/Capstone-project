package com.example.JunitAndMockito.calculator;

public class CalculatorServiceImpl implements CalculatorService {

	@Override
	public int add(int a, int b) {
		// TODO Auto-generated method stub
		return a + b;
	}

	@Override
	public int multiply(int a, int b) {
		// TODO Auto-generated method stub
		return a * b;
	}

	@Override
	public int sub(int a, int b) {
		// TODO Auto-generated method stub
		return a - b;
	}

	@Override
	public double divide(double d1, double d2) {
		// TODO Auto-generated method stub
		return d1 / d2;
	}

}
