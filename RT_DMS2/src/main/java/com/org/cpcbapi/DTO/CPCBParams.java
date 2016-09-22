package main.java.com.org.cpcbapi.DTO;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

public class CPCBParams implements Serializable{

	
	@Column(name="parameter")
	private Integer parameter;
	
	@Column(name="value")
	private int value;
	
	@Column(name="unit")
	private String unit;
	
	@Column(name="time_stamp")
	private Date timeStamp;
	
	@Column(name="flag")
	private String flag;
	
	public CPCBParams() {
		
	}

	

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}



	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public Integer getParameter() {
		return parameter;
	}

	public void setParameter(Integer parameter) {
		this.parameter = parameter;
	}



	@Override
	public String toString() {
		return "CPCBParams [parameter=" + parameter + ", value=" + value
				+ ", unit=" + unit + ", timeStamp=" + timeStamp + ", flag="
				+ flag + "]";
	}



}
