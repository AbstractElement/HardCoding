package com.application.service.profileService.impl;

import com.application.dao.ProfileDAO;
import com.application.entity.Profile;
import com.application.entity.User;
import com.application.service.profileService.ProfileService;
import com.application.utils.ProfileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Vladislav on 20.09.2016.
 */

@Component
public class ProfileServiceImpl implements ProfileService{
    @Autowired
    private ProfileDAO profileDAO;

    @Autowired
    private ProfileUtils profileUtils;

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
        return profileUtils.viewAllProfiles();
    }
}
