package com.application.dao;

import com.application.entity.Profile;
import com.application.entity.User;

import java.util.List;

/**
 * Created by Vladislav on 06.09.2016.
 */
public interface ProfileDAO {
    public void createProfile(User user, Profile profile);
    public void updateProfile(Profile profile, int idUser);
    public Profile viewThisProfileFromUserId(int idProfile);
    public List viewAllProfiles();
}
