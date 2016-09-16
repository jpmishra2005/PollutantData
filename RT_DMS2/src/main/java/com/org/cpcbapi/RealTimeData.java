package main.java.com.org.cpcbapi;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name="Real_Time_Data")
public class RealTimeData {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  
  public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getIndustryCategory() {
	return industryCategory;
}
public void setIndustryCategory(String industryCategory) {
	this.industryCategory = industryCategory;
}
public String getIndustryCode() {
	return industryCode;
}
public void setIndustryCode(String industryCode) {
	this.industryCode = industryCode;
}
public String getIndustryId() {
	return industryId;
}
public void setIndustryId(String industryId) {
	this.industryId = industryId;
}
public String getIndustryName() {
	return industryName;
}
public void setIndustryName(String industryName) {
	this.industryName = industryName;
}
public String getLatitude() {
	return latitude;
}
public void setLatitude(String latitude) {
	this.latitude = latitude;
}
public String getLongitude() {
	return longitude;
}
public void setLongitude(String longitude) {
	this.longitude = longitude;
}
public String getSpcbRegionalOffice() {
	return spcbRegionalOffice;
}
public void setSpcbRegionalOffice(String spcbRegionalOffice) {
	this.spcbRegionalOffice = spcbRegionalOffice;
}
public String getGangaBasin() {
	return gangaBasin;
}
public void setGangaBasin(String gangaBasin) {
	this.gangaBasin = gangaBasin;
}
public String getIndustryUsers() {
	return industryUsers;
}
public void setIndustryUsers(String industryUsers) {
	this.industryUsers = industryUsers;
}
public String getContact() {
	return contact;
}
public void setContact(String contact) {
	this.contact = contact;
}
public String getStationID() {
	return stationID;
}
public void setStationID(String stationID) {
	this.stationID = stationID;
}
public String getStationName() {
	return stationName;
}
public void setStationName(String stationName) {
	this.stationName = stationName;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getDeviceIDorSerialNo() {
	return deviceIDorSerialNo;
}
public void setDeviceIDorSerialNo(String deviceIDorSerialNo) {
	this.deviceIDorSerialNo = deviceIDorSerialNo;
}
public String getVendor() {
	return vendor;
}
public void setVendor(String vendor) {
	this.vendor = vendor;
}
public String getMake() {
	return make;
}
public void setMake(String make) {
	this.make = make;
}
public String getModel() {
	return model;
}
public void setModel(String model) {
	this.model = model;
}
public String getSystemType() {
	return systemType;
}
public void setSystemType(String systemType) {
	this.systemType = systemType;
}
public String getParameter() {
	return parameter;
}
public void setParameter(String parameter) {
	this.parameter = parameter;
}
public String getUnitOfMeasurement() {
	return unitOfMeasurement;
}
public void setUnitOfMeasurement(String unitOfMeasurement) {
	this.unitOfMeasurement = unitOfMeasurement;
}
public String getDataBroadcastFrequency() {
	return dataBroadcastFrequency;
}
public void setDataBroadcastFrequency(String dataBroadcastFrequency) {
	this.dataBroadcastFrequency = dataBroadcastFrequency;
}
public boolean isFlag() {
	return flag;
}
public void setFlag(boolean flag) {
	this.flag = flag;
}
public String getAcceptableMeasurementRange() {
	return acceptableMeasurementRange;
}
public void setAcceptableMeasurementRange(String acceptableMeasurementRange) {
	this.acceptableMeasurementRange = acceptableMeasurementRange;
}
@NotNull
  @Size(min = 3, max = 80)
  private String email;
  
  @NotNull
  @Size(min = 2, max = 80)
  private String name;
  
  
  @NotNull
  @Size(min = 2, max = 80)
  private String industryCategory;
  @NotNull
  @Size(min = 2, max = 80)
  private String industryCode;
  @NotNull
  @Size(min = 2, max = 80)
  private String industryId;	
  @NotNull
  @Size(min = 2, max = 80)
  private String industryName;	
  @NotNull
  @Size(min = 2, max = 80)
  private String latitude;	
  @NotNull
  @Size(min = 2, max = 80)
  private String longitude;	
  @NotNull
  @Size(min = 2, max = 80)
  private String spcbRegionalOffice;	
  @NotNull
  @Size(min = 2, max = 80)
  private String gangaBasin;	
  @NotNull
  @Size(min = 2, max = 80)
  private String industryUsers;	
  @NotNull
  @Size(min = 2, max = 80)
  private String contact;	
  @NotNull
  @Size(min = 2, max = 80)
  private String stationID;	
  @NotNull
  @Size(min = 2, max = 80)
  private String stationName;	
  @NotNull
  @Size(min = 2, max = 80)
  private String type;	
  @NotNull
  @Size(min = 2, max = 80)
  private String deviceIDorSerialNo;	
  @NotNull
  @Size(min = 2, max = 80)
  private String vendor;	
  @NotNull
  @Size(min = 2, max = 80)
  private String make;	
  @NotNull
  @Size(min = 2, max = 80)
  private String model;	
  @NotNull
  @Size(min = 2, max = 80)
  private String systemType;
  @NotNull
  @Size(min = 2, max = 80)
  private String parameter;	
  @NotNull
  @Size(min = 2, max = 80)
  private String unitOfMeasurement;	
  @NotNull
  @Size(min = 2, max = 80)
  private String dataBroadcastFrequency;	
  @NotNull
  @Size(min = 2, max = 80)
  private boolean flag;
  @NotNull
  @Size(min = 2, max = 80)
  private String acceptableMeasurementRange;
  private String address;

	//bi-directional one-to-one association to Address
	@OneToOne
	@JoinColumn(name="AddressID")
	private Address addressBean;
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

public RealTimeData() { }
}