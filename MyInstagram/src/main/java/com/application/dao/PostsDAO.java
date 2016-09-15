package com.application.dao;

import com.application.entity.Posts;

import java.util.List;

/**
 * Created by Vladislav on 09.09.2016.
 */
public interface PostsDAO {
    public Posts createPost(Posts addPost) throws Exception;
    public Posts retrievePostFromId(int id);
    public List<Posts> retrievePosts() throws Exception;
    public List<Posts> retrievePostsByProfileId(int idProfile);
    public void updatePost();
    public void deletePost(int id) throws Exception;
}
