package com.spring17.model;

import java.util.Date;

public class ModelBase {

    private String  InsertUID;
    private Date    InsertDT;
    private String  UpdateUID;
    private Date    UpdateDT;
    

    public String getInsertUID() {
        return InsertUID;
    }

    public void setInsertUID(String insertUID) {
        InsertUID = insertUID;
    }

    public Date getInsertDT() {
        return InsertDT;
    }

    public void setInsertDT(Date insertDT) {
        InsertDT = insertDT;
    }

    public String getUpdateUID() {
        return UpdateUID;
    }

    public void setUpdateUID(String updaterUID) {
        UpdateUID = updaterUID;
    }

    public Date getUpdateDT() {
        return UpdateDT;
    }

    public void setUpdateDT(Date updaterDT) {
        UpdateDT = updaterDT;
    }
    
    public ModelBase () {
        InsertUID   = "";
        InsertDT    = new Date();
        UpdateUID  = "";
        UpdateDT   = new Date();
    }

    @Override
    public String toString() {
        return "ModelBase [InsertUID=" + InsertUID + ", InsertDT=" + InsertDT
                + ", UpdateUID=" + UpdateUID + ", UpdateDT=" + UpdateDT + "]";
    }
}
