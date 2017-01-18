package aop01.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import aop01.dao.IDaoProduct;
import aop01.model.ModelProduct;

@Service("serviceProduct")
public class ServiceProduct implements IServiceProduct {
    
    // SLF4J Logging
    private static Logger logger = LoggerFactory.getLogger(ServiceProduct.class);

    @Autowired
    @Qualifier("productDao")
    private IDaoProduct productDao;
    public IDaoProduct getProductDao() { return productDao; } 
    public void setProductDao(IDaoProduct productDao) { this.productDao = productDao; }
    
    public ServiceProduct() {
        super();
    }
    
    @Override
    public ModelProduct getProduct() {
        ModelProduct product = productDao.getProduct("빵");        
        return product;
    }

    @Override
    public void getNone() {
        productDao.getProduct("빵");         
        return ;
    }
    
    @Override
    public ModelProduct getException() {

        try {
            productDao.getException("빵");
        } catch (Throwable e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("getException" + e.getMessage() );
        }
        return null;
    }
}
