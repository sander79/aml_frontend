package it.sander.aml.domain.presentation.model;

import javax.validation.constraints.AssertTrue;

public class SearchSurveyModel {
    private Long id;
    
    private String subjectCode;
    private String surveyStatus;

    private String surveyDateTo;
    private String surveyDateFrom;

    private int page;
    private int size;
    
	public SearchSurveyModel() {}

	public SearchSurveyModel(String surveyDateTo, String surveyDateFrom) {
		super();
		this.surveyDateTo = surveyDateTo;
		this.surveyDateFrom = surveyDateFrom;
	}

	public SearchSurveyModel(int page, int size) {
		super();
		this.page = page;
		this.size = size;
	}


	@AssertTrue(message = "id selector conflicts with others")
	public boolean idSelector() {
		return id!=null && (subjectCode==null && surveyStatus==null && surveyDateTo==null && surveyDateFrom==null);
	}
	
	@AssertTrue(message = "subjectCode selector conflicts with others")
	public boolean subjectCodeSelector() {
		return subjectCode!=null && (id==null && surveyStatus==null && surveyDateTo==null && surveyDateFrom==null);
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String getSurveyStatus() {
		return surveyStatus;
	}

	public void setSurveyStatus(String surveyStatus) {
		this.surveyStatus = surveyStatus;
	}

	public String getSurveyDateTo() {
		return surveyDateTo;
	}

	public void setSurveyDateTo(String surveyDateTo) {
		this.surveyDateTo = surveyDateTo;
	}

	public String getSurveyDateFrom() {
		return surveyDateFrom;
	}

	public void setSurveyDateFrom(String surveyDateFrom) {
		this.surveyDateFrom = surveyDateFrom;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
}