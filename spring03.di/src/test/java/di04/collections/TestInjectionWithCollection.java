package di04.collections;

import static org.junit.Assert.*;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import di00.model.*;
import di00.service.ISearchEngine;

public class TestInjectionWithCollection {
    
    // SLF4J Logging 
    private static Logger logger = LoggerFactory.getLogger(TestInjectionWithCollection.class);
    
    ApplicationContext context = null;
    ISearchEngine engine = null; 
    Type pdfType = null;
    Type webType = null;
    Document docs = null;

    @Before
    public void setUp() {
        
        try {
            context = new ClassPathXmlApplicationContext("classpath:di04/collections/collections.xml");
            
            engine =  context.getBean("engine", ISearchEngine.class);       
            
            pdfType = context.getBean("pdfType", Type.class);             
            webType = context.getBean("webType", Type.class);         
            docs    = context.getBean("docs"   , Document.class);   
        } catch (BeansException e) {
            e.printStackTrace();
        }        
    }
    
    @Test
    public void testListAllWithSpring() {       
        List<Document> documents = engine.listAll();
        
        assertNotNull(documents);
        assertTrue(documents.size() == 4);
    }
    
    @Test
    public void testFindByTypeWithSpring() {    
        List<Document> documents = engine.findByType(pdfType);
        
        assertNotNull(documents);
        assertTrue(documents.size() == 1);
        assertEquals(pdfType.getName(), documents.get(0).getType().getName());
        assertEquals(pdfType.getDesc(), documents.get(0).getType().getDesc());
        assertEquals(pdfType.getExtension(), documents.get(0).getType().getExtension());
    }
    
    @Test
    public void testDocType() {        
        logger.debug( pdfType.toString() );
    }
    
    @Test
    public void testDocs() {
        logger.debug( docs.toString() );
    }

    
}
