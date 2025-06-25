package com.wanqing.mapper;

import com.wanqing.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author 婉清
 * @package com.wanqing.mapper
 * @project niChangBot
 * @date 2025/6/25 14:16
 * @file UserMapper
 * @description
 */
@Mapper
public interface UserMapper {

    User selectUserById(@Param("userId") String userId);

    void insertUser(User user);


}
