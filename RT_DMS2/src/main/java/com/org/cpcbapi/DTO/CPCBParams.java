package main.java.com.org.cpcbapi.DTO;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

public class CPCBParams {

	@Column(name="param_id")
	private String paramId;
	
	@Column(name="industry_id")
	private String industryId;
	
	@Column(name="station_id")
	private String stationId;
	
	@Column(name="device_id")
	private String deviceId;
	
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

	public String getParamId() {
		return paramId;
	}

	public void setParamId(String paramId) {
		this.paramId = paramId;
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
		return "CPCBParams [paramId=" + paramId + ", industryId=" + industryId
				+ ", stationId=" + stationId + ", deviceId=" + deviceId
				+ ", parameter=" + parameter + ", value=" + value + ", unit="
				+ unit + ", timeStamp=" + timeStamp + ", flag=" + flag + "]";
	}

}
