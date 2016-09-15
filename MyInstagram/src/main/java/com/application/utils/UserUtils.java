package com.application.utils;

import com.application.entity.User;


/**
 * Created by Vladislav on 09.09.2016.
 */
public interface UserUtils {
    public boolean thisUserIsExist(String email);
    public User searchUserForId(int id);
    public boolean thisTrueUserPassword(String pass, String email);
}
