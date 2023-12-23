package com.dao.impl;

import com.dao.FiliereDao;
import com.entities.Filiere;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FiliereDaoImplTest {

    private FiliereDao filiereDao;

    @BeforeEach
    void setUp() {
        this.filiereDao = new FiliereDaoImpl();
    }

    @Test
    void saveOrUpdate() {
        Filiere f = new Filiere();

        f.setCode("SMI");
        f.setLibelle("Science Math");

        assertTrue(filiereDao.saveOrUpdate(f));
    }

    @Test
    void delete() {
        Filiere f = new Filiere();
        f.setCode("Test");
        f.setLibelle("Test");

        filiereDao.saveOrUpdate(f);

        assertTrue(filiereDao.delete(f));
    }

    @Test
    void getById() {
        Filiere f = new Filiere();
        f.setCode("Code2");
        f.setLibelle("Code2");
        filiereDao.saveOrUpdate(f);
        Filiere f2 = filiereDao.getById(f.getId());

        assertEquals(f2.getId() , f.getId());
    }

    @Test
    void getAll() {
        List<Filiere> filiereList = filiereDao.getAll();

        assertNotNull(filiereList);
    }
}