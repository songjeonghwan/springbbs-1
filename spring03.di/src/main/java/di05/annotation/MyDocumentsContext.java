package di05.annotation;

import java.util.*;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import di00.model.*;
import di00.service.ISearchEngine;
import di03.dao.*;

@Configuration
public class MyDocumentsContext {
    
    private Map<String, Document> documents = new HashMap<String, Document>();
    private Map<String, Type>     types = new HashMap<String, Type>();

    @Bean
    public Type webType() {
        return getTypeFromMap("web");
    }
    
    @Bean
    public ISearchEngine engine() {
        ArraySearchEngine engine = new ArraySearchEngine();
        engine.setDaoDoc(documentDAO());
        return engine;
    }
    
    public MyDocumentsContext() {
        Type type = new Type();
        type.setName("PDF");
        type.setDesc("Portable Document Format");
        type.setExtension(".pdf");
        
        Document document = new Document();
        document.setName("Book Template");
        document.setType(type);
        document.setLocation("/Users/felipeg/Documents/Random/Book Template.pdf");
        
        documents.put("doc1", document);
        types.put("pdf", type);
        
        document = new Document();
        document.setName("Sample Contract");
        document.setType(type);
        document.setLocation("/Users/felipeg/Documents/Contracts/Sample Contract.pdf");
        
        documents.put("doc2", document);
        
        type = new Type();
        type.setName("NOTE");
        type.setDesc("Text Notes");
        type.setExtension(".txt");
        
        document = new Document();
        document.setName("Clustering with RabbitMQ");
        document.setType(type);
        document.setLocation("/Users/felipeg/Documents/Random/Clustering with RabbitMQ.txt");
        
        documents.put("doc3", document);
        types.put("note", type);
        
        type = new Type();
        type.setName("WEB");
        type.setDesc("Web Link");
        type.setExtension(".url");
        
        document = new Document();
        document.setName("Pro Spring Security Book");
        document.setType(type);
        document.setLocation("http://www.apress.com/9781430248187");
        
        documents.put("doc4", document);
        types.put("web", type);
    }
    
    private IRepositoryDocument documentDAO() {
        ArrayRepository documentDAO = new ArrayRepository();
        
        List<Document> docs= null;
        
        try {
            //docs = (List<Document>)documents.values();
            docs = new ArrayList<Document>(documents.values());
        } catch (Exception e) {
            e.printStackTrace();
        }
         
        documentDAO.setDocs( docs );
        
        return documentDAO;
    }
    
    private Document getDocumentFromMap(String documentKey) {
        return documents.get(documentKey);
    }
    
    private Type getTypeFromMap(String typeKey) {
        return types.get(typeKey);
    }
}
