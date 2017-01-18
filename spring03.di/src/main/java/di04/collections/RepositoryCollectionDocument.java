package di04.collections;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import di00.model.Document;
import di00.model.Type;
import di03.dao.IRepositoryDocument;

public class RepositoryCollectionDocument implements IRepositoryDocument {
    
    // SLF4J Logging
    private  static  Logger  logger = LoggerFactory.getLogger(RepositoryCollectionDocument.class);  
    
    private List<Document> docs = null;
    
    public List<Document> getDocs() {
        return docs;
    }

    public void setDocs(List<Document> docs) {
        this.docs = docs;
    }    


    public RepositoryCollectionDocument() {
        super();
    }

    public RepositoryCollectionDocument(List<Document> docs) {
        super();
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

    private Document[] storage() {
        List<Document> result = new ArrayList<Document>();

        Type type = new Type();
        type.setName("PDF");
        type.setDesc("Portable Document Format");
        type.setExtension(".pdf");

        Document document = new Document();
        document.setName("Book Template");
        document.setType(type);
        document.setLocation("/Users/felipeg/Documents/Random/Book Template.pdf");

        result.add(document);

        document = new Document();
        document.setName("Sample Contract");
        document.setType(type);
        document.setLocation(
            "/Users/felipeg/Documents/Contracts/Sample Contract.pdf");

        result.add(document);

        type = new Type();
        type.setName("NOTE");
        type.setDesc("Text Notes");
        type.setExtension(".txt");

        document = new Document();
        document.setName("Clustering with RabbitMQ");
        document.setType(type);
        document.setLocation(
            "/Users/felipeg/Documents/Random/Clustering with RabbitMQ.txt");

        result.add(document);

        type = new Type();
        type.setName("WEB");
        type.setDesc("Web Link");
        type.setExtension(".url");

        document = new Document();
        document.setName("Pro Spring Security Book");
        document.setType(type);
        document.setLocation("http://www.apress.com/9781430248187");

        result.add(document);

        return result.toArray(new Document[result.size()]);
    }

}
