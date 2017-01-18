package di03.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import di00.model.Document;
import di00.model.Type;
import di00.service.ISearchEngine;
import di04.collections.RepositoryCollectionType;

public class TestRepDocumentWithSpring {
    // SLF4J Logging
    private static Logger logger = LoggerFactory
            .getLogger(TestRepDocumentWithSpring.class);
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }
    
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
    
    
    @SuppressWarnings("resource")
    @Test
    public void test() {
        
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:di03/dao/repo.xml");

        // Type type = new Type();
        // type.setDesc("c");
        // type.setExtension("c");
        // type.setName("c");   
        Type type = context.getBean("ctype", Type.class);
        
        //IDaoRepository dao = new RepDocument(doc1, doc2, doc3, doc4);
        IDaoTypeRepository dao = context.getBean("dao", IDaoTypeRepository.class);
        
        //ISearchEngine engine = new SearchEngineService(dao);
        ISearchEngine engine = context.getBean("engine", ISearchEngine.class );
        
        
        List<Document> list = engine.findByType(type);
        
        if( list.size() >= 1) {
            assertTrue(true);
        }
        else {
            assertTrue(false);            
        }
    }
}
