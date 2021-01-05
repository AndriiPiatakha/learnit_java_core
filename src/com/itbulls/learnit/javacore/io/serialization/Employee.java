package com.itbulls.learnit.javacore.io.serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Employee implements Cloneable, Serializable {

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

//	@Override
//	public Object clone() throws CloneNotSupportedException {
//		return super.clone();
//	}

	// Default cloning looked like this

//	 @Override
//	 public Object clone() throws CloneNotSupportedException {
//	
//	 Employee e = new Employee();
//	 e.setId(this.id);
//	 e.setName(this.name);
//	 e.setProps(this.props);
//	 return e;
//	 }

	// DEEP CLONING

	public Object clone() throws CloneNotSupportedException {

		Object obj = super.clone(); // utilize clone Object method

		Employee emp = (Employee) obj;

		// deep cloning for immutable fields
		emp.setProps(null);
		Map<String, String> hm = new HashMap<>();
		String key;
		Iterator<String> it = this.props.keySet().iterator();
		// Deep Copy of field by field
		while (it.hasNext()) {
			key = it.next();
			hm.put(key, this.props.get(key));
		}
		emp.setProps(hm);

		return emp;
	}

	// - clonning with serialization
	// - clonning with constructor
	// - clonning with apache lib
	// org.apache.commons.lang3.SerializationUtils.clone(emp);
	// - use clone() method from Object class only for primitives

}
