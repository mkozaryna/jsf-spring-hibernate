/**
 * 
 */
package com.jeetemplates.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.jeetemplates.common.model.BusinessEntity;

/**
 * Hello entity.
 * 
 * @author jeetemplates
 */
@Entity
@Table(name = "HELLO_WORLD")
public class HelloWorld extends BusinessEntity {

	/**
	 * Serial UID.
	 */
	private static final long serialVersionUID = 1874597988200405724L;

	/**
	 * Last name.
	 */
	private String lastName;

	/**
	 * First name.
	 */
	private String firstName;

	/**
	 * @return the lastName
	 */
	@Column(name = "LAST_NAME")
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the firstName
	 */
	@Column(name = "FIRST_NAME")
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

}
