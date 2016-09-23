package main.java.com.org.cpcbapi.keys;

import java.io.Serializable;

import javax.persistence.*;

import main.java.com.org.cpcbapi.entity.PollutantData;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the industry_device_map database table.
 * 
 */
@Entity
@Table(name="industry_device_map")
public class IndustryStationKey implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int mappingID;
	private int industryID;
	private int stationID;

	//bi-directional many-to-one association to PollutantData
	@OneToMany(mappedBy="industryDeviceMap",cascade=CascadeType.ALL)
	private List<PollutantData> pollutantData=new ArrayList<PollutantData>();

	public IndustryStationKey() {
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

	@Override
	public String toString() {
		return "IndustryStationKey [mappingID=" + mappingID + ", industryID="
				+ industryID + ", stationID=" + stationID + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + industryID;
		result = prime * result + mappingID;
		result = prime * result + stationID;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IndustryStationKey other = (IndustryStationKey) obj;
		if (industryID != other.industryID)
			return false;
		if (mappingID != other.mappingID)
			return false;
		if (stationID != other.stationID)
			return false;
		return true;
	}
	
	
}