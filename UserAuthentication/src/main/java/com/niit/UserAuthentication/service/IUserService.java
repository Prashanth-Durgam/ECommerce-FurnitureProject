package com.niit.UserAuthentication.service;

import com.niit.UserAuthentication.domain.User;
import com.niit.UserAuthentication.exception.PasswordMisMatchException;
import com.niit.UserAuthentication.exception.UserAlreadyExistsException;

public interface IUserService {

    public User saveRegistration(User user) throws  UserAlreadyExistsException;
    public User login(String emailId,String password) throws PasswordMisMatchException;
}
