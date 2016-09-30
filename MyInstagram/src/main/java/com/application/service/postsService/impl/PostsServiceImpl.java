package com.application.service.postsService.impl;

import com.application.dao.PostsDAO;
import com.application.entity.Posts;
import com.application.service.postsService.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PostsServiceImpl implements PostsService {
    @Autowired
    private PostsDAO postsDAO;

    @Override
    public Posts createPost(Posts addPost) throws Exception {
        return postsDAO.createPost(addPost);
    }

    @Override
    public List<Posts> retrievePosts() throws Exception {
        return postsDAO.retrievePosts();
    }

    @Override
    public List retrievePostsByProfileId(int idProfile) {
        return postsDAO.retrievePostsByProfileId(idProfile);
    }

    @Override
    public void updatePost(Posts post) {
        postsDAO.updatePost(post);
    }

    @Override
    public void deletePost(int id) throws Exception {
        postsDAO.deletePost(id);
    }

    @Override
    public Posts retrievePostById(String idPost) {
        return postsDAO.retrievePostById(idPost);
    }
}
