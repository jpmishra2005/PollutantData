package main.java.com.org.cpcbapi.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class ParamData {

	@Column(name = "parameter")
	private String parameter;

	@Column(name = "value")
	private int value;

	@Column(name = "unit")
	private String unit;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "param_time_stamp")
	private Date timeStamp;

	@Column(name = "flag")
	private char flag;

	public ParamData() {

	}

	public String getParameter() {
		return parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
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

	public char getFlag() {
		return flag;
	}

	public void setFlag(char flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "ParamData [parameter=" + parameter + ", value=" + value
				+ ", unit=" + unit + ", timeStamp=" + timeStamp + ", flag="
				+ flag + "]";
	}

	

}
