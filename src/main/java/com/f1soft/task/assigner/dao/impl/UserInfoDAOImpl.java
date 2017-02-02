
package com.f1soft.task.assigner.dao.impl;

import com.f1soft.task.assigner.dao.UserInfoDAO;
import com.f1soft.task.assigner.entity.UserInfo;
import com.f1soft.task.assigner.repository.UserInfoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author sunita.joshi
 */
@Component
@Transactional
public class UserInfoDAOImpl implements UserInfoDAO{
  
    
    @Autowired
    private UserInfoRepository userInfoRepository;
            
    @Override
    public List<UserInfo> findAll() {
        return userInfoRepository.findAll();
    }

}
