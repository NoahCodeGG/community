package cn.noahcode.community.mapper;

import cn.noahcode.community.model.Question;

public interface QuestionExtMapper {
    int incView(Question record);
    int incComment(Question record);
}