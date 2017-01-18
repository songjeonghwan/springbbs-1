package com.spring11.service;

import java.util.List;

import com.spring11.model.ModelPhone;

public interface IServicePhone {
    ModelPhone  getPhoneOne(String name);
    List<ModelPhone>  getPhoneList();
    int insertPhone( ModelPhone phone );
    int insertPhoneList( List<ModelPhone> phones );
}
