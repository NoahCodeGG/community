package cn.noahcode.community.mapper;

import cn.noahcode.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author NoahCode
 * @date 2019/12/1
 * @description
 */
@Mapper
public interface UserMapper {
    @Insert("INSERT INTO USER(account_id, name, token, gmt_create, gmt_modified) VALUES(#{accountId},#{name}," +
            "#{token},#{gmtCreate},#{gmtModified})")
    void insert(User user);
}
