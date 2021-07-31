package com.itbulls.learnit.javacore.multithreading.hw;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
 

public class Task5_2 {
 
    private static final int ITERATION_NUMBER = 3;
    private static final int READERS_NUMBER = 3;
    private static final StringBuilder BUFFER = new StringBuilder();
    private static final int BUFFER_LENGTH = 5;
    private static final int PAUSE = 5;
    private static boolean stop;
    private static volatile int readersRead;
    private static Lock lock = new ReentrantLock();
    private static Condition notEmpty = lock.newCondition();
    private static Condition isRead = lock.newCondition();
 

    private static class Reader extends Thread {
        
    	@Override
        public void run() {
            while (!stop) {
                try {
                    // read from the buffer
                    lock.lock();
                    read(getName());
                    if (++readersRead == READERS_NUMBER) {
                        notEmpty.signalAll();
                    }
                    isRead.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            } // while loop ends
        }
    }
 
    
    private static class Writer extends Thread {
        

    	@Override
        public void run() {
            int tact = 0;
            while (!stop) {
                try {
                    lock.lock();
                    // write to the buffer
                    write();
                    readersRead = 0;
                    isRead.signalAll();
                    notEmpty.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    if (++tact == ITERATION_NUMBER) {
                        isRead.signalAll();
                        stop = true;
                    }
                    lock.unlock();
                }
            }
        }
    }
    
    private static void read(String threadName) throws InterruptedException {
        System.out.printf("Reader %s:", threadName);
        for (int j = 0; j < BUFFER_LENGTH; j++) {
            Thread.sleep(PAUSE);
            System.out.print(BUFFER.charAt(j));
        }
        System.out.println();
        Thread.sleep(5);
    }
 
    private static void write() throws InterruptedException {
        // clear buffer
        BUFFER.setLength(0);
 
        // write to buffer
        System.err.print("Writer writes:");
 
        Random random = new Random();
        for (int j = 0; j < BUFFER_LENGTH; j++) {
            Thread.sleep(PAUSE);
            char ch = (char) ('A' + random.nextInt(26));
            System.err.print(ch);
            BUFFER.append(ch);
        }
        System.err.println();
        Thread.sleep(5);
    }
 
    public static void main(String[] args) throws InterruptedException {
        // create writer
        Writer writer = new Writer();
 
        // create readers
        List<Thread> readers = new ArrayList<>();
        for (int j = 0; j < READERS_NUMBER; j++) {
            readers.add(new Reader());
        }
 
        // start writer
        writer.start();
 
        // start readers
        for (Thread reader : readers) {
            reader.start();
        }
 
    }
 
}