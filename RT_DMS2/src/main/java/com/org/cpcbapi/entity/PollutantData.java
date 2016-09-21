package main.java.com.org.cpcbapi.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the pollutant_data database table.
 * 
 */
@Entity
@Table(name="pollutant_data")
@NamedQuery(name="PollutantData.findAll", query="SELECT p FROM PollutantData p")
public class PollutantData implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int pollutantID;

	private int data_broadCast_frequency;

	@Column(name="diag_param_name", length=45)
	private String diagParamName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="diag_timestamp")
	private Date diagTimestamp;

	@Column(name="diag_value", length=45)
	private String diagValue;

	@Column(length=1)
	private String flag;

	@Column(name="measurement_range")
	private int measurementRange;

	@Column(length=45)
	private String measurement_Unit;

	private int parameter;

	//bi-directional many-to-one association to IndustryDeviceMap
	@ManyToOne(targetEntity=IndustryDeviceMap.class, fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="Industry_Device_Map_ID")
	private IndustryDeviceMap industryDeviceMap;

	public PollutantData() {
	}

	public int getPollutantID() {
		return this.pollutantID;
	}

	public void setPollutantID(int pollutantID) {
		this.pollutantID = pollutantID;
	}

	public int getData_broadCast_frequency() {
		return this.data_broadCast_frequency;
	}

	public void setData_broadCast_frequency(int data_broadCast_frequency) {
		this.data_broadCast_frequency = data_broadCast_frequency;
	}

	public String getDiagParamName() {
		return this.diagParamName;
	}

	public void setDiagParamName(String diagParamName) {
		this.diagParamName = diagParamName;
	}

	public Date getDiagTimestamp() {
		return this.diagTimestamp;
	}

	public void setDiagTimestamp(Date diagTimestamp) {
		this.diagTimestamp = diagTimestamp;
	}

	public String getDiagValue() {
		return this.diagValue;
	}

	public void setDiagValue(String diagValue) {
		this.diagValue = diagValue;
	}

	public String getFlag() {
		return this.flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public int getMeasurementRange() {
		return this.measurementRange;
	}

	public void setMeasurementRange(int measurementRange) {
		this.measurementRange = measurementRange;
	}

	public String getMeasurement_Unit() {
		return this.measurement_Unit;
	}

	public void setMeasurement_Unit(String measurement_Unit) {
		this.measurement_Unit = measurement_Unit;
	}

	public int getParameter() {
		return this.parameter;
	}

	public void setParameter(int parameter) {
		this.parameter = parameter;
	}

	public IndustryDeviceMap getIndustryDeviceMap() {
		return this.industryDeviceMap;
	}

	public void setIndustryDeviceMap(IndustryDeviceMap industryDeviceMap) {
		this.industryDeviceMap = industryDeviceMap;
	}

}