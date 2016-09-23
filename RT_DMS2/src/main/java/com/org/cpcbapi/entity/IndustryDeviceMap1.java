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
public class IndustryDeviceMap1 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int mappingid;

	@Column(nullable=false)
	private int deviceid;

	@Column(nullable=false)
	private int industryid;

	@Column(nullable=false)
	private int stationid;

	//bi-directional many-to-one association to PollutantData
	@OneToMany(mappedBy="industryDeviceMap")
	private List<PollutantData> pollutantData;

	public IndustryDeviceMap1() {
	}

	public int getMappingid() {
		return this.mappingid;
	}

	public void setMappingid(int mappingid) {
		this.mappingid = mappingid;
	}

	public int getDeviceid() {
		return this.deviceid;
	}

	public void setDeviceid(int deviceid) {
		this.deviceid = deviceid;
	}

	public int getIndustryid() {
		return this.industryid;
	}

	public void setIndustryid(int industryid) {
		this.industryid = industryid;
	}

	public int getStationid() {
		return this.stationid;
	}

	public void setStationid(int stationid) {
		this.stationid = stationid;
	}

	public List<PollutantData> getPollutantData() {
		return this.pollutantData;
	}

	public void setPollutantData(List<PollutantData> pollutantData) {
		this.pollutantData = pollutantData;
	}

/*	public PollutantData addPollutantData(PollutantData pollutantData) {
		getPollutantData().add(pollutantData);
		pollutantData.setIndustryDeviceMap(this);

		return pollutantData;
	}
*/
	public PollutantData removePollutantData(PollutantData pollutantData) {
		getPollutantData().remove(pollutantData);
		pollutantData.setIndustryDeviceMap(null);

		return pollutantData;
	}

}