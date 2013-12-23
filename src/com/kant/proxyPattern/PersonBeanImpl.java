/**
 * 
 */
package com.kant.proxyPattern;

/**
 * @author shashi
 * 
 */
public class PersonBeanImpl implements PersonBean {

	String name;
	String interests;
	String gender;
	int ratings;
	int ratingsCount = 1;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kant.proxyPattern.PersonBean#getName()
	 */
	@Override
	public String getName() {
		return name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kant.proxyPattern.PersonBean#getGender()
	 */
	@Override
	public String getGender() {
		return gender;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kant.proxyPattern.PersonBean#getInterests()
	 */
	@Override
	public String getInterests() {
		return interests;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kant.proxyPattern.PersonBean#getHotOrNotRatings()
	 */
	@Override
	public int getHotOrNotRatings() {
		return ratings / ratingsCount;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public void setInterests(String interests) {
		this.interests = interests;
	}

	@Override
	public void setHotOrNotRatings(int val) {
		this.ratings += val;
		ratingsCount++;
	}

}
