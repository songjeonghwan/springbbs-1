package com.spring11.service;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring11.dao.*;
import com.spring11.model.*;

@Service
public class ServicePerson implements IServicePerson {
    
    // SLF4J Logging
    private static final Logger logger = LoggerFactory.getLogger(ServicePerson.class);

    @Autowired
	private IDaoPerson personDao;
    public IDaoPerson getPersonDao() {
        return personDao;
    }
    public void setPersonDao(IDaoPerson personDao) {
        this.personDao = personDao;
    }

 
    public ServicePerson() {
        super();
    }

    
    
    
    @Override
    @Transactional(readOnly = true)
    public List<ModelPerson> getPersonList(Map<String, String> map) {        
        return this.personDao.getPersonList( map );
    }
 
    @Override
    @Transactional(readOnly = true)
    public ModelPerson getPersonById(String id) {
        return this.personDao.getPersonOne(id);
    }

    @Override
    @Transactional
    public void addPerson(ModelPerson p) {
        this.personDao.insertPerson(p);
    }

    @Override
    @Transactional
    public void addPersons(List<ModelPerson> list) {
        this.personDao.insertMultiPerson(list);
    }
 
    @Override
    @Transactional
    public void updatePerson(ModelPerson p) {
        this.personDao.updatePerson(p);
    }
 
    @Override
    @Transactional
    public void removePerson(String id) {
        this.personDao.deletePerson(id);
    }
}
