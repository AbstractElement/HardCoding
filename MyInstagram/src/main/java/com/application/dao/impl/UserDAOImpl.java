package com.application.dao.impl;

import com.application.dao.UserDAO;
import com.application.entity.User;
import com.application.service.protect.ProtectedPassword;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {
    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    @Autowired
    private ProtectedPassword protectedPassword;

    @Override
    public User createUser(User addUser) throws Exception {
        try {
            sessionFactory.getCurrentSession().save(addUser);
            return addUser;
        } catch (HibernateException e) {
            return null;
        }
    }

    @Override
    public User retrieveUser(String email, String pass) throws Exception {
        try {
            Query q = sessionFactory.getCurrentSession().createQuery("from User where email = :email and pass = :pass");
            q.setString("email", email);
            q.setString("pass", protectedPassword.goProtected(pass));
            return (User) q.uniqueResult();
        } catch (HibernateException e) {
            return null;
        }
    }

    @Override
    public boolean thisUserIsExist(String email){
        try{
            Query query = sessionFactory.getCurrentSession().createQuery("from User where email = :email");
            query.setString("email", email);
            User user = (User) query.uniqueResult();
            if (user != null)
                return true;
            else
                return false;
        }
        catch (HibernateException ex){
            return false;
        }
    }

    @Override
    public boolean thisTrueUserPassword(String pass, String email){
        try{
            Query q = sessionFactory.getCurrentSession().createQuery("from User where email = :email and pass = :pass");
            q.setString("email", email);
            q.setString("pass", protectedPassword.goProtected(pass));
            User user = (User) q.uniqueResult();
            if (user != null)
                return true;
            else
                return false;
        }
        catch (HibernateException ex){
            return false;
        }
    }
}
