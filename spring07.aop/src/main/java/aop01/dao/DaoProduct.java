package aop01.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import aop01.model.ModelProduct;

@Repository("productDao")
public class DaoProduct implements IDaoProduct {
    
    // SLF4J Logging
    private static Logger logger = LoggerFactory.getLogger(DaoProduct.class);

    @Override
    public ModelProduct getProduct(String name) {

        ModelProduct product = new ModelProduct(name, 1000);
        
        logger.debug("############## getProduct ##################");
        logger.debug( product.toString() );
        logger.debug("############## getProduct ##################");
        
        return product;
    }

    @Override
    public ModelProduct getException(String name) throws Exception {

        ModelProduct product = new ModelProduct(name, 1000);
        
        logger.debug("############## getProduct ##################");
        logger.debug( product.toString() );
        logger.debug("############## getProduct ##################");
        
        throw new Exception("make an error");
    }
    
    
}
