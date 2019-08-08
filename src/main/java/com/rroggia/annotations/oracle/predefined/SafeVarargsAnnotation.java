package com.rroggia.annotations.oracle.predefined;

import java.util.ArrayList;
import java.util.List;

public class SafeVarargsAnnotation {

	@SafeVarargs
	static <T> List<T> convert(T... elements) {
		List<T> list = new ArrayList<>();
		for (T element : elements) {
			list.add(element);
		}
		return list;
	}

}
