package com.f1soft.task.assigner.controller;

import com.f1soft.task.assigner.entity.UserInfo;
import com.f1soft.task.assigner.exception.GenericException;
import com.f1soft.task.assigner.request.dto.ErrorResponse;
import com.f1soft.task.assigner.request.dto.LoginRequestDTO;
import com.f1soft.task.assigner.response.dto.LoginResponseDTO;
import com.f1soft.task.assigner.service.UserInfoService;
import com.f1soft.task.assigner.utility.LoginUtils;
import com.f1soft.task.assigner.validator.LoginValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author snam joshi
 */
@RestController
public class LoginController {


    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO) {
        System.out.println("Username:::::" + loginRequestDTO.getUser());
        System.out.println("Password:::::" + loginRequestDTO.getPassword());
        UserInfo userInfo = userInfoService.findUserInfoByEmail(loginRequestDTO.getUser());

        if (userInfo != null) {
            if (LoginValidator.checkPassword(loginRequestDTO.getPassword(), userInfo.getPassword())) {            
                System.out.println("LoginSuccesfully");

                LoginResponseDTO responseDTO = LoginUtils.parseToLogin(userInfo);

                return new ResponseEntity<>(responseDTO, HttpStatus.OK);

            } else {
               
                System.out.println("Admin already login in");
                throw new GenericException(
                        new ErrorResponse(
                                HttpStatus.LOCKED.value(),
                                HttpStatus.LOCKED,
                                "AdminUser is already logged in.", "AdminUser with same credential is already logged in somewhere else."
                        )
                );
            }
        } else {

           
            System.out.println("invalid password");

            throw new GenericException(
                    new ErrorResponse(
                            HttpStatus.FORBIDDEN.value(),
                            HttpStatus.FORBIDDEN,
                            "Invalid password.",
                            "Invalid password for username '" + loginRequestDTO.getUser() + "'."
                    )
            );
        }

    }
    
}

//System.out.println("userInfo:::" + userInfo.getName());
//        if (userInfo != null) {
//            if (LoginValidator.authenticateUser(userInfo)) {
//                if (userInfo.getActive().equals('Y')) {
//                    if (LoginValidator.checkPassword(loginRequestDTO.getPassword(), userInfo.getPassword())) {
//                   if (userInfo.getStatus().equals('Y')) {
//                            logger.debug("LOGIN SUCCESS");
//                            userInfo.setLastLoginTime(new Date());
//                            userInfo = userInfoService.addUserInfo(userInfo);
//                            return new ResponseEntity<>(HttpStatus.OK);
//
//                        } else {
//                            logger.debug("AdminUser IS ALREADY LOGGED IN.");
//                            throw new GenericException(
//                                    new ErrorResponse(
//                                            HttpStatus.LOCKED.value(),
//                                            HttpStatus.LOCKED,
//                                            "AdminUser is already logged in.",
//                                            "AdminUser with same credential is already logged in somewhere else."
//                                    )
//                            );
//                        }
//                    } else {
//                        logger.debug("INVALID PASSWORD.");
//
//                        throw new GenericException(
//                                new ErrorResponse(
//                                        HttpStatus.FORBIDDEN.value(),
//                                        HttpStatus.FORBIDDEN,
//                                        "Invalid password.",
//                                        "Invalid password for username '" + loginRequestDTO.getUser() + "'."
//                                )
//                        );
//                    }
//                } else {
//                    logger.debug("AdminUser NOT IN ACTIVE STATE.");
//                    throw new GenericException(
//                            new ErrorResponse(
//                                    HttpStatus.UNAUTHORIZED.value(),
//                                    HttpStatus.UNAUTHORIZED,
//                                    "Credentials not authorized to use the system.",
//                                    "AdminUser active state is set to 'N'."
//                            )
//                    );
//                }
//            } else {
//                logger.debug("AdminUser IS IN DELETED STATE.");
//                throw new GenericException(
//                        new ErrorResponse(
//                                HttpStatus.UNAUTHORIZED.value(),
//                                HttpStatus.UNAUTHORIZED,
//                                "Credentials not authorized to use the system.",
//                                "AdminUser deleted state is set to 'D' (i.e deleted from system)."
//                        )
//                );
//            }
//        } 
//        else {
//            throw new GenericException(
//                    new ErrorResponse(
//                            HttpStatus.FORBIDDEN.value(),
//                            HttpStatus.FORBIDDEN,
//                            "Username '" + loginRequestDTO.getUser() + "' doesn't exists.",
//                            "Username '" + loginRequestDTO.getUser() + "' doesn't exists in database."
//                    )
//            );
//        }
//    }
//
//    public static void main(String[] args) {
//        LoginRequestDTO dto = new LoginRequestDTO();
//        dto.setUser("User");
//        dto.setPassword("pass");
//
//        System.out.println("DATA :: " + dto.getUser());
//    }
//}
//    @GetMapping("/user_info")
//    public String findAll(){
//        return userInfoService.findAll().toString();
//    }
//    
//    



