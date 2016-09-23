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
public class DiagnosticData {

	@Column(name = "diag_param")
	private String diagParam;

	@Column(name = "diag_value")
	private String value;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "diag_time_stamp")
	private Date timeStamp;

	public DiagnosticData() {

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
		return "DiagnosticData [diagParam=" + diagParam + ", value=" + value
				+ ", timeStamp=" + timeStamp + "]";
	}



}
