package com.rroggia.annotations.oracle.typeannotations;

import org.checkerframework.checker.nullness.qual.NonNull;

public class Client {

	public static void main(String[] args) {
		String str = Math.random() > 0.5 ? "ROGGIA" : null;

		printLenght("roggia");
		printLenght(str);
	}

	static void printLenght(@NonNull String str) {
		System.out.println(str.length());

	}

}
