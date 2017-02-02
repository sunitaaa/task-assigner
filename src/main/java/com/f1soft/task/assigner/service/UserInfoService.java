
package com.f1soft.task.assigner.service;

import com.f1soft.task.assigner.entity.UserInfo;
import java.util.List;

/**
 *
 * @author sunita.joshi
 */
    public interface UserInfoService {
    
    UserInfo findUserInfoByname(String username);
    
    List<UserInfo> findAll();

    UserInfo findUserInfoById(Long id);
 
    UserInfo findUserInfoByEmail(String email);

    UserInfo addUsers(UserInfo user);

    UserInfo setUserInfo(UserInfo userInfo);

    UserInfo addUserInfo(UserInfo userInfo);

     List <UserInfo> findAllUsers();

     boolean isUserExists(UserInfo userInfo);

     int saveUser(UserInfo user);

     UserInfo findById(Long id);

     int updateUser(UserInfo userInfo);

     List <UserInfo> listUsers();

     void deleteUser(Long id);

    List<UserInfo> findUserInfoById();

    List<UserInfo> findCreatedById();

    UserInfo findCreatedId(Long createdById);

   

    

   


}
