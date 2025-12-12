package com.itbulls.learnit.javacore.oop.grasp.lowcoupling.solution.example1;

public class SmsService {

    public void sendSms(String phone, String text) {
        System.out.println("SMS to " + phone + " text=" + text);
    }
}
