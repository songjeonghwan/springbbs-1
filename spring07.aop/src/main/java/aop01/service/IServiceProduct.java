package aop01.service;
import aop01.model.ModelProduct;

public interface IServiceProduct {
    
    ModelProduct getProduct();

    void getNone();

    ModelProduct getException();
}
