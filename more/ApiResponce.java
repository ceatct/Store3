package com.example.store;

import java.util.List;

public class ApiResponce {

    String status;
    int allResult;
    List<StoreDataProduct> products;
    List<StoreDataCategory> category;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getAllResult() {
        return allResult;
    }

    public void setAllResult(int allResult) {
        this.allResult = allResult;
    }

    public List<StoreDataProduct> getProducts() {
        return products;
    }

    public void setProducts(List<StoreDataProduct> products) {
        this.products = products;
    }

    public List<StoreDataCategory> getCategory() {
        return category;
    }

    public void setCategory(List<StoreDataCategory> category) {
        this.category = category;
    }
}
