package com.itbulls.learnit.javacore.numbersystems;

public class NumberSystems {
	
	public static void main(String[] args) {
		int dec = 152;            //  no prefix   --> decimal literal
		int bin = 0b10011000;     // '0b' prefix --> binary literal
		int oct = 0230;           // '0' prefix  --> octal literal
		int hex = 0x98;           // '0x' prefix --> hexadecimal literal
		
		System.out.println(dec);
		System.out.println(bin);
		System.out.println(oct);
		System.out.println(hex);
	}

}
