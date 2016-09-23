package main.java.com.org.cpcbapi.DTO;

import java.util.ArrayList;
import java.util.List;

import main.java.com.org.cpcbapi.entity.DiagnosticData;
import main.java.com.org.cpcbapi.entity.Diagnostics;
import main.java.com.org.cpcbapi.entity.ParamData;
import main.java.com.org.cpcbapi.entity.Params;

public class Data {

	
	private int deviceId;
	
	private List<ParamData> params=new ArrayList<ParamData>();
	
	private List<DiagnosticData> diagnostics=new ArrayList<DiagnosticData>();
	
	public Data() {
		
	}

	public int getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}

	public List<ParamData> getParams() {
		return params;
	}

	public void setParams(List<ParamData> params) {
		this.params = params;
	}

	public List<DiagnosticData> getDiagnostics() {
		return diagnostics;
	}

	public void setDiagnostics(List<DiagnosticData> diagnostics) {
		this.diagnostics = diagnostics;
	}

	@Override
	public String toString() {
		return "Data [deviceId=" + deviceId + ", params=" + params
				+ ", diagnostics=" + diagnostics + "]";
	}

	public Data(int deviceId) {
		super();
		this.deviceId = deviceId;
	}

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
		
}
