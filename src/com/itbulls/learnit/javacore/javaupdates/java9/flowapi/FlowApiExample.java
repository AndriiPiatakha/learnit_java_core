package com.itbulls.learnit.javacore.javaupdates.java9.flowapi;

import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.TimeUnit;

public class FlowApiExample {
    public static void main(String[] args) throws InterruptedException {
        // Create a SubmissionPublisher
        SubmissionPublisher<Integer> publisher = new SubmissionPublisher<>();

        // Create a custom Processor
        MySubscriber subscriber = new MySubscriber();

        // Subscribe the Subscriber to the Publisher
        publisher.subscribe(subscriber);
        TimeUnit.SECONDS.sleep(1);
        // Publish some items to the Publisher
        for (int i = 1; i <= 5; i++) {
            System.out.println("Publisher: Emitting item " + i);
            publisher.submit(i);
        }
        
        // Close the publisher to signal completion
        publisher.close();
    }
}
