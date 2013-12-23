package com.kant.proxyPattern;

import java.lang.reflect.Proxy;

/**
 * 
 * @author shashi
 * 
 */
public class MatchMakingTestDrive {

	public void doTestDrive() {
		PersonBean person = getSamplePersonData();
		PersonBean ownerProxy = getOwnerProxy(person);
		PersonBean nonOwnerProxy = getNonOwnerProxy(person);

		System.out.println("TEST for OWNER");
		displayData(ownerProxy);

		System.out.println("TEST FOR NON OWNER");
		displayData(nonOwnerProxy);

	}

	/**
	 * 
	 * @param proxyGuy
	 */
	private void displayData(PersonBean proxyGuy) {
		System.out.println(proxyGuy.getGender());
		proxyGuy.setGender("F");
		System.out.println(proxyGuy.getGender());
		System.out.println(proxyGuy.getHotOrNotRatings());
		proxyGuy.setHotOrNotRatings(24);
		System.out.println(proxyGuy.getHotOrNotRatings());
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		MatchMakingTestDrive driver = new MatchMakingTestDrive();
		driver.doTestDrive();

	}

	/**
	 * @return
	 * 
	 */
	private PersonBean getSamplePersonData() {
		PersonBean joe = new PersonBeanImpl();
		joe.setGender("M");
		joe.setInterests("cricket");
		joe.setName("Joe Mc Milan");
		return joe;
	}

	/**
	 * Get owner proxy for the PersonBean.
	 * 
	 * @param person
	 * @return
	 */
	PersonBean getOwnerProxy(PersonBean person) {
		return (PersonBean) Proxy.newProxyInstance(person.getClass()
				.getClassLoader(), person.getClass().getInterfaces(),
				new OwnerInvocationHandler(person));
	}

	/**
	 * 
	 * @param person
	 * @return
	 */
	PersonBean getNonOwnerProxy(PersonBean person) {
		return (PersonBean) Proxy.newProxyInstance(person.getClass()
				.getClassLoader(), person.getClass().getInterfaces(),
				new NonOwnerInvocationhandler(person));
	}
}
