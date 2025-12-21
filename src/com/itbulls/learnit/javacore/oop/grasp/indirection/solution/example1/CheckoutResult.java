package com.itbulls.learnit.javacore.oop.grasp.indirection.solution.example1;

public class CheckoutResult {

    private final boolean success;
    private final String message;

    private CheckoutResult(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public static CheckoutResult ok(String message) {
        return new CheckoutResult(true, message);
    }

    public static CheckoutResult fail(String message) {
        return new CheckoutResult(false, message);
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
