package com.itbulls.learnit.javacore.oop.solid.hw.isprefactoring.solution;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.*;

public class DemoTest {
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @After
    public void tearDown() {
        System.setOut(System.out);
    }

    @Test
    public void shouldEmployeeWork() {
        Workable employee = new Employee();
        employee.work();
        assertEquals("Employee is working", outputStreamCaptor.toString().strip());
    }

    @Test
    public void shouldEmployeeEat() {
        Eatable employee = new Employee();
        employee.eat();
        assertEquals("Employee is eating", outputStreamCaptor.toString().strip());
    }

    @Test
    public void shouldEmployeeSleep() {
        Sleepable employee = new Employee();
        employee.sleep();
        assertEquals("Employee is sleeping", outputStreamCaptor.toString().strip());
    }

    @Test
    public void shouldRobotWork() {
        Workable robot = new Robot();
        robot.work();
        assertEquals("Robot is working", outputStreamCaptor.toString().strip());
    }
}
