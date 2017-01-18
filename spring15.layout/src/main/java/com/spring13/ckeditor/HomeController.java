package com.spring13.ckeditor;

import static org.mockito.Matchers.intThat;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
    
   @RequestMapping(value = "/include", method = RequestMethod.GET)
    public String include(Model model) {
        logger.info("Welcome home! The client locale is {}.");

        return "include/include";
    }
	
   @RequestMapping(value = "/tiles", method = RequestMethod.GET)
    public String ckeditor(Model model) {
        logger.info("Welcome home! The client locale is {}.");
        
        return "tiles/tiles";
    }
   
  @RequestMapping(value = "/sitemesh", method = RequestMethod.GET)
   public String sitemesh(Model model) {
       logger.info("Welcome home! The client locale is {}.");
       
       return "sitemesh/sitemesh";
   }
}