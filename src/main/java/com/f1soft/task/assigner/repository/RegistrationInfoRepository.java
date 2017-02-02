
package com.f1soft.task.assigner.repository;

import com.f1soft.task.assigner.entity.UserInfo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author sunita.joshi
 */
public interface RegistrationInfoRepository extends JpaRepository<UserInfo, Long>{
//    @Query("SELECT a FROM UserInfo a ORDER By ")
    
    
    @Override
    List<UserInfo> findAll();
    
    UserInfo findUserInfoByName(String name);

    UserInfo findUserInfoByEmail(String name);
    
    
}
