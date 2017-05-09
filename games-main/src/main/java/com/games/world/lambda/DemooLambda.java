package com.games.world.lambda;

import java.util.ArrayList;
import java.util.List;

public class DemooLambda {
	
	@FunctionalInterface
	public interface Runnable {
	    public abstract void run();
	}
	
	public static void main(String[] args) {
		List<String> words =new ArrayList<>();
		words.add("12");
		words.add("qwe");
		words.add("w");
		System.out.println(words);
		words.sort((w1, w2) -> {
		    return Integer.compare(w1.length(), w2.length());
		});
		System.out.println(words);
	}
}
