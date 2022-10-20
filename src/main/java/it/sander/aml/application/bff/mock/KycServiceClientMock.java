package it.sander.aml.application.bff.mock;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import it.sander.aml.application.bff.KycServiceClient;
import it.sander.aml.domain.presentation.model.SearchSurveyModel;
import it.sander.aml.domain.presentation.view.SurveyView;
import it.sander.aml.domain.presentation.view.SurveyViewList;

@Service
@Profile("mock")
public class KycServiceClientMock implements KycServiceClient {
	
	private final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-mm-ss");

	@Override
	public SurveyView findSurveyById(Long id) {
		return new SurveyView(16588l, "GROUP", "ABI", "BATCH", "SUB1234JE44CT");
	}

	@Override
	public SurveyViewList findSurvey(SearchSurveyModel searchSurveyModel) {
		SurveyViewList surveyViewList = null;
		try {
			
			if (searchSurveyModel.getId() != null) {
				surveyViewList = new SurveyViewList(1);
				surveyViewList.addSurveyView(new SurveyView(21229l, "GROUP", "ABI", "ONLINE", "SUB111JE11CT")
						.setStatus("incomplete").setCreationDate(formatter.parse("2022-10-11-12-54")));
				return surveyViewList;
			}
			
			if (searchSurveyModel.getSubjectCode() != null) {
				surveyViewList = new SurveyViewList(1);
				surveyViewList.addSurveyView(new SurveyView(21229l, "GROUP", "ABI", "ONLINE", searchSurveyModel.getSubjectCode())
						.setStatus("incomplete").setCreationDate(formatter.parse("2022-10-11-12-54")));
				return surveyViewList;
			}

			surveyViewList = new SurveyViewList(4);

			surveyViewList.addSurveyView(new SurveyView(21229l, "GROUP", "ABI", "ONLINE", "SUB111JE11CT")
					.setStatus("incomplete").setCreationDate(formatter.parse("2022-10-11-12-54")));
			surveyViewList.addSurveyView(new SurveyView(20221l, "GROUP", "ABI", "BATCH", "SUB222JE22CT")
					.setStatus("submitted").setCreationDate(formatter.parse("2022-09-28-17-22")));
			surveyViewList.addSurveyView(new SurveyView(19882l, "GROUP", "ABI", "BATCH", "SUB333JE33CT")
					.setStatus("submitted").setCreationDate(formatter.parse("2022-09-16-12-46")));
			surveyViewList.addSurveyView(new SurveyView(18272l, "GROUP", "ABI", "BATCH", "SUB444JE44CT")
					.setStatus("submitted").setCreationDate(formatter.parse("2022-09-12-08-01")));

			return surveyViewList;
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return surveyViewList;
	}

}
