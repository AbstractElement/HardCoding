package com.application.dao;

import com.application.entity.Posts;

import java.util.List;

public interface PostsDAO {
    public Posts createPost(Posts addPost) throws Exception;
    public List<Posts> retrievePosts() throws Exception;
    public List<Posts> retrievePostsByProfileId(int idProfile);
    public void updatePost(Posts post);
    public void deletePost(int id) throws Exception;
    public Posts retrievePostById(String idPost);
}
