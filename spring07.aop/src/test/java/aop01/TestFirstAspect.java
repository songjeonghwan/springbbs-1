package aop01;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import aop01.model.ModelProduct;
import aop01.service.IServiceProduct;

public class TestFirstAspect {
    // SLF4J Logging
    private static Logger logger = LoggerFactory.getLogger(TestFirstAspect.class);
    
    private static ApplicationContext context = null;
    private static IServiceProduct  productService = null;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        context = new ClassPathXmlApplicationContext("classpath:aop01/aop01.xml");
        productService = context.getBean("serviceProduct", IServiceProduct.class);
    }
    
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        ((ClassPathXmlApplicationContext) context).close();
    }
    
    @Test
    public void testGetProduct() {
        logger.debug("Using Spring AOP:");        
        ModelProduct product = productService.getProduct();        
        logger.info(product.toString());
        logger.debug("It should be now cached!");
    }
    
    @Test
    public void testGetNone() {
        logger.debug("Using Spring AOP:");
        
        productService.getNone();
        
        logger.debug("It should be now cached!");
    }
    
    @Test
    public void testGetException() {
        logger.debug("Using Spring AOP:");
        
        try {
            productService.getException();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("testGetException" + e.getMessage() );
        }

        logger.debug("It should be now cached!");
    }
}
