package cn.noahcode.community.mapper;

import cn.noahcode.community.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author NoahCode
 * @date 2019/12/2
 * @description
 */
@Mapper
public interface QuestionMapper {

    @Insert("insert into QUESTION (TITLE,DESCRIPTION,GMT_CREATE,GMT_MODIFIELD,CREATOR,COMMENT_COUNT,VIEW_COUNT," +
            "LIKE_COUNT,TAG) values(#{title},#{description},#{gmtCreate},#{gmtModifield},#{creator},#{commentCount}," +
            "#{viewCount},#{likeCount},#{tag})")
    void create(Question question);
}
