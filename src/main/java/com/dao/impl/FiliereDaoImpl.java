package com.dao.impl;

import com.dao.FiliereDao;
import com.dao.MySession;
import com.entities.Filiere;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class FiliereDaoImpl implements FiliereDao {

    private SessionFactory sessionFactory = MySession.getSessionFactory();
    @Override
    public boolean saveOrUpdate(Filiere filiere) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.saveOrUpdate(filiere);
            transaction.commit();
           return true;
        }catch (Exception e){
            System.out.println("Error saveOrUpdate"+e.getMessage());
            transaction.rollback();
            return false;
        }finally {
            session.close();
        }
    }

    @Override
    public boolean delete(Filiere filiere) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(filiere);
            transaction.commit();
            return true;
        }catch (Exception e){
            System.out.println("Error delete Filiere"+e.getMessage());
            transaction.rollback();
            return false;
        }finally {
            session.close();
        }

    }

    @Override
    public Filiere getById(int id) {
        Session session = sessionFactory.openSession();
        Filiere f = session.get(Filiere.class , id);
        System.out.println("Get Filiere By Id ok");
        session.close();
        return f;
    }

    @Override
    public List<Filiere> getAll() {
        Session session = sessionFactory.openSession();
        List<Filiere> filieres = session.createQuery("from Filiere ").list();
        System.out.println("Get All filiers OK");
        session.close();
        return filieres;
    }
}
