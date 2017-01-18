package com.spring11.controller;

import java.text.SimpleDateFormat;

import java.util.*;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring11.model.*;
import com.spring11.service.*;

@Controller
@RequestMapping(value= "/person")
public class PersonController {

    @Autowired
	private IServicePerson personService;

    public IServicePerson getPersonService() { return personService; } 
    public void setPersonService(IServicePerson personService) { this.personService = personService; }
        
	public PersonController() {
        super();
    } 

    // http://localhost/person?searchWord=&start=&end=&curPage=
    @RequestMapping(value = "/", method = RequestMethod.GET)
	public String listPersons(
	          @RequestParam(defaultValue=""  , required=false) String searchWord
            , @RequestParam(defaultValue="1" , required=false) String start
            , @RequestParam(defaultValue="20", required=false) String end
            , @RequestParam(defaultValue="1" , required=false) String curPage
	        , Model model) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("searchWord", searchWord);
        map.put("start"     , start     );
        map.put("end"       , end       );
        map.put("curPage"   , curPage   );
        
        List<ModelPerson> list = this.personService.getPersonList(map);
        
		model.addAttribute("person", new ModelPerson());
		model.addAttribute("listPersons", list );
		
		return "person/person";
	}
	
	//For add and update person both
    // http://localhost/person/add?searchWord=&start=&end=&curPage=
	@RequestMapping(value= "/add", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("person") ModelPerson p){
		
		if( StringUtils.isEmpty(p.getId()) ){

            String id = new SimpleDateFormat("yyyyMMdd-HHmmss").format( new Date() );
            p.setId(id);
            
			//new person, add it
			this.personService.addPerson(p);
		}else{
			//existing person, call update
			this.personService.updatePerson(p);
		}
		
		return "redirect:/person/";
		
	}

    // http://localhost/person/remove/1?searchWord=&start=&end=&curPage=
	@RequestMapping("/remove/{id}")
    public String removePerson(@PathVariable("id") String id){
		
        this.personService.removePerson(id);
        return "redirect:/person/";
    }
 
	// http://localhost/person/edit/1?searchWord=&start=&end=&curPage=
    @RequestMapping("/edit/{id}")
    public String editPerson(@PathVariable("id") String id
          , @RequestParam(defaultValue=""  , required=false) String searchWord
          , @RequestParam(defaultValue="1" , required=false) String start
          , @RequestParam(defaultValue="20", required=false) String end
          , @RequestParam(defaultValue="1" , required=false) String curPage
          , Model model) {
        
        Map<String, String> map = new HashMap<String, String>();
        map.put("searchWord", searchWord);
        map.put("start"     , start     );
        map.put("end"       , end       );
        map.put("curPage"   , curPage   );
        
        List<ModelPerson> list = this.personService.getPersonList(map);
        ModelPerson person = this.personService.getPersonById(id);
        
        model.addAttribute("person", person );
        model.addAttribute("listPersons", list );
        
        return "person/person";
    }
	
}
