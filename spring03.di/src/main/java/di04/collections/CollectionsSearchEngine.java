package di04.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import di00.model.*;
import di00.service.ISearchEngine;
import di03.dao.IRepositoryDocument;

public class CollectionsSearchEngine implements ISearchEngine {
    
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
