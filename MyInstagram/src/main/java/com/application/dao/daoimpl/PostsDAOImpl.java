package com.application.dao.daoimpl;

import com.application.dao.PostsDAO;
import com.application.entity.Posts;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

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
    public Posts retrievePostFromId(int id) {
        Query query = getSession().createQuery("from Posts where idPosts = :id");
        query.setInteger("id", id);
        return (Posts) query.uniqueResult();
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
    public void updatePost() {

    }

    @Override
    public void deletePost(int id) throws Exception {
        try{
            begin();
            getSession().delete(retrievePostFromId(id));
            commit();
        }catch (HibernateException ex){
            rollback();
            ex.printStackTrace();
        }
    }
}
