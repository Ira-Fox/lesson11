package com.example.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.example.dao.BucketDao;
import com.example.dao.impl.BucketDaoImpl;
import com.example.domain.Bucket;
import com.example.service.BucketService;

public class BucketServiceImpl implements BucketService{
    private BucketDao bucketDao;

    public BucketServiceImpl(){
        try {
            bucketDao = new BucketDaoImpl();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Bucket create(Bucket t) {
        return bucketDao.create(t);
    }

    @Override
    public Bucket read(Integer id) {
        return bucketDao.read(id);
    }

    @Override
    public Bucket update(Bucket t) {
        return bucketDao.update(t);
    }

    @Override
    public void delete(Integer id) {
        bucketDao.delete(id);
    }

    @Override
    public List<Bucket> readAll() {
        return bucketDao.readAll();
    }
}
