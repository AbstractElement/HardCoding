package com.application.service.profileService;

import com.application.entity.Profile;
import com.application.entity.User;

import java.util.List;

/**
 * Created by Vladislav on 20.09.2016.
 */
public interface ProfileService {
    public void createProfile(User user, Profile profile);
    public void updateProfile(Profile profile, int idUser);
    public Profile viewThisProfileFromUserId(int idProfile);
    public List<Profile> viewAllProfiles();
}
