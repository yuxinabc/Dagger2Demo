package com.synertone.dagger2demo.bean;

import javax.inject.Inject;

public class FactoryProduct {
    private Product product;
    @Inject
    public FactoryProduct(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }
}
