package com.application.service.postsService;

import com.application.entity.Posts;

import java.util.List;

/**
 * Created by Vladislav on 20.09.2016.
 */
public interface PostsService {
    public Posts createPost(Posts addPost) throws Exception;
    public List<Posts> retrievePosts() throws Exception;
    public List retrievePostsByProfileId(int idProfile);
    public void updatePost(Posts post);
    public void deletePost(int id) throws Exception;
    public Posts retrievePostById(String idPost);
}
