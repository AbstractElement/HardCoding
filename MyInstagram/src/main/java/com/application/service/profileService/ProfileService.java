package com.application.service.profileService;

import com.application.entity.Profile;
import com.application.entity.User;

import java.util.List;

public interface ProfileService {
    public void createProfile(User user, Profile profile);
    public void updateProfile(Profile profile, int idUser);
    public Profile viewThisProfileFromUserId(int idProfile);
    public List<Profile> viewAllProfiles();
    public Profile retrieveProfile(int idProfile);
}
