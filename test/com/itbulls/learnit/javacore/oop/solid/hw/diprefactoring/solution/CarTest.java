package com.itbulls.learnit.javacore.oop.solid.hw.diprefactoring.solution;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class CarTest {
	
	@Test
    public void testStartWithElectricEngine() {
        Engine engine = new ElectricEngine();
        Car car = new Car(engine);
        String expectedOutput = "Electric engine started.";
        assertEquals(expectedOutput, getEngineOutput(car));
    }
    
    @Test
    public void testStartWithGasolineEngine() {
        Engine engine = new GasolineEngine();
        Car car = new Car(engine);
        String expectedOutput = "Gasoline engine started.";
        assertEquals(expectedOutput, getEngineOutput(car));
    }

    private String getEngineOutput(Car car) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        PrintStream originalOut = System.out;
        System.setOut(printStream);

        car.start();

        System.setOut(originalOut);
        return outputStream.toString().trim();
    }

}
