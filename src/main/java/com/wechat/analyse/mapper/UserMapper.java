package com.wechat.analyse.mapper;

import com.wechat.analyse.bean.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

/**
 * @author WHY
 * mapper的具体表达式
 */
@Mapper
@Repository
public interface UserMapper {

    /**
     * 注册 插入一条记录
     * 加入 Options 注解可以保存对象后，查看对象插入的id
     * @param user 用户
     */
    @Insert("insert into user values(#{id},#{username},#{password})")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    void register(User user);

    /**
     * 登录
     * @param user 用户
     * @return 是否成功
     */
    @Select("select u.id from user u where u.username=#{username} and password=#{password}")
    Long login(User user);

    /**
     * 查询用户名是否存在，若存在，则不允许注册
     * 注解@Param  @Results 列明和字段名相同
     * @param name 用户名
     * @return 用户
     */
    @Select(value="select u.username,u.password from user u where u.username=#{username}")
    @Results
            ({@Result(property = "username",column = "username"),
              @Result(property = "password",column = "password")})
    User findUserByName(@Param("username")String name);
}
