package com.application.dao.impl;

import com.application.dao.PostsDAO;
import com.application.entity.Posts;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.List;

@Repository
@Transactional
public class PostsDAOImpl implements PostsDAO {

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public Posts createPost(Posts addPost) throws Exception {
        try {
            sessionFactory.getCurrentSession().save(addPost);
            return addPost;
        } catch (HibernateException e) {
            return null;
        }
    }

    @Override
    public List<Posts> retrievePosts() throws Exception {
        Query query = sessionFactory.getCurrentSession().createQuery
                ("from com.application.entity.Posts order by timeOfPublication desc");
        return query.list();
    }

    @Override
    public List<Posts> retrievePostsByProfileId(int idProfile){
        Query query = sessionFactory.getCurrentSession().createQuery
                ("from com.application.entity.Posts where profile = :idProfile order by timeOfPublication desc");
        query.setInteger("idProfile", idProfile);
        return query.list();
    }

    @Override
    public void updatePost(Posts posts) {
        try{
            Posts tablePost = retrievePostById(String.valueOf(posts.getIdPosts()));
            tablePost.setMessage(posts.getMessage());
            sessionFactory.getCurrentSession().update(tablePost);
        }
        catch (HibernateException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void deletePost(int id) throws Exception {
        try{
            Posts post = retrievePostById(String.valueOf(id));
            Posts mergedPost = (Posts) sessionFactory.getCurrentSession().merge(post);
            sessionFactory.getCurrentSession().delete(mergedPost);
        }catch (HibernateException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public Posts retrievePostById(String idPost) {
        Query query = sessionFactory.getCurrentSession().createQuery
                ("from com.application.entity.Posts where idPosts = :idPost");
        query.setString("idPost", idPost);
        return (Posts)query.uniqueResult();
    }
}
