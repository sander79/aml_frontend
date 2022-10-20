package it.sander.aml.application.bff;

import org.springframework.stereotype.Service;

import it.sander.aml.domain.presentation.model.SearchSurveyModel;
import it.sander.aml.domain.presentation.view.SurveyView;
import it.sander.aml.domain.presentation.view.SurveyViewList;

@Service
public interface KycServiceClient {

	SurveyView findSurveyById(Long id);

	SurveyViewList findSurvey(SearchSurveyModel searchSurveyModel);

}
