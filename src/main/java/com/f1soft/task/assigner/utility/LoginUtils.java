package com.f1soft.task.assigner.utility;

import com.f1soft.task.assigner.entity.UserInfo;
import com.f1soft.task.assigner.response.dto.LoginResponseDTO;

/**
 *
 * @author sunita.joshi
 */

 public class LoginUtils {
    public static LoginResponseDTO  parseToLogin(UserInfo userInfo){
        LoginResponseDTO loginResponseDTO = new LoginResponseDTO();
        loginResponseDTO.setName(userInfo.getName());
        loginResponseDTO.setUserRole(userInfo.getUserRole());
        loginResponseDTO.setUserinfoid(userInfo.getUserinfoid());
        return loginResponseDTO;
    }
}
