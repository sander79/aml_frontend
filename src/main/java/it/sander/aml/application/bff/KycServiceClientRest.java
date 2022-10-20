package it.sander.aml.application.bff;

import java.util.Map;

import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import it.sander.aml.domain.dto.SurveyDto;
import it.sander.aml.domain.dto.SurveyDtoList;
import it.sander.aml.domain.presentation.model.SearchSurveyModel;
import it.sander.aml.domain.presentation.view.SurveyView;
import it.sander.aml.domain.presentation.view.SurveyViewList;
import it.sander.aml.infrastructure.rest.BaseClientRest;

@Service
@Profile("rest")
public class KycServiceClientRest extends BaseClientRest implements KycServiceClient {
	
	private final String ENDPOINT = "/surveys/";

	@Override
	public SurveyView findSurveyById(Long id) {
		final String url = ENDPOINT + id;
		SurveyDto serviceResult =  getRestTemplate().getForObject(url, SurveyDto.class);	
		return mapper.map(serviceResult, SurveyView.class);
	}

	@Override
	public SurveyViewList findSurvey(SearchSurveyModel searchSurveyModel) {
		
		SurveyViewList list = null;
		
		if(searchSurveyModel.getId() != null) {
			SurveyView result = this.findSurveyById(searchSurveyModel.getId());
				list = new SurveyViewList(result);
		} else {
			UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(ENDPOINT);
			
			HttpEntity<SurveyDtoList> serviceResult = getRestTemplate().exchange(
					uriBuilder.
					   queryParam("datefrom", "{datefrom}").queryParam("dateto", "{dateto}")
					   .encode().toUriString(),
			        HttpMethod.GET,
			        entity,
			        SurveyDtoList.class,
			        Map.of(
							"datefrom", searchSurveyModel.getSurveyDateFrom(),
							"dateto", searchSurveyModel.getSurveyDateTo()
					));			
			
			SurveyDtoList body = serviceResult.getBody();
			
			list = new SurveyViewList();
			for(SurveyDto dto : body.getList()) {
				SurveyView view = mapper.map(dto, SurveyView.class);
				list.addSurveyView(view);
			}
		}
		
		return list;
	}

}
