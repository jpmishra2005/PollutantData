package main.java.com.org.cpcbapi.DTO;

import java.util.ArrayList;
import java.util.List;

import main.java.com.org.cpcbapi.entity.Diagnostics;
import main.java.com.org.cpcbapi.entity.Params;

public class Data {

	private int deviceId;
	
	private List<CPCBParams> params=new ArrayList<CPCBParams>();
	
	private List<CPCBDiagnostics> diagnostics=new ArrayList<CPCBDiagnostics>();
	
	public Data() {
		
	}

	public int getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}

	public List<CPCBParams> getParams() {
		return params;
	}

	public void setParams(List<CPCBParams> params) {
		this.params = params;
	}

	public List<CPCBDiagnostics> getDiagnostics() {
		return diagnostics;
	}

	public void setDiagnostics(List<CPCBDiagnostics> diagnostics) {
		this.diagnostics = diagnostics;
	}

	@Override
	public String toString() {
		return "Data [deviceId=" + deviceId + ", params=" + params
				+ ", diagnostics=" + diagnostics + "]";
	}

	
}
