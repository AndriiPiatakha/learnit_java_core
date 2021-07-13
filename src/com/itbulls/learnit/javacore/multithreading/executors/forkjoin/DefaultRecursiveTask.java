package com.itbulls.learnit.javacore.multithreading.executors.forkjoin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

public class DefaultRecursiveTask extends RecursiveTask<Integer> {

	private int workload = 0;

	public DefaultRecursiveTask(int workload) {
	        this.workload = workload;
	    }

	@Override
	protected Integer compute() {
		if (this.workload < 18) {
			System.out.println("Doing workLoad myself in thread " + Thread.currentThread().getName()
					+ " with workload: " + this.workload);
			return workload * 2;
		} else {
			System.out.println("Splitting workLoad in thread " + Thread.currentThread().getName()
					+ " with workload: " + this.workload);
			List<DefaultRecursiveTask> subtasks = new ArrayList<>(createSubtasks());
			for (RecursiveTask<Integer> subtask : subtasks) {
				subtask.fork();
			}
			
			// Alternatively we may call next method
//			ForkJoinTask.invokeAll(createSubtasks());
			
			int result = 0;
            for(DefaultRecursiveTask subtask : subtasks) {
                result += subtask.join();
            }
            return result;
		}
	}

	private List<DefaultRecursiveTask> createSubtasks() {
		List<DefaultRecursiveTask> subtasks = new ArrayList<>();

		var subtask1 = new DefaultRecursiveTask(this.workload / 2);
		var subtask2 = new DefaultRecursiveTask(this.workload / 2);

		subtasks.add(subtask1);
		subtasks.add(subtask2);

		return subtasks;
	}

}
