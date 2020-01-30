package cn.noahcode.community.mapper;

import cn.noahcode.community.dto.QuestionDTO;
import cn.noahcode.community.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author NoahCode
 * @date 2019/12/2
 * @description
 */
@Mapper
public interface QuestionMapper {

    @Insert("insert into QUESTION (TITLE,DESCRIPTION,GMT_CREATE,GMT_MODIFIED,CREATOR,COMMENT_COUNT,VIEW_COUNT," +
            "LIKE_COUNT,TAG) values(#{title},#{description},#{gmtCreate},#{gmtModified},#{creator},#{commentCount}," +
            "#{viewCount},#{likeCount},#{tag})")
    void create(Question question);

    @Select("select * from QUESTION limit #{offset}, #{size}")
    List<Question> list(@Param(value = "offset") Integer offset, @Param(value = "size") Integer size);

    @Select("select count(1) from QUESTION")
    Integer count();

    @Select("select * from QUESTION where creator = #{accountId} limit #{offset}, #{size}")
    List<Question> listByAccountId(@Param(value = "accountId") Integer accountId, @Param(value = "offset") Integer offset,
                                   @Param(value = "size") Integer size);

    @Select("select count(1) from QUESTION where creator = #{accountId}")
    Integer countByAccountId(@Param(value = "accountId") Integer accountId);

    @Select("select * from QUESTION where id = #{id}")
    Question getById(@Param("id") Integer id);
}
