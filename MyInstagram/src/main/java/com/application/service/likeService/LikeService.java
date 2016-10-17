package com.application.service.likeService;

import com.application.entity.Likes;
import com.application.entity.Posts;
import com.application.entity.Profile;

import java.util.List;

/**
* Created by Vladislav on 02.10.2016.
*/
public interface LikeService {
    public Likes createLike(Likes addLike) throws Exception;
    public List<Likes> retrieveLikes() throws Exception;
    public List<Likes> retrieveLikesByProfileId(int idProfile);
    public void deleteLike(int id) throws Exception;
    public List<Likes> retrieveLikeById(String idPost);
}
