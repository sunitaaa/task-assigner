

package com.f1soft.task.assigner.service.impl;

import com.f1soft.task.assigner.entity.UserInfo;
import com.f1soft.task.assigner.repository.RegistrationInfoRepository;
import com.f1soft.task.assigner.repository.UserInfoRepository;
import com.f1soft.task.assigner.service.RegistrationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author sunita.joshi
 */
@Service
@Transactional
public class RegistrationServiceImpl implements RegistrationService{

    
    @Autowired
    private RegistrationInfoRepository registrationInfoRepository;
    
    
    @Autowired
    private UserInfoRepository userInfoRepository;
    @Override
    
    public UserInfo findUserInfoByEmail(String name) {
        System.out.println("Checking email:" + name);
        return registrationInfoRepository.findUserInfoByEmail(name);
    }

    @Override
    public List<UserInfo> getRegisterUsers() {
        return registrationInfoRepository.findAll();
    }

    @Override
    public boolean isRegisterUserExists(Long id) {
        UserInfo userInfo = findRegisterUserById(id);
        System.out.println(" User exists? " + userInfo != null);
        return userInfo != null;
    }
    

    @Override
    public UserInfo findRegisterUserById(Long id) {
        
        return registrationInfoRepository.findOne(id);

    }

    @Override
    public UserInfo setRegisterUsers(UserInfo userInfo) {
        return registrationInfoRepository.save(userInfo);
    }

    @Override
    public UserInfo findUserInfoByName(String name) {
        
    return registrationInfoRepository.findUserInfoByName(name);
        
    }

    
    // new coding
    @Override
    public UserInfo finById(Long id) {
        return userInfoRepository.findOne(id);
    }

    
    
    
 

}

