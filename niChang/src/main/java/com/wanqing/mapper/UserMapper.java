package com.wanqing.mapper;


import com.wanqing.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author 婉清
 * @package com.wanqing.mapper
 * @project niChangBot
 * @date 2025/6/25 14:16
 * @file UserMapper
 * @description
 */
@Repository
public interface UserMapper {

    User selectUserById(@Param("userId") String userId);

    void insertUser(User user);

    void updateToys(@Param("userId") String userId, @Param("toys") String toys);

    void updateXpInfo(@Param("userId") String userId, @Param("xpInfo") String xpInfo);

    void updateClothes(@Param("userId") String userId, @Param("clothes") String clothes);

    void updateTimeCount();
}
