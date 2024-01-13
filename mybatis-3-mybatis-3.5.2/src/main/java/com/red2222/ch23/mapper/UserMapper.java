package com.red2222.ch23.mapper;


import com.red2222.ch23.pojo.User;

/**
 * Mapper接口
 *
 * @author red2222
 * @date 2023/12/30
 */
public interface UserMapper {

    /*
    * 添加用户信息
    * */
    int insertUser(User user);


    User selectUserById(Integer id);

}
