package it.sander.aml.application.webController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	protected Logger log = LoggerFactory.getLogger(this.getClass());
		
    @Value("${start.title}")
    private String title;	
    @Value("${start.subtitle}")
    private String subtitle;
        
    @Autowired
    private ApplicationContext context;
    
    @RequestMapping("/")
    public String root() {
        return "redirect:/login";
    }
    
    @GetMapping({"/aml"})
    public String mainAml(Authentication authentication, Model model ) {
    	log.info("RequestMapping /aml");
    	
    	Object principal = authentication.getPrincipal();
    	
    	//model.addAttribute("name", authentication.getName());
        //model.addAttribute("emailAddress", authentication.getFirstAttribute("email"));
        //model.addAttribute("userAttributes", authentication.getAttributes());
    	
        return "amlStartPage";
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
	String login() {
		return "login";
	}
 
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("username") final String username, @RequestParam("password") final String password, final HttpServletRequest request) {
        UsernamePasswordAuthenticationToken authReq = new UsernamePasswordAuthenticationToken(username, password);
        
        AuthenticationManager authManager = (AuthenticationManager)context.getBean(AuthenticationManager.class);
        Authentication auth = authManager.authenticate(authReq);
        SecurityContext sc = SecurityContextHolder.getContext();
        sc.setAuthentication(auth);
        HttpSession session = request.getSession(true);
        session.setAttribute("SPRING_SECURITY_CONTEXT", sc);
        return "amlStartPage";
    }

}
