package com.application.dao.impl;

import com.application.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 * Created by Vladislav on 01.09.2016.
 */

public class HibernateDAO{
    private static final Session session = HibernateUtil.getSessionFactory().openSession();

    protected HibernateDAO() {
    }

    public static Session getSession() {
        return session;
    }

    protected void begin() {
        getSession().beginTransaction();
    }

    protected void commit() {
        getSession().getTransaction().commit();
    }

    protected void rollback() {
        try {
            getSession().getTransaction().rollback();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        try {
            getSession().close();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    public static void close() {
        getSession().close();
    }
}
