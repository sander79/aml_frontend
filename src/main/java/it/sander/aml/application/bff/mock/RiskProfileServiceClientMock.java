package it.sander.aml.application.bff.mock;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import it.sander.aml.application.bff.RiskProfileServiceClient;
import it.sander.aml.domain.presentation.model.SearchRiskProfileModel;
import it.sander.aml.domain.presentation.view.RiskProfileView;
import it.sander.aml.domain.presentation.view.RiskProfileViewList;

@Service
@Profile("mock")
public class RiskProfileServiceClientMock implements RiskProfileServiceClient {
	
	private final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-mm-ss");

	@Override
	public RiskProfileView findRiskProfileById(Long id) {
		return new RiskProfileView(16588l, "GROUP", "ABI", "BATCH", "SUB1234JE44CT");
	}

	@Override
	public RiskProfileViewList findRiskProfile(SearchRiskProfileModel searchRiskProfileModel) {
		RiskProfileViewList riskProfileViewList = null;
		try {
			
			if (searchRiskProfileModel.getId() != null) {
				riskProfileViewList = new RiskProfileViewList(1);
				riskProfileViewList.addRiskProfileView(new RiskProfileView(21229l, "GROUP", "ABI", "ONLINE", "SUB111JE11CT")
						.setDate(formatter.parse("2022-10-11-12-54")).setValue(13).setRiskBand("C"));
				return riskProfileViewList;
			}
			
			if (searchRiskProfileModel.getSubjectCode() != null) {
				riskProfileViewList = new RiskProfileViewList(1);
				riskProfileViewList.addRiskProfileView(new RiskProfileView(21229l, "GROUP", "ABI", "ONLINE", searchRiskProfileModel.getSubjectCode())
						.setDate(formatter.parse("2022-10-11-12-54")).setValue(13).setRiskBand("C"));
				return riskProfileViewList;
			}

			riskProfileViewList = new RiskProfileViewList(4);

			riskProfileViewList.addRiskProfileView(new RiskProfileView(21229l, "GROUP", "ABI", "ONLINE", "SUB111JE11CT")
					.setDate(formatter.parse("2022-10-11-12-54")).setValue(44).setRiskBand("B"));
			riskProfileViewList.addRiskProfileView(new RiskProfileView(20221l, "GROUP", "ABI", "BATCH", "SUB222JE22CT")
					.setDate(formatter.parse("2022-10-11-12-54")).setValue(23).setRiskBand("B"));
			riskProfileViewList.addRiskProfileView(new RiskProfileView(19882l, "GROUP", "ABI", "BATCH", "SUB333JE33CT")
					.setDate(formatter.parse("2022-10-11-12-54")).setValue(8).setRiskBand("D"));
			riskProfileViewList.addRiskProfileView(new RiskProfileView(18272l, "GROUP", "ABI", "BATCH", "SUB444JE44CT")
					.setDate(formatter.parse("2022-10-11-12-54")).setValue(7).setRiskBand("D"));

			return riskProfileViewList;
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return riskProfileViewList;
	}

}
