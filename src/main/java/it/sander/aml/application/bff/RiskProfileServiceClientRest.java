package it.sander.aml.application.bff;

import java.util.Map;

import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import it.sander.aml.domain.dto.RiskProfileDto;
import it.sander.aml.domain.dto.RiskProfileDtoList;
import it.sander.aml.domain.presentation.model.SearchRiskProfileModel;
import it.sander.aml.domain.presentation.view.RiskProfileView;
import it.sander.aml.domain.presentation.view.RiskProfileViewList;
import it.sander.aml.infrastructure.rest.BaseClientRest;

@Service
@Profile("rest")
public class RiskProfileServiceClientRest extends BaseClientRest implements RiskProfileServiceClient {
	
	private final String ENDPOINT = "/riskProfile/";

	@Override
	public RiskProfileView findRiskProfileById(Long id) {
		final String url = ENDPOINT + id;
		RiskProfileDto serviceResult =  getRestTemplate().getForObject(url, RiskProfileDto.class);	
		return mapper.map(serviceResult, RiskProfileView.class);
	}

	@Override
	public RiskProfileViewList findRiskProfile(SearchRiskProfileModel searchRiskProfileModel) {
		
		RiskProfileViewList list = null;
		
		if(searchRiskProfileModel.getId() != null) {
			RiskProfileView result = this.findRiskProfileById(searchRiskProfileModel.getId());
				list = new RiskProfileViewList(result);
		} else {
			UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(ENDPOINT);
			
			HttpEntity<RiskProfileDtoList> serviceResult = getRestTemplate().exchange(
					uriBuilder.
					   queryParam("datefrom", "{datefrom}").queryParam("dateto", "{dateto}")
					   .encode().toUriString(),
			        HttpMethod.GET,
			        entity,
			        RiskProfileDtoList.class,
			        Map.of(
							"datefrom", searchRiskProfileModel.getDateFrom(),
							"dateto", searchRiskProfileModel.getDateTo()
					));			
			
			RiskProfileDtoList body = serviceResult.getBody();
			
			list = new RiskProfileViewList();
			for(RiskProfileDto dto : body.getList()) {
				RiskProfileView view = mapper.map(dto, RiskProfileView.class);
				list.addRiskProfileView(view);
			}
		}	
		return list;
	}

}
