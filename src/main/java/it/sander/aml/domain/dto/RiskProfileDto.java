package it.sander.aml.domain.dto;

import java.io.Serializable;
import java.util.Date;

public class RiskProfileDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
    private long id;
    
    private String group;
    private String abi;
    private String serviceCode;
    private Date date;
    
    private String subjectCode;
    private String value;
    private String riskBand;
	
	public RiskProfileDto() {}

	public RiskProfileDto(long id, String group, String abi, String serviceCode, String subjectCode) {
		super();
		this.id = id;
		this.group = group;
		this.abi = abi;
		this.serviceCode = serviceCode;
		this.subjectCode = subjectCode;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getAbi() {
		return abi;
	}

	public void setAbi(String abi) {
		this.abi = abi;
	}

	public String getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getRiskBand() {
		return riskBand;
	}

	public void setRiskBand(String riskBand) {
		this.riskBand = riskBand;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
