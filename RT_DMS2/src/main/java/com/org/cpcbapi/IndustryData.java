package main.java.com.org.cpcbapi;

public class IndustryData {
	
	private String industryId;
	
	private String stationId;
	
	private StationData stationData;

	public IndustryData() {
		
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

	public StationData getStationData() {
		return stationData;
	}

	public void setStationData(StationData stationData) {
		this.stationData = stationData;
	}

}
