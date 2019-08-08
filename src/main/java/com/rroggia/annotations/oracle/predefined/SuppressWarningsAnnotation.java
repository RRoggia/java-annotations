package com.rroggia.annotations.oracle.predefined;

public class SuppressWarningsAnnotation {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		new DeprecatedAnnotation().doSomething();
	}

}
