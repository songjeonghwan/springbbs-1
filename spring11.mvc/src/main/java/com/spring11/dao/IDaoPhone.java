package com.spring11.dao;

import java.util.List;

import com.spring11.model.ModelPhone;

public interface IDaoPhone {
    ModelPhone  getPhoneOne(String name);
    List<ModelPhone>  getPhoneList();
    int insertPhone( ModelPhone phone );
    int insertPhoneList( List<ModelPhone> phones );
}
