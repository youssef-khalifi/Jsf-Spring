package com.dao;

import com.entities.Etudiant;
import com.entities.Filiere;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MySession {

    private static SessionFactory sessionFactory;
    static {

        try {
            sessionFactory = new Configuration().
                    configure("hibernate.cfg.xml").
                    addAnnotatedClass(Filiere.class).
                    addAnnotatedClass(Etudiant.class).
                    buildSessionFactory();
        }catch (Exception e){
            System.out.println("Error creation de sessionFactory"+e.getMessage());
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
