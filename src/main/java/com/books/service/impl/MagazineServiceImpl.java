package com.books.service.impl;

import com.books.dao.MagazineDao;
import com.books.entity.Magazine;
import com.books.service.MagazineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MagazineServiceImpl implements MagazineService {

    @Autowired
    private MagazineDao magazineDao;

    @Override
    public void save(Magazine magazine) {
        magazineDao.save(magazine);
    }

    @Override
    public List<Magazine> findAll() {
        return magazineDao.findAll();
    }

    @Override
    public Magazine findOne(int id) {
        return magazineDao.findOne(id);
    }

    @Override
    public void delete(int id) {
        magazineDao.delete(id);
    }

    @Override
    public void update(String info) {

        Magazine magazine = magazineDao.findOne(Integer.parseInt(info.split("_")[1]));

        magazine.setTitleOfMagazine(info.split("_")[0]);

        magazineDao.save(magazine);

    }
}
