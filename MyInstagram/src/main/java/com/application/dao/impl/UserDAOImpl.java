package com.application.dao.impl;

import com.application.dao.UserDAO;
import com.application.entity.User;
import com.application.service.protect.ProtectedPassword;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Vladislav on 01.09.2016.
 */

@Repository
public class UserDAOImpl extends HibernateDAO implements UserDAO {
    @Autowired
    private ProtectedPassword protectedPassword;

    public User createUser(User addUser) throws Exception {
        try {
            begin();
            getSession().save(addUser);
            commit();
            return addUser;
        } catch (HibernateException e) {
            return null;
        }
    }

    public User retrieveUser(String email, String pass) throws Exception {
        try {
            Query q = getSession().createQuery("from User where email = :email and pass = :pass");
            q.setString("email", email);
            q.setString("pass", protectedPassword.goProtected(pass));
            return (User) q.uniqueResult();
        } catch (HibernateException e) {
            return null;
        }
    }

    public void updateUser(){}

    public void deleteUser(User user) throws Exception {
        try {
            getSession().delete(user);
        } catch (HibernateException e) {
            throw new Exception("Could not delete user " + user.getEmail(), e);
        }
    }
}
