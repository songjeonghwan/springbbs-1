package di02.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import di00.model.Document;
import di00.model.Type;
import di00.service.ISearchEngine;

public class TestMyServiceEngineWithNew {
      
    @Test
    public void testMakeTypeInstanceWithNew() {
        // setter를 이용한 초기화
        Type webType = new Type();
        webType.setName("web");
        webType.setExtension(".url");
        webType.setDesc("web link");        

        Type txtType = new Type("abc", ".txt", "note");
        
        Document doc1 = new Document();
        doc1.setLocation("/aaa.txt");
        doc1.setName("aaa");
        doc1.setType(txtType);
        assertEquals("/aaa.txt", doc1.getLocation() );
        assertEquals("aaa", doc1.getName());
        assertEquals(txtType, doc1.getType());
        
    }
    
    @Test
    public void testFindByType() {
        ISearchEngine engine = new di02.service.SearchEngineMy();
        
        Type type = new Type();
        type.setName("WEB");        
        type.setDesc("Web Link" ) ;
        type.setExtension(".url");
        
        List<Document> docs = engine.findByType(type);
        
        if( docs.size() > 0 ) {
            assertTrue(true);
        }
        else {
            assertTrue(false);
        }
    }
	
    @Test
    public void testListAll() {	
        
        ISearchEngine engine = new SearchEngineMy();	
        List<Document> document = engine.listAll();
        assertNotNull(document);
        assertTrue(document.size() == 4);
    }
}
