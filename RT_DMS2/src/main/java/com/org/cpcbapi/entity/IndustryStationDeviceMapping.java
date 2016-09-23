package main.java.com.org.cpcbapi.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the industry_device_map database table.
 * 
 */
@Entity
@Table(name="industry_device_map")
public class IndustryStationDeviceMapping implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int mappingID;

	private int deviceID;

	private int industryID;

	private int stationID;

	//bi-directional many-to-one association to PollutantData
	@OneToMany(mappedBy="industryDeviceMap",cascade=CascadeType.ALL)
	private List<PollutantData> pollutantData=new ArrayList<PollutantData>();

	public IndustryStationDeviceMapping() {
	}

	public int getMappingID() {
		return this.mappingID;
	}

	public void setMappingID(int mappingID) {
		this.mappingID = mappingID;
	}

	
	public int getIndustryID() {
		return this.industryID;
	}

	public void setIndustryID(int industryID) {
		this.industryID = industryID;
	}

	public int getStationID() {
		return this.stationID;
	}

	public void setStationID(int stationID) {
		this.stationID = stationID;
	}

	public List<PollutantData> getPollutantData() {
		return this.pollutantData;
	}

	public void setPollutantData(List<PollutantData> pollutantData) {
		this.pollutantData = pollutantData;
	}
	
	public int getDeviceID() {
		return deviceID;
	}

	public void setDeviceID(int deviceID) {
		this.deviceID = deviceID;
	}

	public PollutantData addPollutantData(PollutantData pollutantData) {
		getPollutantData().add(pollutantData);
		pollutantData.setIndustryDeviceMap(this);

		return pollutantData;
	}

	public PollutantData removePollutantData(PollutantData pollutantData) {
		getPollutantData().remove(pollutantData);
		pollutantData.setIndustryDeviceMap(null);

		return pollutantData;
	}
	

	@Override
	public String toString() {
		return "IndustryStationDeviceMapping [mappingID=" + mappingID
				+ ", deviceID=" + deviceID + ", industryID=" + industryID
				+ ", stationID=" + stationID + "]";
	}

}