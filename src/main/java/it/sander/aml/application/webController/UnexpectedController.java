package it.sander.aml.application.webController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.sander.aml.application.bff.UnexpectedServiceClient;
import it.sander.aml.domain.presentation.model.SearchRiskProfileModel;
import it.sander.aml.domain.presentation.view.SurveyViewList;

@Controller
@RequestMapping("/aml/unexpected")
public class UnexpectedController {
	
	private static Logger log = LoggerFactory.getLogger(UnexpectedController.class);
	
	private UnexpectedServiceClient serviceClient;
	
    @GetMapping({"", "/"})
    public String main(Model model) {
    	log.debug("@ /Unexpected/%");
        
		SurveyViewList riskProfileList = serviceClient.findUnexpected(new SearchRiskProfileModel(1,5) );       
        model.addAttribute("unexpectedList", riskProfileList.getList());
        
        return "riskProfileMainPage";
    }

}
