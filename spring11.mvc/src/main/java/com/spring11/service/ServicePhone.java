package com.spring11.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.spring11.dao.IDaoPhone;
import com.spring11.model.ModelPhone;

@Service("servicephone")
public class ServicePhone implements IServicePhone {

    // SLF4J Logging
    private Logger logger = LoggerFactory.getLogger(this.getClass());
   
    @Autowired
    @Qualifier("phonedao")
    private IDaoPhone phonedao;
    public IDaoPhone getPhonedao() { return phonedao; } 
    public void setPhonedao(IDaoPhone phonedao) { this.phonedao = phonedao; }
    
    public ServicePhone() {
        super();
    }

    @Override
    public ModelPhone getPhoneOne(String name) {
        
        ModelPhone result = null;
        try {
            result = phonedao.getPhoneOne(name);
        } catch (Exception e) {
            logger.error("getPhoneOne " + e.getMessage() );
        }
        
        return result;
    }
    
    @Override
    public List<ModelPhone> getPhoneList() {
        
        List<ModelPhone> result = null;
        try {
            result = phonedao.getPhoneList();
        } catch (Exception e) {
            logger.error("getPhoneList " + e.getMessage() );
        }
        
        return result;
    }
    
    @Override
    public int insertPhone(ModelPhone phone) {
        
        int result = 0;
        try {
            result = phonedao.insertPhone(phone);
        } catch (Exception e) {
            logger.error("getPhoneList " + e.getMessage() );
        }
        
        return result;
    }
    
    @Override
    public int insertPhoneList(List<ModelPhone> phones) {
        
        int result = 0;
        try {
            result = phonedao.insertPhoneList(phones);
        } catch (Exception e) {
            logger.error("insertPhoneList " + e.getMessage() );
        }
        
        return result;
    }
}
