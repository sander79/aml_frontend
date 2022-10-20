package it.sander.aml.domain.presentation.view;

import java.util.ArrayList;
import java.util.List;

public class RiskProfileViewList {
	private List<RiskProfileView> list;
	
	public RiskProfileViewList() {
		list = new ArrayList<>();
	}

	public RiskProfileViewList(int size) {
		list = new ArrayList<>(size);
	}
	
	public RiskProfileViewList(RiskProfileView oneItem) {
		if(oneItem==null) {
			new RiskProfileViewList(0);
		} else {
			new RiskProfileViewList(1);
			list.add(oneItem);
		}
	}

	public List<RiskProfileView> getList() {
		return list;
	}

	public boolean addRiskProfileView(RiskProfileView surveyView) {
		return this.list.add(surveyView);
	}

}
