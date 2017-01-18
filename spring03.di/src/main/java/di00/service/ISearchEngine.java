package di00.service;

import java.util.List;

import di00.model.*;

public interface ISearchEngine {
    
    public List<Document> findByType(Type documentType);
    public List<Document> listAll();
    
}
