package com.spring11.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.spring11.model.ModelPhone;

@Repository("phonedao")
public class DaoPhone implements IDaoPhone {
    // SLF4J Logging
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    @Qualifier("sqlSession")
    private SqlSession session;
    public SqlSession getSession() { return session; }
    public void setSession(SqlSession session) { this.session = session; }
        
    public DaoPhone() {
        super();
    }
    
    
    @Override
    public ModelPhone getPhoneOne(String name) {
        return session.selectOne("mybatis.mapper.mapperPhone.getPhoneOne", name);
    }
    
    @Override
    public List<ModelPhone> getPhoneList() {
        return session.selectList("mybatis.mapper.mapperPhone.getPhoneList");
    }
    
    @Override
    public int insertPhone(ModelPhone phone) {
        return session.insert("mybatis.mapper.mapperPhone.insertPhone", phone);
    }
    
    @Override
    public int insertPhoneList(List<ModelPhone> phones) {
        return session.insert("mybatis.mapper.mapperPhone.insertPhoneList", phones);
    }
}
