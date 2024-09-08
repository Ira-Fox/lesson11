package com.example.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.example.dao.ProductDao;
import com.example.dao.impl.ProductDaoImpl;
import com.example.domain.Product;
import com.example.service.ProductService;

public class ProductServiceImpl implements ProductService{
    private ProductDao productDao;

    public ProductServiceImpl(){
        try {
            productDao = new ProductDaoImpl();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Product create(Product t) {
        return productDao.create(t);
    }

    @Override
    public Product read(Integer id) {
        return productDao.read(id);
    }

    @Override
    public Product update(Product t) {
        return productDao.update(t);
    }

    @Override
    public void delete(Integer id) {
        productDao.delete(id);
    }

    @Override
    public List<Product> readAll() {
        return productDao.readAll();
    }

    
}
