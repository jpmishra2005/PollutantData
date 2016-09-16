package main.java.com.org.cpcbapi;

import java.util.List;

public class StationData {

	private String deviceId;
	
	private List<Params> params;
	
	private List<Diagnostics> diagnostics;
	
	public StationData() {
		
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public List<Params> getParams() {
		return params;
	}

	public void setParams(List<Params> params) {
		this.params = params;
	}

	public List<Diagnostics> getDiagnostics() {
		return diagnostics;
	}

	public void setDiagnostics(List<Diagnostics> diagnostics) {
		this.diagnostics = diagnostics;
	}

}
