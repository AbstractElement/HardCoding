package com.application.service.likeService.impl;

import com.application.dao.LikesDAO;
import com.application.entity.Likes;
import com.application.entity.Posts;
import com.application.entity.Profile;
import com.application.service.likeService.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
* Created by Vladislav on 02.10.2016.
*/

@Component
public class LikeServiceImpl implements LikeService {
    @Autowired
    private LikesDAO likesDAO;

    @Override
    public Likes createLike(Likes addLike) throws Exception {
        return likesDAO.createLike(addLike);
    }

    @Override
    public List<Likes> retrieveLikes() throws Exception {
        return likesDAO.retrieveLikes();
    }

    @Override
    public List<Likes> retrieveLikesByProfileId(int idProfile) {
        return likesDAO.retrieveLikesByProfileId(idProfile);
    }

    @Override
    public void deleteLike(int id) throws Exception {

    }

    @Override
    public List<Likes> retrieveLikeById(String idPost) {
        return likesDAO.retrieveLikeByPostId(idPost);
    }

}
