/**
 * 
 */
package com.kant.proxyPattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author shashi
 * 
 */
public class OwnerInvocationHandler implements InvocationHandler {
	PersonBean person;

	/**
	 * 
	 * @param person
	 */
	public OwnerInvocationHandler(PersonBean person) {
		super();
		this.person = person;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object,
	 * java.lang.reflect.Method, java.lang.Object[])
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		try {
			if (method.getName().startsWith("get")) {
				return method.invoke(person, args);
			} else if (method.getName().equalsIgnoreCase("setHotOrNotRatings")) {
				throw new IllegalAccessException(
						"One cannot change his own ratings");
			} else if (method.getName().startsWith("set")) {
				return method.invoke(person, args);
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
}
