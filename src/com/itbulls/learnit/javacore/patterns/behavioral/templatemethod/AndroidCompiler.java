package com.itbulls.learnit.javacore.patterns.behavioral.templatemethod;

public class AndroidCompiler extends CrossCompiler {

	protected void collectSources() {
		System.out.println("Collect Android specific sources");
	}

	protected void compileToTarget() {
		System.out.println("Android compilation");
	}

	@Override
	protected void afterCompileHook() {
		System.out.println("Android after compile hook");
	}

}
