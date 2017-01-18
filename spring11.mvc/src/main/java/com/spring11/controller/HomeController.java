package com.spring11.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriTemplate;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/")
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
    
    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/spring/helloworld", method = RequestMethod.GET)
    public String helloworld(Model model) {
        logger.info("HomeController.helloworld");
        model.addAttribute("msg", "Hello, World!!!" );        
        return "home/helloworld";
    }
    
    
    // ModelAndView 테스트
    @RequestMapping(value = "/spring/sayHello", method = RequestMethod.GET)
    public ModelAndView sayHello(Model model) {        
        logger.info("HomeController.sayHello");
        
        Map<String, String> map = new HashMap<String, String>();
        map.put("msg", "say Hello");
        
        return new ModelAndView("home/sayHello", map) ;       
    }
        
    // redirect 테스트
    @RequestMapping(value = "/spring/redirect", method = RequestMethod.GET)
    public String redirect(Model model) {     
        logger.info("HomeController.redirect");     
        return "redirect:/spring/helloworld";        
    }
    
    // forward 테스트
    @RequestMapping(value = "/spring/forward", method = RequestMethod.GET)
    public String forward(Model model) {       
        logger.info("HomeController.forward");   
        return "forward:/spring/helloworld";        
    }


    
    // QueryString 테스트 >> @RequestParam 테스트
    @RequestMapping(value = "/spring/querystring", method = RequestMethod.GET)
    public ModelAndView querystring(
            Model model,
            @RequestParam(value="name") String name, 
            HttpServletRequest request ) {           
        logger.info("HomeController.querystring");
                
        String phone = request.getParameter("phone");
        //String name  = request.getParameter("name");
        
        Map<String, String> map = new HashMap<String, String>();
        map.put("name" , name );
        map.put("phone", phone );
        
        return new ModelAndView("home/querystring", map) ;       
    }
    
    // QueryString 테스트 >> @PathVariable 테스트
    /*
    ?  - zero or one charecter
    *  - one charecter
    ** - one or more charecters
    */
    @RequestMapping(value = "/spring/querypath/{name}/**", method = RequestMethod.GET)
    public ModelAndView querypath(
            Model model,
            @PathVariable(value="name") String name,  
            HttpServletRequest request ) {     
        logger.info("HomeController.querypath");
        
        String phone = null;
        
        String restOfUrl = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
     
        UriTemplate template = new UriTemplate("/spring/querypath/{name}/{phone}");        
        boolean isTemplateMatched = template.matches(restOfUrl);
        if(isTemplateMatched) {
            Map<String, String> matchTemplate = new HashMap<String, String>();
            matchTemplate = template.match(restOfUrl);
            phone = matchTemplate.get("phone");
        }
        
        Map<String, String> map = new HashMap<String, String>();
        map.put("name" , name  );
        map.put("phone", phone );
        
        return new ModelAndView("home/querypath", map) ;       
    }
        
    



    
    // GET / POST 테스트
    @RequestMapping(value = "/spring/login", method = RequestMethod.GET)
    public String loginGet(Model model) {             
        logger.info("HomeController.loginGet");
           
        return "home/loginget" ;       
    }
    
    @RequestMapping(value = "/spring/login", method = RequestMethod.POST)
    public ModelAndView loginPost(Model model, HttpServletRequest request ) {     
        logger.info("HomeController.loginPost");
        
        String name  = request.getParameter("name");
        String phone = request.getParameter("phone");
        
        Map<String, String> map = new HashMap<String, String>();
        map.put("name" , name );
        map.put("phone", phone );
        
        return new ModelAndView("home/loginpost", map) ;       
    }
}
