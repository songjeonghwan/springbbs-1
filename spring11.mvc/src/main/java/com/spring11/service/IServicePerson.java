package com.spring11.service;

import java.util.*;

import com.spring11.model.*;

public interface IServicePerson {
        
    public List<ModelPerson> getPersonList(Map<String, String> map);
    
    public ModelPerson getPersonById(String id);    

	public void addPerson(ModelPerson p);
	public void addPersons(List<ModelPerson> list);
	public void updatePerson(ModelPerson p);
	public void removePerson(String id);
	
}
