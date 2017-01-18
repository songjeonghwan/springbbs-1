package com.spring11.repository;

import java.util.List;

import com.spring11.model.ModelPhone;

public class RepositoryPhone {

    private List<ModelPhone> phoneItems;
    
    public List<ModelPhone> getPhoneItems() {
        return phoneItems;
    }

    public void setPhoneItems(List<ModelPhone> phoneItems) {
        this.phoneItems = phoneItems;
    }

    public RepositoryPhone() {
        super();
    }    
}
