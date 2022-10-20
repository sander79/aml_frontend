package it.sander.aml.application.bff;

import org.springframework.stereotype.Service;

import it.sander.aml.domain.presentation.model.SearchRiskProfileModel;
import it.sander.aml.domain.presentation.view.RiskProfileView;
import it.sander.aml.domain.presentation.view.RiskProfileViewList;

@Service
public interface RiskProfileServiceClient {

	RiskProfileView findRiskProfileById(Long id);

	RiskProfileViewList findRiskProfile(SearchRiskProfileModel searchRiskProfileModel);

}
