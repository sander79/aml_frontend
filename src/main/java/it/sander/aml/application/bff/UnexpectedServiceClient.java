package it.sander.aml.application.bff;

import org.springframework.stereotype.Service;

import it.sander.aml.domain.presentation.model.SearchRiskProfileModel;
import it.sander.aml.domain.presentation.view.SurveyView;
import it.sander.aml.domain.presentation.view.SurveyViewList;

@Service
public interface UnexpectedServiceClient {

	SurveyView findUnexpectedById(Long id);

	SurveyViewList findUnexpected(SearchRiskProfileModel searchRiskProfileModel);

}
