package com.itbulls.learnit.javacore.io.serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String name;
	private Map<String, String> props;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, String> getProps() {
		return props;
	}

	public void setProps(Map<String, String> p) {
		this.props = p;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", props=" + props + "]";
	}

	/**
	 * this method is executed by jvm when writeObject() is called during
	 * serialization
	 */
	private void writeObject(ObjectOutputStream oos) throws IOException {
		// perform any changes with object before serializing it
		oos.defaultWriteObject();
		System.out.println("=============== serialization in-progress");
	}

	/**
	 * this method is executed by jvm when readObject() is called during
	 * serialization
	 */
	private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
		ois.defaultReadObject();
		// perform any changes with object after deserializing it
		System.out.println("=============== de-serialization in-progress");
	}
}
