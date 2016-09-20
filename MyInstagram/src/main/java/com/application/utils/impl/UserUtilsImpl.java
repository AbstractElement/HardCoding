package com.application.utils.impl;

import com.application.dao.impl.HibernateDAO;
import com.application.entity.User;
import com.application.service.protect.ProtectedPassword;
import com.application.utils.UserUtils;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Vladislav on 06.09.2016.
 */

@Component
public class UserUtilsImpl extends HibernateDAO implements UserUtils {
    @Autowired
    private ProtectedPassword protectedPassword;

    public boolean thisUserIsExist(String email){
        try{
            Query query = getSession().createQuery("from User where email = :email");
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

    public boolean thisTrueUserPassword(String pass, String email){
        try{
            Query q = getSession().createQuery("from User where email = :email and pass = :pass");
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

    public User searchUserForId(int id){
        try {
            Query q = getSession().createQuery("from User where id = :id");
            q.setInteger("id", id);
            return (User) q.uniqueResult();
        } catch (HibernateException e) {
            rollback();
            return null;
        }
    }
}
