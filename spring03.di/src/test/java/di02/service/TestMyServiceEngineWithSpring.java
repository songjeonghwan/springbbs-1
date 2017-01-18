package di02.service;

import static org.junit.Assert.*;

import org.junit.Test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import di00.model.Document;
import di00.model.Type;

public class TestMyServiceEngineWithSpring {
  
    @SuppressWarnings({ "resource" })
    @Test
    public void testMakeInstanceWithSpring() {
        
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:di02/service/mydocument.xml");
        
        //ISearchEngine engine = context.getBean("engine", ISearchEngine.class); 
        // engine = new di02.service.MySearchEngine();
        
        Type webType = context.getBean("webType", Type.class);
        
        assertEquals( "web", webType.getName() );
        assertEquals( ".url", webType.getExtension() );
        assertEquals( "web link", webType.getDesc() );        
        
        Type txtType = context.getBean("txtType" , Type.class);
        assertEquals( "text", txtType.getName() );
        assertEquals( ".txt", txtType.getExtension() );
        assertEquals( "note", txtType.getDesc() );
        
        // 
        Document doc1 = context.getBean("doc1", Document.class);
        assertEquals("/aaa.txt", doc1.getLocation() );
        assertEquals("aaa", doc1.getName());
        assertEquals(txtType, doc1.getType());        
    }
}
