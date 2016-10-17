package com.application.service.likeService;

import com.application.entity.Likes;

import java.util.List;

public interface LikeService {
    public Likes createLike(Likes addLike) throws Exception;
    public List<Likes> retrieveLikes() throws Exception;
    public List<Likes> retrieveLikesByProfileId(int idProfile);
    public void deleteLike(Likes like) throws Exception;
    public List<Likes> retrieveLikeById(String idPost);
    public boolean thisLikeIsExist(Likes like);
}
