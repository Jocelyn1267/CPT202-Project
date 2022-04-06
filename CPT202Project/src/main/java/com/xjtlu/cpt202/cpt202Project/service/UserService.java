package com.xjtlu.cpt202.cpt202Project.service;

import java.util.List;

import com.xjtlu.cpt202.cpt202Project.entity.User;
import org.springframework.stereotype.Service;


public interface UserService {
//    save new user
    int saveUser(User u);
//    get the information of a certain user
    User getUser(int id);

//    change and get method of [username, password, email, gender, grade, major].
//   have not finished yet

//    username
    String changeUserName(int id, String newName);
    String getUserName(int id);

//    password
    String changeUserPassword(int id, String newPassword);
    String getUserPassword(int id);

//    email
    String changeUserEmail(int id, String newEmail);
    String getUserEmail(int id);

//    gender
    boolean changeUserGender(int id, boolean newGender);
    boolean getUserGender(int id);

//    grade
    int changeUserGrade(int id, int newGrade);
    int getUserGrade(int id);






    List<User> getFanNumber(int id);
    
    
}
