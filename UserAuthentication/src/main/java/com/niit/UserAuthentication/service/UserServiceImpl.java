package com.niit.UserAuthentication.service;

import com.niit.UserAuthentication.domain.User;
import com.niit.UserAuthentication.exception.PasswordMisMatchException;
import com.niit.UserAuthentication.exception.UserAlreadyExistsException;
import com.niit.UserAuthentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveRegistration(User user) throws UserAlreadyExistsException {
        if (userRepository.findById(user.getEmail()).isPresent()){
            throw new UserAlreadyExistsException();
        }
        return userRepository.save(user);
    }

    @Override
    public User login(String emailId, String password) throws PasswordMisMatchException {
        if (userRepository.findById(emailId).isPresent()){
            User user = userRepository.findById(emailId).get();
            if (user.getPassword().equals(password)){
                user.setPassword("PPP");
                return user;
            } else {
                throw new PasswordMisMatchException();
            }
        }
        return null;
    }
}

//    // get userobjet by using emailId
//    User user=userRepository.findById(email).get();
////check password
//    if(user.getPassword().equals(password)){
//            user.setPassword("");
//            return user;
//            }else{
//            //invalid user
//            return null;
//            }
//
//            }else{
//            //user not exits
//            return null;