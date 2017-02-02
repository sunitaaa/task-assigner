package com.f1soft.task.assigner.controller;

import com.f1soft.task.assigner.entity.UserInfo;
import com.f1soft.task.assigner.exception.GenericException;
import com.f1soft.task.assigner.request.dto.ErrorResponse;
import com.f1soft.task.assigner.request.dto.RegistrationRequestDTO;
import com.f1soft.task.assigner.service.RegistrationService;
import com.f1soft.task.assigner.service.UserInfoService;
import com.f1soft.task.assigner.utility.RegisterUtils;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sunita.joshi
 */
@RestController
@RequestMapping(value = "/user")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    private UserInfo userInfo;
    
   
    @Autowired
    private UserInfoService userInfoService;

//   <------ADDING USER--------->
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Void> addUser(@RequestBody RegistrationRequestDTO registrationRequestDTO) {
    
    
        userInfo = new UserInfo();
        
        
        System.out.println("====================called===================");
        //REGISTRATION REQUEST DTO -> USER INFO ENTITY
        userInfo = RegisterUtils.parseToAdminUser(registrationRequestDTO, 1);
      
        UserInfo findById = userInfoService.findById(1L);
       //userInfo.setAssigntoid(findById);
        

        //USER INFO ENTITY-> SAVE
        //error response handling
        if (registrationService.findUserInfoByName(userInfo.getName()) != null) {
            throw new GenericException(
                    new ErrorResponse(
                            HttpStatus.CONFLICT.value(),
                            HttpStatus.CONFLICT,
                            "Admin with username '" + userInfo.getName() + "' already exists.",
                            "Repetitive admin username (CONFLICT) '" + userInfo.getName() + "'."
                    )
            );
        }

        if (registrationService.findUserInfoByEmail(userInfo.getEmail()) != null) {
            System.out.println("Duplicate Email");
            throw new GenericException(
                    new ErrorResponse(
                            HttpStatus.CONFLICT.value(),
                            HttpStatus.CONFLICT,
                            "Admin with email address '" + userInfo.getEmail() + "' already exists.",
                            "Repetitive admin email address (CONFLICT) '" + userInfo.getEmail() + "'."
                    )
            );
        } //RETURN HTTP STATUS CREATED
        else {
            userInfo = registrationService.setRegisterUsers(userInfo);
            if (userInfo != null) {
                return new ResponseEntity<>(HttpStatus.CREATED);
            } else {
                throw new GenericException(
                        new ErrorResponse(
                                HttpStatus.EXPECTATION_FAILED.value(),
                                HttpStatus.EXPECTATION_FAILED,
                                "User info could not be saved.",
                                "User info could not be saved."
                        )
                );
            }
        }
    }

    // <-------LIST ALL THE USERS-------->
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<List<RegistrationRequestDTO>> getRegisterUsers() {

        List<UserInfo> userInfo = registrationService.getRegisterUsers();
        if (userInfo.isEmpty()) {
            throw new GenericException(
                    new ErrorResponse(
                            HttpStatus.NOT_FOUND.value(),
                            HttpStatus.NOT_FOUND,
                            "Admin users not found.",
                            "Admin users list return empty."
                    )
            );
        } else {
            List<RegistrationRequestDTO> responseList = new ArrayList<>();
            return new ResponseEntity<>(responseList, HttpStatus.OK);
        }
    }

  // <----------UPDATE THE USER------->
    @RequestMapping(value = "user/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateUsers(@RequestBody RegistrationRequestDTO registrationRequestDTO,
            @PathVariable("id") Long id
    ) {
        
        //to check the validity of password
        userInfo = RegisterUtils.parseToAdminUser(registrationRequestDTO, 0);

        if (!registrationService.isRegisterUserExists(id)) {
            throw new GenericException(
                    new ErrorResponse(
                            HttpStatus.NOT_FOUND.value(),
                            HttpStatus.NOT_FOUND,
                            "The user that you are trying to update doesn't exists.",
                            "User with id '" + id + "' doesn't exists for update.")
            );
        } else if (userInfo != null) {
            registrationRequestDTO = RegisterUtils.parseToAdminUserResponse(userInfo);

            //TODO: UPDATE USER and then return status
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            throw new GenericException(
                    new ErrorResponse(
                            HttpStatus.NOT_IMPLEMENTED.value(),
                            HttpStatus.NOT_IMPLEMENTED,
                            "Something went wrong while updating.",
                            "The AdminUser object to be persisted was null."
                    )
            );
        }

    }

  //<-------DELETE USER------->
    @RequestMapping(value = "user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id
    ) {
        //CHECKS EXISTENCE OF AdminUser<Object>
        if (!registrationService.isRegisterUserExists(id)) {

            throw new GenericException(
                    new ErrorResponse(
                            HttpStatus.NOT_FOUND.value(),
                            HttpStatus.NOT_FOUND,
                            "The user that you are trying to delete doesn't exists.",
                            "User with id '" + id + "' doesn't exists to delete.")
            );
        }

        userInfo = registrationService.findRegisterUserById(id);

        userInfo.setUserinfoid(id);

        userInfo = registrationService.setRegisterUsers(userInfo);

        if (userInfo != null) {

            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            // ERROR RESPONSE HANDLING
            throw new GenericException(
                    new ErrorResponse(
                            HttpStatus.NOT_IMPLEMENTED.value(),
                            HttpStatus.NOT_IMPLEMENTED,
                            "Something went wrong while deleting.",
                            "The User object to be deleted was null."
                    )
            );
        }

    }
}
