package di05.annotation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import di00.model.*;
import di00.service.ISearchEngine;
import di03.dao.IRepositoryDocument;


@Service("engine")
public class AnnotationSearchEngine implements ISearchEngine {
    
    @Autowired
    private IRepositoryDocument daoDocument;
    public IRepositoryDocument getDaoDocument() {
        return daoDocument;
    }
    public void setDaoDocument(IRepositoryDocument daoDoc) {
        this.daoDocument = daoDoc;
    }
    

    @Override
    public List<Document> findByType(Type documentType) {
        
        List<Document> result = new ArrayList<Document>();
        
        for (Document document : listAll()) {
            if (document.getType().getName().equals(documentType.getName()))
                result.add(document);
        }
        
        return result;
    }

    @Override
    public List<Document> listAll() {
        return Arrays.asList(daoDocument.getAll());
    }
}
