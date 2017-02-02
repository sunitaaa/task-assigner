
package com.f1soft.task.assigner.service;

import com.f1soft.task.assigner.entity.UserInfo;
import java.util.List;

/**
 *
 * @author sunita.joshi
 */
public interface RegistrationService {
    
    UserInfo findUserInfoByName(String name);
    
    /*
    * This function is used for listing all the users from the database.
    */

    List<UserInfo> getRegisterUsers();
    /*
    * This function is used to check whether the user with the given id exists or not.
    */

    boolean isRegisterUserExists(Long id);
    /*
     *   This function is used for finding an admin user by the help of the id
     *   
     */

    UserInfo findRegisterUserById(Long id);
    
    /*
    * This function is used for updating user into the database.
    */

    UserInfo setRegisterUsers(UserInfo userInfo);

    public UserInfo findUserInfoByEmail(String email);
    
    
    
    // new code
    UserInfo finById(Long id);
    
    
}
   