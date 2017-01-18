package di05.annotation;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import di00.model.*;
import di03.dao.IRepositoryDocument;

@Repository("daoDocument")
public class RepositoryDocument implements IRepositoryDocument {
    
    // SLF4J Logging
    private  static  Logger  logger = LoggerFactory.getLogger(RepositoryDocument.class);  
    
    private List<Document> docs = null;
    
    public List<Document> getDocs() {
        return docs;
    }

    public void setDocs(List<Document> docs) {
        
        this.docs = docs;
    }    
    
    
    @Override
    public Document[] getAll() {

        if(logger.isDebugEnabled() ) 
            logger.debug("Start <getAll> Params: ");
        
        Document[] result = this.docs.toArray(new Document[this.docs.size()] );

        if(logger.isDebugEnabled() ) 
            logger.debug("End <getAll> Result: " + result);
        
        return result;        
    }
}
