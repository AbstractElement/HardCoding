package com.application.utils.impl;

import com.application.dao.impl.HibernateDAO;
import com.application.entity.Profile;
import com.application.utils.ProfileUtils;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Vladislav on 14.09.2016.
 */

@Component
public class ProfileUtilsImpl extends HibernateDAO implements ProfileUtils{

    @Override
    public List<Profile> viewAllProfiles() {
        return getSession().createCriteria(Profile.class).list();
    }
}
