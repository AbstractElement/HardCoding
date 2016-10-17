package com.application.dao;

import com.application.entity.Likes;

import java.util.List;

/**
* Created by Vladislav on 02.10.2016.
*/
public interface LikesDAO {
    public Likes createLike(Likes addLike) throws Exception;
    public List<Likes> retrieveLikes() throws Exception;
    public List<Likes> retrieveLikesByProfileId(int idProfile);
    public void deleteLike(int id) throws Exception;
    public List<Likes> retrieveLikeByPostId(String idPost);
}
