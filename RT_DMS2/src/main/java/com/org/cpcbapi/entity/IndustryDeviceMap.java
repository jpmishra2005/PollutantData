package main.java.com.org.cpcbapi.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the industry_device_map database table.
 * 
 */
@Entity
@Table(name="industry_device_map")
@NamedQuery(name="IndustryDeviceMap.findAll", query="SELECT i FROM IndustryDeviceMap i")
public class IndustryDeviceMap implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int mappingID;

	private int deviceID;

	private int industryID;

	private int stationID;

	//bi-directional many-to-one association to PollutantData
	@OneToMany(mappedBy="industryDeviceMap", fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private List<PollutantData> pollutantData;

	public IndustryDeviceMap() {
	}

	public int getMappingID() {
		return this.mappingID;
	}

	public void setMappingID(int mappingID) {
		this.mappingID = mappingID;
	}

	public int getDeviceID() {
		return this.deviceID;
	}

	public void setDeviceID(int deviceID) {
		this.deviceID = deviceID;
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
		return "IndustryDeviceMap [mappingID=" + mappingID + ", deviceID="
				+ deviceID + ", industryID=" + industryID + ", stationID="
				+ stationID + "]";
	}

}