package com.f1soft.task.assigner.service.impl;

import com.f1soft.task.assigner.dao.UserInfoDAO;
import com.f1soft.task.assigner.entity.UserInfo;
import com.f1soft.task.assigner.repository.UserInfoRepository;
import com.f1soft.task.assigner.service.UserInfoService;
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
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDAO userInfoDAO;

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public List<UserInfo> findAll() {
      return userInfoRepository.findAll();

//        System.out.println("inside service impl class ++ + + + ");
//        List<UserInfo> persons = new ArrayList<>();
//        for (UserInfo person : userInfoDAO.findAll()) {
//            persons.add(person);
//        }
//        return persons;
    }

    @Override
    public UserInfo findUserInfoByname(String username) {
        return userInfoRepository.findUserInfoByname(username);
    }

    @Override
    public UserInfo findUserInfoById(Long id) {
        return userInfoRepository.findOne(id);

    }

    @Override
    public UserInfo findUserInfoByEmail(String email) {
        System.out.println("Checking email:" + email);
        return userInfoRepository.findUserInfoByEmail(email);

    }

    @Override
    public UserInfo addUsers(UserInfo userInfo) {
        return userInfoRepository.save(userInfo);

    }

    @Override
    public UserInfo setUserInfo(UserInfo userInfo) {
        return userInfoRepository.save(userInfo);

    }

    @Override
    public UserInfo addUserInfo(UserInfo userInfo) {

        return userInfoRepository.save(userInfo);
    }

    @Override
    public List<UserInfo> findAllUsers() {
        return userInfoRepository.findAll();
    }

    @Override
    public boolean isUserExists(UserInfo userInfo) {
        UserInfo checkUser = findById(userInfo.getUserinfoid());
        if (checkUser == null) {
            return false;
        }
        return true;
    }
        
    

    @Override
    public int saveUser(UserInfo user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UserInfo findById(Long id) {
        return userInfoRepository.findOne(id);
    }

    @Override
    public int updateUser(UserInfo userInfo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<UserInfo> listUsers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteUser(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<UserInfo> findUserInfoById() {
        return userInfoRepository.findAll();
    }

    @Override
    public List<UserInfo> findCreatedById() {
        return userInfoRepository.findAll();
    }

    @Override
    public UserInfo findCreatedId(Long createdById) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    



}
