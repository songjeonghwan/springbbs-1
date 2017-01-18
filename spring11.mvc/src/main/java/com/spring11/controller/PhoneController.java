package com.spring11.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.spring11.model.ModelPhone;
import com.spring11.repository.RepositoryPhone;


import org.springframework.ui.Model;


/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/phone")
public class PhoneController {
	
	private static final Logger logger = LoggerFactory.getLogger(PhoneController.class);

    @RequestMapping(value = "writeone", method = RequestMethod.GET)
    public String writeOneFormGet(Model model) {
        
        return "phone/writeOneForm";
    }
    

    @RequestMapping(value = "writeone1", method = RequestMethod.POST)
    public String writeOneFormPost1(Model model,  HttpServletRequest request) {
        
        String name         = request.getParameter("name");
        String manufacturer = request.getParameter("manufacturer");
        String price        = request.getParameter("price");

        int iprice =  StringUtils.isEmpty(price) ?  0 : Integer.parseInt(price) ;
        
        ModelPhone phone = new ModelPhone( name, manufacturer, iprice );

        model.addAttribute("phone", phone);
        
        return "phone/writeOneResult";
    }
    

    @RequestMapping(value = "writeone2", method = RequestMethod.POST)
    public ModelAndView writeOneFormPost2(Model model
            , @RequestParam String name
            , @RequestParam String manufacturer
            , @RequestParam String price) {
                
        int iprice =  StringUtils.isEmpty(price) ?  0 : Integer.parseInt(price) ;
        
        ModelPhone phone = new ModelPhone( name, manufacturer, iprice );
        
        Map<String, ModelPhone> map = new HashMap<>();
        map.put("phone", phone);
        
        return new ModelAndView("phone/writeOneResult", map);
    }

    

    @RequestMapping(value = "writeone3", method = RequestMethod.POST)
    public ModelAndView writeOneFormPost3(
            @ModelAttribute ModelPhone phone, 
            Model model) {
        
        Map<String, ModelPhone> map = new HashMap<>();
        map.put("phone", phone);
        
        return new ModelAndView("phone/writeOneResult", map);
    }

    @RequestMapping(value = "writeone4", method = RequestMethod.POST)
    public String writeOneFormPost4(ModelPhone phone, Model model) {
        
        model.addAttribute("phone", phone);
        
        return "phone/writeOneResult";
    }
    

    @RequestMapping(value = "writelist", method = RequestMethod.GET)
    public String writeListGet(Model model) {        
        return "phone/writeListForm";
    }

    @RequestMapping(value = "writelist", method = RequestMethod.POST)
    public String writeListPost(@ModelAttribute RepositoryPhone phone, Model model) {        
        List<ModelPhone> phonelist = phone.getPhoneItems();
        model.addAttribute("list", phonelist);        
        return "phone/writeListResult";
    }
 
}
