package it.sander.aml.domain.presentation.view;

import java.text.SimpleDateFormat;
import java.util.Date;

import it.sander.aml.domain.dto.RiskProfileDto;

/**
 * 
 *  presentation layer model
 *  
 */
public final class RiskProfileView {
	
    private long id;
    
    private String group;
    private String abi;
    private String serviceCode;
    private Date date;
    
    private String subjectCode;
    private int value;
    private String riskBand;
    
    private final SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd-mm-ss");

	public RiskProfileView(long id, String group, String abi, String serviceCode, String subjectCode) {
		this.id = id;
		this.group = group;
		this.abi = abi;
		this.serviceCode = serviceCode;
		this.subjectCode = subjectCode;
	}
    
	public RiskProfileView(RiskProfileDto dto) {
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

	public RiskProfileView setDate(Date date) {
		this.date = date;
		return this;
	}

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public int getValue() {
		return value;
	}

	public RiskProfileView setValue(int value) {
		this.value = value;
		return this;
	}

	public String getRiskBand() {
		return riskBand;
	}

	public RiskProfileView setRiskBand(String riskBand) {
		this.riskBand = riskBand;
		return this;
	}

	public SimpleDateFormat getDateFormatter() {
		return dateFormatter;
	}
	
}
