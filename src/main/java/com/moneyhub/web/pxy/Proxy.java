package com.moneyhub.web.pxy;

import java.util.function.BiFunction;
import java.util.function.Function;

import org.springframework.stereotype.Component;


@Component
public class Proxy {
	public String string(Object param) {
		Function<Object, String> f = String :: valueOf;
		return f.apply(param);
	}
	public int integer(String param) {
		Function<String, Integer> f = Integer :: parseInt;
		return f.apply(param);
	}
	public boolean equal(String p1, String p2) {
		BiFunction<String, String, Boolean> f = String :: equals;
		return f.apply(p1,p2);
	}
	public int random(int a, int b) {
		BiFunction<Integer, Integer, Integer> f =(t,u)->(int)(Math.random()*(u-t))+t;
		return f.apply(a, b);
	}
	public int[] intArray(int size) {
		Function<Integer, int[]> f = int[] :: new;
		return f.apply(size);
	}
}