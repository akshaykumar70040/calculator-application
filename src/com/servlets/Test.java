package com.servlets;

public class Test {

	public static void main(String[] args) {
//		System.out.println(add(new int[] {1, 2,3, 7}));
		
//		System.out.println(add2());
		System.out.println("hello in servlet 2\r\n" + 
				"Sum value is : 10\r\n" + 
				"<a href=\"/Calculator1\" > click here</a>".length());
	}

	public static int add(int[] array) {
		int sum =0;
		for(int a : array) {
			sum += a;
		}
		return sum;
	}
	
	public static int add2(int b, int... args) {
		int sum =0;
		for(int a : args) {
			sum += a;
		}
		return sum;
	}

}
