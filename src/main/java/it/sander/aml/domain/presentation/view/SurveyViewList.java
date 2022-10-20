package it.sander.aml.domain.presentation.view;

import java.util.ArrayList;
import java.util.List;

public class SurveyViewList {
	private List<SurveyView> list;
	
	public SurveyViewList() {
		list = new ArrayList<>();
	}

	public SurveyViewList(int size) {
		list = new ArrayList<>(size);
	}
	
	public SurveyViewList(SurveyView oneItem) {
		if(oneItem==null) {
			new SurveyViewList(0);
		} else {
			new SurveyViewList(1);
			list.add(oneItem);
		}
	}

	public List<SurveyView> getList() {
		return list;
	}

	public boolean addSurveyView(SurveyView surveyView) {
		return this.list.add(surveyView);
	}

}
