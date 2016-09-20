package com.application.dao.impl;

import com.application.dao.PostsDAO;
import com.application.entity.Posts;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;

/**
 * Created by Vladislav on 09.09.2016.
 */

@Repository
public class PostsDAOImpl extends HibernateDAO implements PostsDAO {

    @Override
    public Posts createPost(Posts addPost) throws Exception {
        try {
            begin();
            getSession().save(addPost);
            commit();
            return addPost;
        } catch (HibernateException e) {
            return null;
        }
    }
    @Override
    public List<Posts> retrievePosts() throws Exception {
        Query query = getSession().createQuery("from Posts order by timeOfPublication desc");
        List<Posts> postsList = query.list();
        return postsList;
    }

    @Override
    public List<Posts> retrievePostsByProfileId(int idProfile){
        Query query = getSession().createQuery("from Posts where profile = :idProfile order by timeOfPublication desc");
        query.setInteger("idProfile", idProfile);
        List<Posts> postsList = query.list();
        return postsList;
    }

    @Override
    public void updatePost(Posts posts) {
        try{
            begin();
            Posts tablePost = retrievePostById(String.valueOf(posts.getIdPosts()));
            tablePost.setMessage(posts.getMessage());
            tablePost.setTimeOfPublication(new Date());
            getSession().update(tablePost);
            commit();
        }
        catch (HibernateException ex){
            rollback();
            ex.printStackTrace();
        }
    }

    @Override
    public void deletePost(int id) throws Exception {
        try{
            begin();
            getSession().delete(retrievePostById(String.valueOf(id)));
            commit();
        }catch (HibernateException ex){
            rollback();
            ex.printStackTrace();
        }
    }

    @Override
    public Posts retrievePostById(String idPost) {
        Query query = getSession().createQuery("from Posts where idPosts = :idPost");
        query.setString("idPost", idPost);
        return (Posts)query.uniqueResult();
    }
}
