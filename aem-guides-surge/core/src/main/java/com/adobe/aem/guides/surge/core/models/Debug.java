package com.adobe.aem.guides.surge.core.models;

public class Debug {
	public void Method() {
		System.out.println("one");
		System.out.println("Two");
		System.out.println("Three");
	}
	public void Method(int a) {
		System.out.println("four");
		System.out.println("five");
		System.out.println("six");
	}
	public void Method(String name) {
		System.out.println("seven");
		System.out.println("eight");
		System.out.println("nine");
	}

	public static void main(String[] args) {
		Debug M =new Debug();
		M.Method();
		M.Method(10);
		M.Method("harianna");
		

	}

}
