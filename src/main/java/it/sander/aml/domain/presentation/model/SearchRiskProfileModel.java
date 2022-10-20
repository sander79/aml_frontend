package it.sander.aml.domain.presentation.model;

public class SearchRiskProfileModel {
    private Long id;
    
    private String subjectCode;
    private String surveyStatus;

    private String dateTo;
    private String dateFrom;

    private int page;
    private int size;
    
	public SearchRiskProfileModel() {}

	public SearchRiskProfileModel(String dateTo, String dateFrom) {
		super();
		this.dateTo = dateTo;
		this.dateFrom = dateFrom;
	}

	public SearchRiskProfileModel(int page, int size) {
		super();
		this.page = page;
		this.size = size;
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

	public String getDateTo() {
		return dateTo;
	}

	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}

	public String getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
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