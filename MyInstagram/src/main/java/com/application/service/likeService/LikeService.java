package com.application.service.likeService;

import com.application.entity.Likes;

import java.util.List;
import java.util.Map;

public interface LikeService {
    public Likes createLike(Likes addLike) throws Exception;
    public List<Likes> retrieveLikes() throws Exception;
    public List<Likes> retrieveLikesByProfileId(int idProfile);
    public void deleteLike(Likes like) throws Exception;
    public List<Likes> retrieveLikeByPostId(String idPost);
    public boolean thisLikeIsExist(Likes like);
    public Map<String, Integer> getCountLikesPerMonth(List<Likes> likes);
    public String[][] convertToArrayString(Map<String, Integer> map);
}
