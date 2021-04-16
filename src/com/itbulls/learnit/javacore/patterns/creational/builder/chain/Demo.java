package com.itbulls.learnit.javacore.patterns.creational.builder.chain;

public class Demo {
	
	public static void main(String[] args) {
		Account account = Account.newBuilder()
                .setToken("hello")
                .setUserId("habr")
                .build();
		System.out.println(account);
	}

}
