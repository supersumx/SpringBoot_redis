package com.kwhua.redis.dao;

import com.kwhua.redis.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDao {
    //select All
    @Select("select * from t_user")
    @Results({
            @Result(property = "userName",column = "user_name"),
            @Result(property = "passWord",column = "pass_word")
    })
    List<User> queryAll();

    //select by id
    @Select("select * from t_user where id =#{id}")
    @Results({
            @Result(property = "userName",column = "user_name"),
            @Result(property = "passWord",column = "pass_word")
    })
    User findUserById(Integer id);

    //update by id
    @Update("update t_user set user_name=#{userName},pass_word =#{passWord},sex=#{sex},birthday=#{birthday} WHERE id = #{id} ")
    int updateUser(User user);

    //delete by id
    @Delete("delete from t_user where id = #{id}")
    int deleteUserById(Integer id);
}
