package com.application.dao;

import com.application.entity.Posts;
import org.hibernate.Criteria;

import java.util.List;

/**
 * Created by Vladislav on 09.09.2016.
 */
public interface PostsDAO {
    public Posts createPost(Posts addPost) throws Exception;
    public List<Posts> retrievePosts() throws Exception;
    public List<Posts> retrievePostsByProfileId(int idProfile);
    public void updatePost(Posts post);
    public void deletePost(int id) throws Exception;
    public Posts retrievePostById(String idPost);
}
