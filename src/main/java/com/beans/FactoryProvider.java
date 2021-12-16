package com.beans;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryProvider {
    private static SessionFactory factory;

    public FactoryProvider() {
    }

    public static SessionFactory getFactory() {
        try {
            if (factory == null) {
                factory = (new Configuration()).configure("hibernate.cfg.xml").buildSessionFactory();
            }
        } catch (Exception var1) {
            var1.printStackTrace();
        }

        return factory;
    }
}