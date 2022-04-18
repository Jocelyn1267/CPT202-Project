package com.xjtlu.cpt202.cpt202Project.service.Impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.xjtlu.cpt202.cpt202Project.entity.Comment;
import com.xjtlu.cpt202.cpt202Project.entity.User;
import com.xjtlu.cpt202.cpt202Project.mapper.UserMapper;

import com.xjtlu.cpt202.cpt202Project.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.jni.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int saveUser(User u) {
        User user = userMapper.addUser(u);
        return user == null ? -1 : 1;
    }


    @Override
    public User getUser(int id) {
        List<Integer> idList = userMapper.getUserIdList();
        if (idList.contains(id)){
            return userMapper.findUserById(id);
        } else {
            return null;
        }

    }

    @Override
    public long getUserId(String username) {
        Object o = userMapper.getUserId(username);
        if(o == null){
            return -1;
        }else {
            return (long) o;
        }
    }

    @Override
    public List<Integer> getThumbUpId(int id) {
        return userMapper.getThumbUpId(id);
    }

    @Override
    public int thumbUp(int user_id, int blog_id) {
        int success = userMapper.addLike(user_id, blog_id);
        User u = userMapper.findUserById(user_id);
        u.setLike_blog(u.getLike_blog()+1);
        return success;
    }

    @Override
    public int notThumbUp(int user_id, int blog_id) {
        int success = userMapper.cancelLike(user_id, blog_id);
        User u = userMapper.findUserById(user_id);
        u.setLike_blog(u.getLike_blog()-1);
        return success;
    }

    @Override
    public List<Integer> getCollectId(int user_id){
        return userMapper.getCollectId(user_id);
    }

    @Override
    public List<Integer> getCreateId(int id) {
        return userMapper.getCreateId(id);
    }


    @Override
    public String changeUserName(int id, String newName) {
        User u = userMapper.findUserById(id);
        u.setUsername(newName);
        userMapper.updateUser(u);
        return u.getUsername();
    }


    @Override
    public String getUserName(int id) {
        return getUser(id).getUsername();
    }


    @Override
    public String changeUserPassword(int id, String newPassword) {
        User u = userMapper.findUserById(id);
        u.setPassword(newPassword);
        userMapper.updateUser(u);
        return u.getPassword();
    }

    @Override
    public String getUserPassword(int id){
        if(getUser(id) == null){
            return "null";
        }
        return getUser(id).getPassword();
    }

    @Override
    public String changeUserEmail(int id, String newEmail) {
        User u = userMapper.findUserById(id);
        u.setEmail(newEmail);
        userMapper.updateUser(u);
        return u.getEmail();
    }

    @Override
    public String getUserEmail(int id) {
        return getUser(id).getEmail();
    }

    @Override
    public String changeUserGender(int id, String newGender) {
        User u = userMapper.findUserById(id);
        u.setGender(newGender);
        userMapper.updateUser(u);
        return u.getGender();
    }

    @Override
    public String getUserGender(int id) {
        return getUser(id).getGender();
    }

    @Override
    public String changeUserGrade(int id, String newGrade) {
        User u = userMapper.findUserById(id);
        u.setGrade(newGrade);
        userMapper.updateUser(u);
        return u.getGrade();
    }

    @Override
    public String getUserGrade(int id) {
        return getUser(id).getGrade();
    }


    @Override
    public int getThumbNum(int blog_id) {
        return userMapper.getThumbNum(blog_id);
    }

}

