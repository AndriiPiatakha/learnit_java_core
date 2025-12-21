package com.itbulls.learnit.javacore.oop.grasp.protectedvariations.solution.example1;

public class SdkChargeResult {

    private final boolean success;
    private final String chargeId;

    public SdkChargeResult(boolean success, String chargeId) {
        this.success = success;
        this.chargeId = chargeId;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getChargeId() {
        return chargeId;
    }
}