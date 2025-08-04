package com.cognizant.ormlearn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This class represents the 'country' table in the database.
 * Each instance of this class will correspond to a single row in the table.
 */
@Entity
@Table(name="country")
public class Country {

    /**
     * @Id marks this field as the primary key.
     * @Column maps this field to the 'co_code' column in the database.
     */
    @Id
    @Column(name="co_code")
    private String code;

    public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
     * @Column maps this field to the 'co_name' column in the database.
     */
    @Column(name="co_name")
    private String name;

    // Getters and Setters will be generated here

    // toString() method will be generated here

}
