package com.itbulls.learnit.javacore.javaupdates;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.invoke.MethodHandles.Lookup.ClassOption;
import java.lang.reflect.InvocationTargetException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ByteArrayOutputStream;

public class Java15 {
	
	public static void main(String[] args) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, IOException {
		
		System.out.println("===== JEP 378 - Text Blocks =====");
		String traditionalString = "This is a line of text.\n" +
                "This is another line of text.\n" +
                "And one more line of text.";
		
		String textBlock = """
                This is a line of text.
                This is another line of text.
                And one more line of text.
                """;
		String htmlBlock = """
	            <html>
	                <body>
	                    <p>Text Block Demo</p>
	                </body>
	            </html>
	            """;
		String htmlBlock2 = """
	               <html>
	                <body>
	                    <p>Text Block Demo</p>
	                </body>
	            </html>
	            """;
		String textBlock2 = """
                This is a line of text.
                This is another line of text.
                And one more line of text.
             """;
		
		String textBlock3 = """
	            Embracing the simplicity of "text blocks"
	            while avoiding unnecessary escapes \"""
	            """;
		
		String textBlock4 = """
	            A text block with\r
	            carriage returns for\r
	            better line termination
	            """;
		
		String textBlock5 = """
	            Ignoring newlines \
	            for a more compact\
	            text representation
	            """;
		
		String textBlock6 = """
	            Ignoring trailing spaces     
	            and preserving leading spaces     \s
	            """;
		
		System.out.println(textBlock);
		System.out.println(htmlBlock);
		System.out.println(htmlBlock2);
		System.out.println(textBlock2);
		System.out.println(textBlock3);
		System.out.println(textBlock4);
		System.out.println(textBlock5);
		System.out.println(textBlock6);
		
		
		System.out.println();
		System.out.println("===== New String methods (formatted, stripIndent, translateEscapes) =====");
		
		System.out.println("***formatted():");
		String formattedString = "Hello %s! Today is %s.".formatted("User", "Monday");
		System.out.println(formattedString);
		
		System.out.println("***stripIndent():");
		String indentedString = "   This is a string with indentation   ";
		String strippedString = indentedString.stripIndent();
		System.out.println(indentedString);
		System.out.println(strippedString);
		
		System.out.println("***translateEscapes():");
		String escapedString = "This is a string with \\n new line.";
	    String translatedString = escapedString.translateEscapes();
	    System.out.println(escapedString);
	    System.out.println(translatedString);
		
	    
	    System.out.println();
		System.out.println("===== JEP 371 - Hidden Classes =====");
        // Obtain a Lookup object with private access
        Lookup lookup = MethodHandles.privateLookupIn(Java15.class, MethodHandles.lookup());

        byte[] bytes = getByteArrayOfClass(Java15.class);
        // Define a hidden class
        Class<?> hiddenClass = lookup.defineHiddenClass(bytes, true, ClassOption.NESTMATE).lookupClass();

        // Instantiate the hidden class
        Object instance = hiddenClass.getDeclaredConstructor().newInstance();

        // Output the name of the hidden class
        System.out.println("Hidden Class Name: " + hiddenClass.getName());
		
		
		
		

	}

	private static byte[] getByteArrayOfClass(Class<?> clazz) throws IOException {
        String className = clazz.getName();
        String classAsPath = className.replace('.', '/') + ".class";
        InputStream stream = clazz.getClassLoader().getResourceAsStream(classAsPath);
        byte[] bytes = convertInputStreamToByteArray(stream);
		return bytes;
	}
	
	public static byte[] convertInputStreamToByteArray(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int bytesRead;

        while ((bytesRead = inputStream.read(buffer)) != -1) {
            byteArrayOutputStream.write(buffer, 0, bytesRead);
        }

        return byteArrayOutputStream.toByteArray();
    }

}
