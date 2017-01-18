package di02.service;

import java.util.ArrayList;
import java.util.List;

import di00.model.Document;
import di00.model.Type;
import di00.service.ISearchEngine;

public class SearchEngineMy implements ISearchEngine {

    @Override
    public List<Document> findByType(Type documentType) {
        List<Document> result = new ArrayList<Document>();
        result = storage();
        
        /*
         for (Document document : result ) {          
            if (document.getType().getName().equals(documentType.getName())) {
                result.add(document);
            }
         }
         */
        for( int i=0; i<result.size(); i=i+1) {
            Document document = result.get(i);
            
            if (document.getType().getName().equals(documentType.getName())) {
                result.add(document);
            }
        }
        
        return result;
    }
    
    @Override
    public List<Document> listAll() {
        return storage();
    }

    private List<Document> storage() {
        List<Document> result = new ArrayList<Document>();

        Type pdfType = new Type();
        pdfType.setName("PDF");
        pdfType.setDesc("Portable Document Format");
        pdfType.setExtension(".pdf");

        Document doc1 = new Document();
        doc1.setName("Book Template");
        doc1.setType(pdfType);
        doc1.setLocation("/Users/Book Template.pdf");
        result.add(doc1);

        Document doc2 = new Document();
        doc2.setName("Sample Contract");
        doc2.setType(pdfType);
        doc2.setLocation("/Users/Sample Contract.pdf");
        result.add(doc2);
        
        

        Type noteType = new Type();
        noteType.setName("NOTE");
        noteType.setDesc("Text Notes");
        noteType.setExtension(".txt");

        Document doc3 = new Document();
        doc3.setName("Clustering with RabbitMQ");
        doc3.setType(noteType);
        doc3.setLocation("/Users/Clustering with RabbitMQ.txt");
        result.add(doc3);

        
        
        Type webType = new Type();
        webType.setName("WEB");
        webType.setDesc("Web Link");
        webType.setExtension(".url");

        Document doc4 = new Document();
        doc4.setName("Pro Spring Security Book");
        doc4.setType(webType);
        doc4.setLocation("http://www.apress.com/9781430248187");
        result.add(doc4);

        return result;
    }
    
}
