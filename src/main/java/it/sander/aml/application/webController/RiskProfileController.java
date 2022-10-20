package it.sander.aml.application.webController;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import it.sander.aml.application.bff.RiskProfileServiceClient;
import it.sander.aml.domain.presentation.model.SearchRiskProfileModel;
import it.sander.aml.domain.presentation.view.RiskProfileView;
import it.sander.aml.domain.presentation.view.RiskProfileViewList;

@Controller
@RequestMapping("/aml/riskProfile")
public class RiskProfileController {
	
	private static Logger log = LoggerFactory.getLogger(KycManagerController.class);
	
	@Autowired
	private RiskProfileServiceClient serviceClient;

    
    @GetMapping({"", "/"})
    public String main(Model model) {
    	log.debug("@ /RiskProfile/%");
        
		RiskProfileViewList riskProfileList = serviceClient.findRiskProfile(new SearchRiskProfileModel(1,5) );       
        model.addAttribute("riskProfileList", riskProfileList.getList());
        
        return "riskProfileMainPage";
    }
    
    @PostMapping("/searchRiskProfile")
    public String searchRiskProfile(@Valid @ModelAttribute("searchRiskProfileModel") SearchRiskProfileModel SearchRiskProfileModel, Model model, BindingResult result) {
    	if (result.hasErrors()) {
            return "error";
        }
    	
    	log.debug("@GET /searchRiskProfile/%");

        RiskProfileViewList riskProfileList = serviceClient.findRiskProfile(SearchRiskProfileModel);       
        model.addAttribute("riskProfileList", riskProfileList.getList());
        
        return "riskProfileMainPage";
    }
    
    @GetMapping("/{id}")
    public String riskProfileById(@PathVariable long id, Model model, final RedirectAttributes redirectAttributes) {
    	log.debug("@GET /RiskProfile/%", id);
        
        RiskProfileView riskProfileList = serviceClient.findRiskProfileById(id);       
        model.addAttribute("riskProfileList", riskProfileList);
        
        return "riskProfileDetail";
    }
   
}
