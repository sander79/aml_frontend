package it.sander.aml.domain.presentation.view;

import java.text.SimpleDateFormat;
import java.util.Date;

import it.sander.aml.domain.dto.SurveyDto;

/**
 * 
 *  presentation layer model
 *  
 */
public final class SurveyView {
	
    private long id;
    
    private String group;
    private String abi;
    private String serviceCode;
    private Date creationDate;
    private Date confirmDate;
    
    private String status;
    private String subjectCode;
    private String subjectType;
    private String name;
    
    private final SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd-mm-ss");

	public SurveyView(long id, String group, String abi, String serviceCode, String subjectCode) {
		this.id = id;
		this.group = group;
		this.abi = abi;
		this.serviceCode = serviceCode;
		this.subjectCode = subjectCode;
	}
    
	public SurveyView(SurveyDto surveyDto) {
	}

	public long getId() {
		return id;
	}

	public String getGroup() {
		return group;
	}

	public String getAbi() {
		return abi;
	}

	public String getServiceCode() {
		return serviceCode;
	}
	

	public String getCreationDate() {
		return dateFormatter.format(creationDate);
	}

	public SurveyView setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
		return this;
	}

	public String getConfirmDate() {
		return dateFormatter.format(confirmDate);
	}

	public SurveyView setConfirmDate(Date confirmDate) {
		this.confirmDate = confirmDate;
		return this;
	}

	public String getSubjectCode() {
		return subjectCode;
	}

	public String getSubjectType() {
		return subjectType;
	}

	public String getName() {
		return name;
	}
	
	public SurveyView setName(String name) {
		this.name = name;
		return this;
	}

	public String getStatus() {
		return status;
	}

	public SurveyView setStatus(String status) {
		this.status = status;
		return this;
	};
    
	
    
}
