package com.application.dao.impl;

import com.application.dao.ProfileDAO;
import com.application.entity.Profile;
import com.application.entity.User;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Repository
@Transactional
public class ProfileDAOImpl implements ProfileDAO {
    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public void createProfile(User user, Profile profile){
        try{
            profile.setCurrentUser(user);
            sessionFactory.getCurrentSession().save(profile);
        }catch (HibernateException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void updateProfile(Profile profile, int idUser){
        try{
            Profile tableProfile = viewThisProfileFromUserId(idUser);
            tableProfile.setCurrentCity(profile.getCurrentCity());
            tableProfile.setFirstName(profile.getFirstName());
            tableProfile.setLastName(profile.getLastName());
            tableProfile.setAge(profile.getAge());
            tableProfile.setSex(profile.getSex());
            tableProfile.setPhoneNumber(profile.getPhoneNumber());
            tableProfile.setAvatar(profile.getAvatar());
            sessionFactory.getCurrentSession().update(tableProfile);
        }catch (HibernateException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public Profile viewThisProfileFromUserId(int idUser){
        try{
            Query query = sessionFactory.getCurrentSession().createQuery("from Profile where currentUser = :idUser");
            query.setInteger("idUser", idUser);
            return (Profile) query.uniqueResult();
        }catch (HibernateException ex){
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Profile> viewAllProfiles() {
        Query query = sessionFactory.getCurrentSession().createQuery("from Profile");
        return query.list();
    }

    @Override
    public Profile retrieveProfile(int idProfile) {
        try{
            Query query = sessionFactory.getCurrentSession().createQuery("from Profile where idProfile = :idProfile");
            query.setInteger("idProfile", idProfile);
            return (Profile) query.uniqueResult();
        }catch (HibernateException ex){
            ex.printStackTrace();
            return null;
        }
    }
}
