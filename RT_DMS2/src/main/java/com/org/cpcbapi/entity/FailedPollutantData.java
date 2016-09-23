package main.java.com.org.cpcbapi.entity;

import java.io.Serializable;

import javax.persistence.*;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * The persistent class for the pollutant_data database table.
 * 
 */
@Entity
@Table(name = "pollutant_data")
public class FailedPollutantData implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int failedPollutantDataID;

	
	@Embedded
	private ParamData paramData;
	@Embedded
	private DiagnosticData diagData;
	
	private int tryCounts;
	// bi-directional many-to-one association to IndustryDeviceMap
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "Industry_Device_Map_ID")
	private IndustryStationDeviceMapping industryDeviceMap;

	public FailedPollutantData() {
	}

	public int getFailedPollutantDataID() {
		return failedPollutantDataID;
	}

	public void setFailedPollutantDataID(int failedPollutantDataID) {
		this.failedPollutantDataID = failedPollutantDataID;
	}
	public ParamData getParamData() {
		return paramData;
	}

	public void setParamData(ParamData paramData) {
		this.paramData = paramData;
	}

	public DiagnosticData getDiagData() {
		return diagData;
	}

	public void setDiagData(DiagnosticData diagData) {
		this.diagData = diagData;
	}

	public IndustryStationDeviceMapping getIndustryDeviceMap() {
		return industryDeviceMap;
	}

	public void setIndustryDeviceMap(IndustryStationDeviceMapping industryDeviceMap) {
		this.industryDeviceMap = industryDeviceMap;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

	public int getTryCounts() {
		return tryCounts;
	}

	public void setTryCounts(int tryCounts) {
		this.tryCounts = tryCounts;
	}

	@Override
	public String toString() {
		return "PollutantData [failedPollutantDataID=" + failedPollutantDataID
				+ ", paramData=" + paramData + ", diagData=" + diagData
				+ ", industryDeviceMap=" + industryDeviceMap + "]";
	}






}