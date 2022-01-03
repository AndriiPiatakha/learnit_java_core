package com.itbulls.learnit.javacore.dao.hw.template.utils.validation.impl;

import java.lang.reflect.Field;
import java.util.Arrays;

import com.itbulls.learnit.javacore.dao.hw.template.annotations.Validate;
import com.itbulls.learnit.javacore.dao.hw.template.utils.validation.Validator;

public class DefaultValidator implements Validator {

	@Override
	public boolean isValid(Object obj) {
		Class clazz = obj.getClass();
		for (Field field : clazz.getDeclaredFields()) {
			Validate validateAnnotation = field.getAnnotation(Validate.class);
			if(validateAnnotation != null) {
				String pattern = validateAnnotation.pattern();
				field.setAccessible(true);
				Object fieldValue = null;
				try {
					fieldValue = field.get(obj);
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
				if (fieldValue instanceof String) {
					if(!((String)fieldValue).matches(pattern)) {
						System.out.println("FALSE " + fieldValue);
						return false;
					}
				}
			}
		}
		
		return true;
	}

}
