package com.itbulls.learnit.javacore.cleancode.checkstyle;

public class CheckstyleDemoAfter {
    /** Demo variable A.
     */
    private static final int A_DEMO_VARIABLE = 10;
    /** Demo variable B.
     */
    private static final int B_DEMO_VARIABLE = 5;

    /** This is calculate sum method.
     * @param a
     * @param b
     * @return sum of two int parameters
     */
    public final int calculateSum(final int a, final int b) {
        return a + b;
    }

    /** This is calculate difference method.
     * @param a
     * @param b
     * @return difference between two int parameters
     */
    public int calculateDifference(final int a, final int b) {
        return a - b;
    }

    /** This is calculate sum method.
     * @param args
     */
    public static void main(final String[] args) {
        CheckstyleDemoBefore demo = new CheckstyleDemoBefore();

        System.out.println("Sum: "
                + demo.calculateSum(A_DEMO_VARIABLE, B_DEMO_VARIABLE));
        System.out.println("Difference: "
                + demo.calculateDifference(A_DEMO_VARIABLE,
                            B_DEMO_VARIABLE));
    }
}
