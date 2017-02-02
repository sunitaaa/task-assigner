package com.f1soft.task.assigner.utility;

import com.f1soft.task.assigner.entity.UserInfo;
import com.f1soft.task.assigner.request.dto.RegistrationRequestDTO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author snam joshi
 */


// is created for setting the value of table and matching with the requestdto value and good if created best practices to create utility class in java
public class RegisterUtils {

    public static UserInfo parseToAdminUser(RegistrationRequestDTO registrationRequestDTO, int check) {
        UserInfo userInfo = new UserInfo();
        userInfo.setName(registrationRequestDTO.getFirstName() + " " + registrationRequestDTO.getLastName());
        userInfo.setEmail(registrationRequestDTO.getEmailAddress());
        if (check == 1) {
            // 1 is for create
            userInfo.setPassword(Bcrypt.hashpw(registrationRequestDTO.getPassword(), Bcrypt.gensalt()));
        } else {
            // 0 is for update
            userInfo.setPassword(registrationRequestDTO.getPassword());
        }

        userInfo.setActive('Y');
        userInfo.setUserRole(registrationRequestDTO.getRole());
        userInfo.setMobileno(registrationRequestDTO.getMobileNumber());
        userInfo.setAddeddate(new Date());
        return userInfo;
    }

    public static RegistrationRequestDTO parseToAdminUserResponse(UserInfo userInfo) {
        RegistrationRequestDTO registrationRequestDTO = new RegistrationRequestDTO();    
        return registrationRequestDTO;
    }

    public static List<RegistrationRequestDTO> parseAdminUserList(List<UserInfo> adminUserList) {
        List<RegistrationRequestDTO> adminSetupResponseDTOList = new ArrayList<>();
        for (UserInfo adminUser : adminUserList) {

            RegistrationRequestDTO adminSetupResponseDTO = parseToAdminUserResponse(adminUser);
            adminSetupResponseDTOList.add(adminSetupResponseDTO);
        }
        return adminSetupResponseDTOList;
    }
}
