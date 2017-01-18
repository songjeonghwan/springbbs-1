package di03.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import di00.model.Document;
import di00.model.Type;
import di00.service.ISearchEngine;

public class ArraySearchEngine implements ISearchEngine {

    private IRepositoryDocument daoDoc = null;
    public IRepositoryDocument getDaoDoc() {
        return daoDoc;
    }
    public void setDaoDoc(IRepositoryDocument daoDoc) {
        this.daoDoc = daoDoc;
    }
    
    /* 
     * 생성자
     * */
    public ArraySearchEngine() {
        super();
    }
    public ArraySearchEngine(IRepositoryDocument daoDoc) {
        super();
        this.daoDoc = daoDoc;
    }


    /*  
     * toString()
     * */
    @Override
    public String toString() {
        return "SearchEngineService [daoDoc=" + daoDoc + "]";
    }

    /*  
     * ---------------추가된 메서드 --------------------   
     * */
    @Override
    public List<Document> findByType(Type documentType) {

        List<Document> result = new ArrayList<Document>();
        
        List<Document> list = listAll();
        
        for(int i=0; i<list.size(); i=i+1 ){
            Document doc = list.get(i);
            
            if( doc.getType().getName().equals( documentType.getName() ) ){
                result.add( doc );
            }
        }
        
        return result;
    }

    @Override
    public List<Document> listAll() {
        
        Document[] arr = daoDoc.getAll();

        return Arrays.asList(arr);
    }
}
