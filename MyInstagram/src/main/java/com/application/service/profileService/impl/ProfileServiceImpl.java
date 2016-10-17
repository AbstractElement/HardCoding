package com.application.service.profileService.impl;

import com.application.dao.ProfileDAO;
import com.application.entity.Profile;
import com.application.entity.User;
import com.application.service.profileService.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProfileServiceImpl implements ProfileService{
    @Autowired
    private ProfileDAO profileDAO;

    @Override
    public void createProfile(User user, Profile profile) {
        profileDAO.createProfile(user, profile);
    }

    @Override
    public void updateProfile(Profile profile, int idUser) {
        profileDAO.updateProfile(profile, idUser);
    }

    @Override
    public Profile viewThisProfileFromUserId(int idProfile) {
        return profileDAO.viewThisProfileFromUserId(idProfile);
    }

    @Override
    public List<Profile> viewAllProfiles() {
        return profileDAO.viewAllProfiles();
    }

    @Override
    public Profile retrieveProfile(int idProfile) {
        return profileDAO.retrieveProfile(idProfile);
    }
}
