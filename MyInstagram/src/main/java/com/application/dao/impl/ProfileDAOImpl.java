package com.application.dao.impl;

import com.application.dao.ProfileDAO;
import com.application.entity.Profile;
import com.application.entity.User;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by Vladislav on 02.09.2016.
 */

@Repository
public class ProfileDAOImpl extends HibernateDAO implements ProfileDAO {
    public void createProfile(User user, Profile profile){
        try{
            begin();
            profile.setCurrentUser(user);
            getSession().save(profile);
            commit();
        }catch (HibernateException ex){
            rollback();
            ex.printStackTrace();
        }
    }
    public void updateProfile(Profile profile, int idUser){
        try{
            begin();
            Profile tableProfile = viewThisProfileFromUserId(idUser);
            tableProfile.setCurrentCity(profile.getCurrentCity());
            tableProfile.setFirstName(profile.getFirstName());
            tableProfile.setLastName(profile.getLastName());
            tableProfile.setAge(profile.getAge());
            tableProfile.setSex(profile.getSex());
            tableProfile.setPhoneNumber(profile.getPhoneNumber());
            tableProfile.setAvatar(profile.getAvatar());
            getSession().update(tableProfile);
            commit();
        }catch (HibernateException ex){
            rollback();
            ex.printStackTrace();
        }
    }

    public void deleteProfile(Profile profile) throws Exception {
        try {
            getSession().delete(profile);
        } catch (HibernateException e) {
            throw new Exception("Could not delete user " + profile.getIdProfile(), e);
        }
    }

    public Profile viewThisProfileFromUserId(int idUser){
        try{
            Query query = getSession().createQuery("from Profile where currentUser = :idUser");
            query.setInteger("idUser", idUser);
            return (Profile) query.uniqueResult();
        }catch (HibernateException ex){
            ex.printStackTrace();
            return null;
        }
    }
}
