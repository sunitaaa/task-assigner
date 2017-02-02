
package com.f1soft.task.assigner.controller;

import com.f1soft.task.assigner.entity.Feature;
import com.f1soft.task.assigner.entity.UserInfo;
import com.f1soft.task.assigner.exception.GenericException;
import com.f1soft.task.assigner.request.dto.ErrorResponse;
import com.f1soft.task.assigner.service.UserInfoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sunita.joshi
 */

@RestController
@RequestMapping(value = "/userinfo")
public class UserInfoController {
    
    @Autowired
    private UserInfoService userInfoService;
    
    @RequestMapping(value = "/getUserId" , method = RequestMethod.GET)
     public ResponseEntity<List<UserInfo>> findUserInfoById() {
         
     
    List<UserInfo> user_info = userInfoService.findUserInfoById();
        if (user_info.isEmpty()) {
            throw new GenericException(
                    new ErrorResponse(
                            HttpStatus.EXPECTATION_FAILED.value(),
                            HttpStatus.EXPECTATION_FAILED,
                            "Sorry! feature not found",
                            "Error while fetching features"
                    )
            );

        } else {
            return new ResponseEntity<>(user_info, HttpStatus.OK);
        }
    }
   
     
     @RequestMapping(value = "getCreatedById",method = RequestMethod.GET)
     
     public ResponseEntity<List<UserInfo>> findCreatedById(){
         
      List<UserInfo> user_info= userInfoService.findCreatedById();
         
     if (user_info.isEmpty()) {
            throw new GenericException(
                    new ErrorResponse(
                            HttpStatus.EXPECTATION_FAILED.value(),
                            HttpStatus.EXPECTATION_FAILED,
                            "Sorry! feature not found",
                            "Error while fetching features"
                    )
            );

        } else {
            return new ResponseEntity<>(user_info, HttpStatus.OK);
        }
    
}
}


