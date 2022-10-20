package it.sander.aml.domain.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class RiskProfileDtoList implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private List<RiskProfileDto> list;
	
	public RiskProfileDtoList() {
		list = new LinkedList<>();
	}

	public RiskProfileDtoList(int size) {
		list = new ArrayList<>(size);
	}
	
	public RiskProfileDtoList(RiskProfileDto oneItem) {
		if(oneItem==null) {
			new RiskProfileDtoList(0);
		} else {
			new RiskProfileDtoList(1);
			list.add(oneItem);
		}
	}

	public List<RiskProfileDto> getList() {
		return list;
	}

	public boolean addSurveyDto(RiskProfileDto surveyView) {
		return this.list.add(surveyView);
	}

}
