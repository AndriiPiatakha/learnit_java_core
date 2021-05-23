package com.itbulls.learnit.javacore.patterns.behavioral.templatemethod;

public abstract class CrossCompiler {

	public final void compile() {
		collectSources();
		reserveRam();
		compileToTarget();
		afterCompileHook();
		compilationStatusNotification();
	}

	private void compilationStatusNotification() {
		System.out.println("Compilation is successful");
	}

	private void reserveRam() {
		System.out.println("Ram is reserved for compilation process");
	}
	
	protected void afterCompileHook() {
		// do nothing by default
	};

	protected abstract void collectSources();

	protected abstract void compileToTarget();
	
	

}