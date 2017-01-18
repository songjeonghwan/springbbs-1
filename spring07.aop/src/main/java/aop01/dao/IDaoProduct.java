package aop01.dao;

import aop01.model.ModelProduct;

public interface IDaoProduct {
    
    ModelProduct getProduct(String name);

    ModelProduct getException(String name) throws Exception;

}
