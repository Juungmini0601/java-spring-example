package com.raon;

public class Main {
	public static void main(String[] args) {
		MyObject myObjectA = new MyObject();
		MyObject myObjectB = new MyObject();

		myObjectA.setInstance(myObjectB);
		myObjectB.setInstance(myObjectA);
		// myObjectA와 myObjectB로 가는길이 없지만, 참조 카운트가 남아있기 때문에 GC가 안된다.
		myObjectA = null;
		myObjectB = null;
	}
}