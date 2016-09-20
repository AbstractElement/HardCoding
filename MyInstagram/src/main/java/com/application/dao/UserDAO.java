package com.application.dao;

import com.application.entity.User;

/**
 * Created by Vladislav on 06.09.2016.
 */


public interface UserDAO {
    public User createUser(User addUser) throws Exception;
    public User retrieveUser(String email, String pass) throws Exception;
    public boolean thisUserIsExist(String email);
    public boolean thisTrueUserPassword(String pass, String email);
}
