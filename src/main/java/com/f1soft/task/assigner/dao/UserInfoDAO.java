
package com.f1soft.task.assigner.dao;

import com.f1soft.task.assigner.entity.UserInfo;
import java.util.List;

/**
 *
 * @author sunita.joshi
 */
public interface UserInfoDAO {
    List<UserInfo> findAll();
    
}
