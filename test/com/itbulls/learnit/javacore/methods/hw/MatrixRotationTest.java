package com.itbulls.learnit.javacore.methods.hw;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class MatrixRotationTest {
	
	@Test
	public void shouldRotate90() {
		double[][] matrix = {
				{10.0, 10.1, 10.2},
				{32.0, 32.1, 32.2},
				{47.0, 47.1, 47.2},
		};
		MatrixRotation.rotate90(matrix);
		
		double[][] expectedMatrix = {
				{47.0, 32.0, 10.0},
				{47.1, 32.1, 10.1},
				{47.2, 32.2, 10.2},
		};
		assertTrue(Arrays.deepEquals(expectedMatrix, matrix));
	}
	
	@Test
	public void shouldRotate180() {
		double[][] matrix = {
				{10.0, 10.1, 10.2},
				{32.0, 32.1, 32.2},
				{47.0, 47.1, 47.2},
		};
		MatrixRotation.rotate180(matrix);
		
		double[][] expectedMatrix = {
				{47.2, 47.1, 47.0},
				{32.2, 32.1, 32.0},
				{10.2, 10.1, 10.0},
		};
		assertTrue(Arrays.deepEquals(expectedMatrix, matrix));
	}
	
	@Test
	public void shouldRotate270() {
		double[][] matrix = {
				{10.0, 10.1, 10.2},
				{32.0, 32.1, 32.2},
				{47.0, 47.1, 47.2},
		};
		MatrixRotation.rotate270(matrix);
		
		double[][] expectedMatrix = {
				{10.2, 32.2, 47.2},
				{10.1, 32.1, 47.1},
				{10.0, 32.0, 47.0},
		};
		assertTrue(Arrays.deepEquals(expectedMatrix, matrix));
	}

}
