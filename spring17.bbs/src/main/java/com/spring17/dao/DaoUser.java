package com.spring17.dao;

import java.util.*;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Repository;

import com.spring17.model.ModelUser;

@Repository("daouser")
public class DaoUser implements IDaoUser {

    @Autowired
    @Qualifier("sqlSession")
    private SqlSession session;
    public SqlSession getSession() { return session; }
    public void setSession(SqlSession session) { this.session = session; }
    

    public DaoUser() {
        super();
    }


    @Override
    public ModelUser selectUserOne(ModelUser user) {
        return session.selectOne("mybatis.mapper.mapperUser.selectUserOne", user);
    }

    @Override
    public List<ModelUser> selectUserList(ModelUser user) {
        return session.selectList("mybatis.mapper.mapperUser.selectUserList", user);
    }
    
    @Override
    public int insertUser(ModelUser user) {
        return session.insert("mybatis.mapper.mapperUser.insertUser", user);   
    }

    @Override
    public ModelUser login(String id, String pw ) {

        ModelUser user = new ModelUser(id, null, null, pw);
        return session.selectOne("mybatis.mapper.mapperUser.login", user);
    }

    @Override
    public int logout(String userid) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int updateUserInfo(ModelUser updateValue, ModelUser searchValue) {
        
        Map<String, ModelUser> parameter = new HashMap<String, ModelUser>();
 
        parameter.put("updateValue",             updateValue);
        parameter.put("searchValue",             searchValue);

        return session.update("mybatis.mapper.mapperUser.updateUserInfo", parameter);
    }

    @Override
    public int updatePasswd(String newPasswd, String currentPasswd, String userid) {
        Map<String, String> map = new HashMap<>();
        map.put("newPasswd"    , newPasswd);
        map.put("currentPasswd", currentPasswd);
        map.put("userid"       , userid);
                
        return session.update("mybatis.mapper.mapperUser.updatePasswd", map);
    }

    @Override
    public int deleteUser(ModelUser user) {
        return session.update("mybatis.mapper.mapperUser.deleteUser", user);
    }
	
    @Override
    public int checkuserid(String userid) {
        return session.selectOne("mybatis.mapper.mapperUser.checkuserid", userid);
    }
    
}
