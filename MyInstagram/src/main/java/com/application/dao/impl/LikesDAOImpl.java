package com.application.dao.impl;

import com.application.dao.LikesDAO;
import com.application.entity.Likes;
import com.application.entity.Posts;
import com.application.entity.Profile;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Repository
@Transactional
public class LikesDAOImpl implements LikesDAO {

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    public Likes createLike(Likes addLike) throws Exception {
        try {
            sessionFactory.getCurrentSession().save(addLike);
            return addLike;
        } catch (HibernateException e) {
            return null;
        }
    }

    public List<Likes> retrieveLikes() throws Exception {
        Query query = sessionFactory.getCurrentSession().createQuery("from Likes");
        return query.list();
    }

    public List<Likes> retrieveLikesByProfileId(int idProfile){
        Query query = sessionFactory.getCurrentSession().createQuery("from Likes where profile = :idProfile");
        query.setInteger("idProfile", idProfile);
        return query.list();
    }

    public void deleteLike(int id) throws Exception {
        try{
            sessionFactory.getCurrentSession().delete(id);
        }catch (HibernateException ex){
            ex.printStackTrace();
        }
    }

    public List<Likes> retrieveLikeByPostId(String idPost) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Likes where idPosts = :idPost");
        query.setString("idPost", idPost);
        return query.list();
    }
}
