

package com.f1soft.task.assigner.repository;

import com.f1soft.task.assigner.entity.UserInfo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author sunita.joshi
 */
public interface UserInfoRepository extends JpaRepository<UserInfo, Long>{
//    @Query("SELECT a FROM UserInfo a WHERE a.id!=:id AND a.active!= Y ")
    UserInfo findUserInfoByname(String username);
    
    UserInfo findUserInfoByEmail(String email);
    
}
