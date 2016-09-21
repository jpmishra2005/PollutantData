package main.java.com.org.cpcbapi.DTO;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CPCB_Diagnostics", schema="CPCBDATAMANAGEMENT")
public class CPCBDiagnostics {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="diagnostic_id")
	private String diagnosticId;
	
	@Column(name="industry_id")
	private String industryId;
	
	@Column(name="station_id")
	private String stationId;
	
	@Column(name="device_id")
	private String deviceId;
	
	@Column(name="diag_param")
	private String diagParam;
	
	@Column(name="value")
	private String value;
	
	@Column(name="time_stamp")
	private Date timeStamp;
	
	public CPCBDiagnostics() {
		
	}

	public String getDiagnosticId() {
		return diagnosticId;
	}

	public void setDiagnosticId(String diagnosticId) {
		this.diagnosticId = diagnosticId;
	}

	public String getIndustryId() {
		return industryId;
	}

	public void setIndustryId(String industryId) {
		this.industryId = industryId;
	}

	public String getStationId() {
		return stationId;
	}

	public void setStationId(String stationId) {
		this.stationId = stationId;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
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
		return "CPCBDiagnostics [diagnosticId=" + diagnosticId
				+ ", industryId=" + industryId + ", stationId=" + stationId
				+ ", deviceId=" + deviceId + ", diagParam=" + diagParam
				+ ", value=" + value + ", timeStamp=" + timeStamp + "]";
	}


}
