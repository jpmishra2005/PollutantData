package main.java.com.org.cpcbapi;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the address database table.
 * 
 */
@Entity
@NamedQuery(name="Address.findAll", query="SELECT a FROM Address a")
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String city;
	private String state;
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	private String pinCode;

	@Column(name="`Street Name`")
	private String street_Name;

	private String streetNo;

	
	public Address() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPinCode() {
		return this.pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getStreet_Name() {
		return this.street_Name;
	}

	public void setStreet_Name(String street_Name) {
		this.street_Name = street_Name;
	}

	public String getStreetNo() {
		return this.streetNo;
	}

	public void setStreetNo(String streetNo) {
		this.streetNo = streetNo;
	}



}