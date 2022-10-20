package it.sander.aml.application.webController;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.AuthenticatedPrincipal;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import it.sander.aml.application.bff.KycServiceClient;
import it.sander.aml.domain.presentation.model.SearchSurveyModel;
import it.sander.aml.domain.presentation.view.SurveyView;
import it.sander.aml.domain.presentation.view.SurveyViewList;

@Controller
@RequestMapping("/aml/kyc")
public class KycManagerController {
	
	private static Logger log = LoggerFactory.getLogger(KycManagerController.class);

	
	@Autowired
	private KycServiceClient kycServiceClient;

    
    @GetMapping({"", "/"})
    @Secured("ROLE_ADMIN")
    public String main(Authentication auth, Model model) {
    	log.info("@/aml/kyc  user:{}", auth.getName());
    	
        
		SurveyViewList surveyList = kycServiceClient.findSurvey(new SearchSurveyModel(1,5) );       
        model.addAttribute("surveyList", surveyList.getList());
        
        return "kycMainPage";
    }
    
    @PostMapping("/searchSurvey")
    public String searchSurvey(Authentication auth,
    		@Valid @ModelAttribute("searchSurveyModel") SearchSurveyModel SearchSurveyModel, Model model, BindingResult result) {
    	if (result.hasErrors()) {
            return "error";
        }
    	
    	log.info("@/aml/kyc/searchSurvey  user:{}", auth.getName());
        
        SurveyViewList surveyList = kycServiceClient.findSurvey(SearchSurveyModel);       
        model.addAttribute("surveyList", surveyList.getList());
        
        return "kycMainPage";
    }
    
    @GetMapping("/{id}")
    public String kycById(Authentication auth, @PathVariable long id, Model model, final RedirectAttributes redirectAttributes) {
    	log.info("@/aml/kyc/{}  user:{}", id, auth.getName());
        
        SurveyView surveyList = kycServiceClient.findSurveyById(id);       
        model.addAttribute("surveyList", surveyList);
        
        return "kycDetail";
    }

}
