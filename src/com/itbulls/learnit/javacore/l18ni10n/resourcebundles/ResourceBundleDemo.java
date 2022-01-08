package com.itbulls.learnit.javacore.l18ni10n.resourcebundles;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;

public class ResourceBundleDemo {

	public static void main(String[] args) {
		ResourceBundle mybundle = ResourceBundle.getBundle("MyLabels");

		Locale.setDefault(new Locale("ru", "RU"));
		System.out.println("\"Welcome\" in Russian:\t" 
								+ mybundle.getString("welcome.message"));
		System.out.println("\"Login Button Text\" in Russian:\t" 
				+ mybundle.getString("login.button.text"));
		
		Locale.setDefault(new Locale("en", "US"));
		mybundle = ResourceBundle.getBundle("MyLabels");
		System.out.println("\"Welcome\" in English language:\t" 
								+ mybundle.getString("welcome.message"));
		System.out.println("\"Login Button Text\" in English:\t" 
				+ mybundle.getString("login.button.text"));
		
		Locale.setDefault(new Locale("hi", "IN"));
		mybundle = ResourceBundle.getBundle("MyLabels");
		System.out.println("\"Welcome\" in default version:\t" 
								+ mybundle.getString("welcome.message"));
		System.out.println("\"Login Button Text\" in default version:\t" 
				+ mybundle.getString("login.button.text"));

		// class bundle example
		Locale.setDefault(new Locale("de", "DE"));
		mybundle = ResourceBundle.getBundle("MyLabels");
		Integer object = (Integer) mybundle.getObject("integer_value");
		System.out.println(object);
		
		System.out.println("===== Bundle key set =====");
		Set<String> keySet = mybundle.keySet();
		System.out.println(keySet);
	}

}
