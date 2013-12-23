/**
 * 
 */
package com.kant.proxyPattern;


/**
 * @author shashi
 *
 */
public interface PersonBean {
	
	String getName();
	String getGender();
	String getInterests();
	int getHotOrNotRatings();
	
	void setName(String name);
	void setGender(String gender);
	void setInterests(String interests);
	void setHotOrNotRatings(int val);

}
