package com.application.dao;

import com.application.entity.Likes;

import java.util.List;

public interface LikesDAO {
    public Likes createLike(Likes addLike) throws Exception;
    public List<Likes> retrieveLikes() throws Exception;
    public List<Likes> retrieveLikesByProfileId(int idProfile);
    public void deleteLike(Likes like) throws Exception;
    public List<Likes> retrieveLikeByPostId(String idPost);
    public boolean thisLikeIsExist(Likes like);
}
