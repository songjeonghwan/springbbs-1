package di03.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import di00.model.Document;
import di00.model.Type;
import di00.service.ISearchEngine;
import di03.dao.IRepositoryDocument;
import di03.dao.ArrayRepository;
import di03.dao.ArraySearchEngine;

public class TestRepDocumentWithNew {
    
    @Test
    public void test() {
        IRepositoryDocument dao = new ArrayRepository();
        Document[] result = dao.getAll();        
        assertEquals(result.length, 4);
    }

    
    @Test
    public void testService() {        
        //Document doc1 = new Document("aaa", new Type("a", "a", "a"), "aaa");
        //Document 세터 설정 + Type 세터 설정
        Type atype = new Type();
        atype.setDesc("a");
        atype.setExtension("a");
        atype.setName("a");
        
        Document doc1 = new Document();
        doc1.setLocation("aaa");
        doc1.setName("aaa");
        doc1.setType(atype);
        

        //Document doc2 = new Document("bbb", new Type("b", "b", "b"), "bbb");
        //Document 세터 설정 + Type 생성자 설정
        Document doc2 = new Document();
        doc2.setLocation("");
        doc2.setName("");
        doc2.setType( new Type("b", "b", "b") );
                        
        //Document doc3 = new Document("ccc", new Type("c", "c", "c"), "ccc");
        //Document 생성자 설정 + Type 세터 설정
        Type ctype = new Type();
        ctype.setDesc("c");
        ctype.setExtension("c");
        ctype.setName("c");
        Document doc3 = new Document("ccc", ctype, "ccc");
        
        //Document 생성자 설정 + Type 생성자 설정
        Document doc4 = new Document("ddd", new Type("d", "d", "d"), "ddd");
        
        IRepositoryDocument dao = new ArrayRepository(doc1, doc2, doc3, doc4);
        
        Type type = new Type();
        type.setDesc("c");
        type.setExtension("c");
        type.setName("c");        
        
        ISearchEngine engine = new ArraySearchEngine(dao);
        List<Document> list = engine.findByType(type);
        
        if( list.size() >= 1) {
            assertTrue(true);
        }
        else {
            assertTrue(false);            
        }
    }
}
