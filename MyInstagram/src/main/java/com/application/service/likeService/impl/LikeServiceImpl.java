package com.application.service.likeService.impl;

import com.application.dao.LikesDAO;
import com.application.entity.Likes;
import com.application.service.likeService.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
    public void deleteLike(Likes like) throws Exception {
        likesDAO.deleteLike(like);
    }

    @Override
    public List<Likes> retrieveLikeByPostId(String idPost) {
        return likesDAO.retrieveLikeByPostId(idPost);
    }

    @Override
    public boolean thisLikeIsExist(Likes like) {
        return likesDAO.thisLikeIsExist(like);
    }

    @Override
    public Map<String, Integer> getCountLikesPerMonth(List<Likes> likes) {
        Map<String, Integer> countLikesInMonth = new TreeMap<String, Integer>();
        for (Likes like : likes){
            if(!countLikesInMonth.containsKey("01." + like.getTimeThisLike().substring(3, 10)))
                countLikesInMonth.put("01." + like.getTimeThisLike().substring(3, 10), 1);
            else {
                int count = countLikesInMonth.get("01." + like.getTimeThisLike().substring(3, 10));
                countLikesInMonth.put("01." + like.getTimeThisLike().substring(3, 10), ++count);
            }
        }
        return countLikesInMonth;
    }

    @Override
    public String[][] convertToArrayString(Map<String, Integer> countLikes) {
        String[][] arrayLikesPerMonth = new String[countLikes.size()][2];
        int counter = 0;
        for (Map.Entry<String, Integer> map : countLikes.entrySet()){
            arrayLikesPerMonth[counter][0] = map.getKey();
            arrayLikesPerMonth[counter][1] = map.getValue().toString();
            counter++;
        }
        return arrayLikesPerMonth;
    }
}
