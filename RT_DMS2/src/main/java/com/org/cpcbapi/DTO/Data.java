package main.java.com.org.cpcbapi.DTO;

import java.util.ArrayList;
import java.util.List;

import main.java.com.org.cpcbapi.entity.Diagnostics;
import main.java.com.org.cpcbapi.entity.Params;

public class Data {

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + deviceId;
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
		Data other = (Data) obj;
		if (deviceId != other.deviceId)
			return false;
		return true;
	}

	private int deviceId;
	
	private List<CPCBParams> params=new ArrayList<CPCBParams>();
	
	private List<CPCBDiagnostics> diagnostics=new ArrayList<CPCBDiagnostics>();
	
	public Data() {
		
	}
	
public Data(int deviceId) {
		this.deviceId=deviceId;
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
