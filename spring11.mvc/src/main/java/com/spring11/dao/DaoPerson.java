package com.spring11.dao;

import java.util.*;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.spring11.model.ModelPerson;

@Repository
public class DaoPerson implements IDaoPerson {
    // SLF4J Logging
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    

    @Autowired
    @Qualifier("sqlSession")
    private SqlSession session;
    public SqlSession getSession() { return session; }
    public void setSession(SqlSession session) { this.session = session; }

    public DaoPerson() {
        super();
    }
       
        

    @Override
    public int getTotalRecord(Map<String, String> map) {
        return session.selectOne("mybatis.mapper.mapperPerson.getTotalRecord", map);
    }

    @Override
    public List<ModelPerson> getPersonList(Map<String, String> map) {
        return session.selectList("mybatis.mapper.mapperPerson.getPersonList", map);
    }

    @Override
    public String getPersonName(String boardcd) {
        return session.selectOne("mybatis.mapper.mapperPerson.getPersonName", boardcd);
    }

    @Override
    public ModelPerson getPersonOne(String boardcd) {
        return session.selectOne("mybatis.mapper.mapperPerson.getPersonOne", boardcd);
    }

    @Override
    public int insertPerson(ModelPerson person) {
        return session.insert("mybatis.mapper.mapperPerson.insertPerson", person );
    }

    @Override
    public int insertMultiPerson(List<ModelPerson> list) {
        return session.insert("mybatis.mapper.mapperPerson.insertMultiPerson", list);
    }

    @Override
    public int updatePerson(ModelPerson person) {
        return session.insert("mybatis.mapper.mapperPerson.updatePerson", person );
    }

    @Override
    public int deletePerson(String boardcd) {
        return session.insert("mybatis.mapper.mapperPerson.deletePerson", boardcd );
    }

    @Override
    public int increaseHit(int articleNo) {
        return session.insert("mybatis.mapper.mapperPerson.increaseHit", articleNo );
    }

    @Override
    public ModelPerson getNextPerson(Map<String, String> map) {
        return session.selectOne("mybatis.mapper.mapperPerson.getNextPerson", map);
    }

    @Override
    public ModelPerson getPrevPerson(Map<String, String> map) {
        return session.selectOne("mybatis.mapper.mapperPerson.getPrevPerson", map);
    }
}
