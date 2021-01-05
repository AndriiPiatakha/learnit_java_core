package com.itbulls.learnit.javacore.io.serialization;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public class SerializationDemo {
	
	public static void main(String[] args) {
		Employee empl = new Employee();
		empl.setId(1);
		empl.setName("Vladimir");
		Map<String, String> props = new HashMap<>();
		props.put("salary", "10000");
		props.put("city", "Moscow");
		empl.setProps(props);
		
		var byteArrayOutputStream = serializeEmployee(empl);
		Employee copyEmployee = deserializeEmployee(byteArrayOutputStream);
		System.out.println(copyEmployee);
	}

	private static ByteArrayOutputStream serializeEmployee(Employee empl) {
		try (var byteArrOutputStream = new ByteArrayOutputStream();
				var oos = new ObjectOutputStream(byteArrOutputStream)) {
			oos.writeObject(empl);
			return byteArrOutputStream;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static Employee deserializeEmployee(ByteArrayOutputStream inputStream) {
		try (var ois = new ObjectInputStream(new ByteArrayInputStream(inputStream.toByteArray()))) {
			return (Employee) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

}
