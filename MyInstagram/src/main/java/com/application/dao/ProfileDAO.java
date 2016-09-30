package com.application.dao;

import com.application.entity.Profile;
import com.application.entity.User;

import java.util.List;

public interface ProfileDAO {
    public void createProfile(User user, Profile profile);
    public void updateProfile(Profile profile, int idUser);
    public Profile viewThisProfileFromUserId(int idProfile);
    public List<Profile> viewAllProfiles();
}
