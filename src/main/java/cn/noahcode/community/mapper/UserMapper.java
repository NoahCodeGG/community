package cn.noahcode.community.mapper;

import cn.noahcode.community.model.User;
import org.apache.ibatis.annotations.*;

/**
 * @author NoahCode
 * @date 2019/12/1
 * @description
 */
@Mapper
public interface UserMapper {
    @Insert("INSERT INTO USER(ACCOUNT_ID, NAME, TOKEN, GMT_CREATE, GMT_MODIFIED,AVATAR_URL) VALUES(#{accountId},#{name}," +
            "#{token},#{gmtCreate},#{gmtModified},#{avatarUrl})")
    void insert(User user);

    @Select("select * from USER where TOKEN = #{token}")
    User findByToken(@Param("token") String token);

    @Select("select * from USER where ID = #{id}")
    User findById(@Param("id") String id);

    @Select("select * from USER where ACCOUNT_ID = #{accountId}")
    User findByAccountId(@Param("accountId") String accountId);

    @Update("update USER set NAME = #{name},TOKEN = #{token},AVATAR_URL = #{avatarUrl},GMT_MODIFIED = #{gmtModified} where ACCOUNT_ID = #{accountId}")
    void update(User user);
}
