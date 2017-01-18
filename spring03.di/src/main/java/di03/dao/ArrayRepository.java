package di03.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import di00.model.Document;

public class ArrayRepository implements IRepositoryDocument {
    // SLF4J Logging
    private static Logger logger = LoggerFactory.getLogger(ArrayRepository.class);

    private Document doc1;
    private Document doc2;
    private Document doc3;
    private Document doc4;

    public Document getDoc1() {        
        return doc1;
    }
    public void setDoc1(Document doc1) {
        this.doc1 = doc1;
    }
    public Document getDoc2() {
        return doc2;
    }
    public void setDoc2(Document doc2) {
        this.doc2 = doc2;
    }
    public Document getDoc3() {
        return doc3;
    }
    public void setDoc3(Document doc3) {
        this.doc3 = doc3;
    }
    public Document getDoc4() {
        return doc4;
    }
    public void setDoc4(Document doc4) {
        this.doc4 = doc4;
    }



    private List<Document> docs = null;    
    public List<Document> getDocs() {
        return docs;
    }
    public void setDocs(List<Document> docs) {
        this.docs = docs;
    } 

    public ArrayRepository(Document doc1, Document doc2, Document doc3, Document doc4) {
        super();
        this.doc1 = doc1;
        this.doc2 = doc2;
        this.doc3 = doc3;
        this.doc4 = doc4;
    }



    public ArrayRepository() {
        super();
    }



    @Override
    public String toString() {
        return "RepDocument [doc1=" + doc1 + ", doc2=" + doc2 + ", doc3=" + doc3
                + ", doc4=" + doc4 + "]";
    }

    /*
     */

    @Override
    public Document[] getAll() {
        
        if( logger.isDebugEnabled() ){
            logger.debug("start getAll()");
        }
        
        Document [] result = new Document[4];
        result[0] = doc1;
        result[1] = doc2;
        result[2] = doc3;
        result[3] = doc4;

        return result;
    }

}
