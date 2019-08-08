package com.rroggia.annotations.oracle.predefined;

public class OverrideAnnotation extends Superclass {

	@Override
	public void doSomething() {
		System.out.println("This class uses @Override annotation");
	}
}
