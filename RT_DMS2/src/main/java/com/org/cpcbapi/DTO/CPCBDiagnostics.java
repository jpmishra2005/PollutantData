package main.java.com.org.cpcbapi.DTO;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


public class CPCBDiagnostics implements Serializable{

	
	
	@Column(name="diag_param")
	private String diagParam;
	
	@Column(name="value")
	private String value;
	
	@Column(name="time_stamp")
	private Date timeStamp;
	
	public CPCBDiagnostics() {
		
	}

	

	public String getDiagParam() {
		return diagParam;
	}

	public void setDiagParam(String diagParam) {
		this.diagParam = diagParam;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	@Override
	public String toString() {
		return "CPCBDiagnostics [+  diagParam="
				+ diagParam + ", value=" + value + ", timeStamp=" + timeStamp
				+ "]";
	}



}
