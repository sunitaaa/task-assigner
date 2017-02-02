package com.f1soft.task.assigner.validator;

import com.f1soft.task.assigner.entity.UserInfo;
import com.f1soft.task.assigner.utility.Bcrypt;

/**
 *
 * @author sunita.joshi
 */
// <------VALIDATION FOR LOGIN PART----->
public class LoginValidator {

    public static Boolean authenticateUser(UserInfo userInfo) {
        System.out.println("Authentiaction of user");
//        if (userInfo.getStatus().equals(new Character('N'))) {
//            System.out.println("user is not in delete phase.");
//            return false;
//        }
        return true;
    }

    public static Boolean checkPassword(String enteredPassword, String originalPassword) {
        System.out.println("Checking password");
        try {
            System.out.println("enteredPassword" + enteredPassword);
            System.out.println("originalPassword" + originalPassword);
            return Bcrypt.checkpw(enteredPassword, originalPassword);
        } catch (NullPointerException ex) {
            System.out.println("Exception occured!!");
            return false;
        }
    }

}
