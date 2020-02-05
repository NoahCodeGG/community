package cn.noahcode.community.service;

import cn.noahcode.community.enums.CommentTypeEnum;
import cn.noahcode.community.exception.CustomizeErrorCode;
import cn.noahcode.community.exception.CustomizeException;
import cn.noahcode.community.mapper.CommentMapper;
import cn.noahcode.community.mapper.QuestionExtMapper;
import cn.noahcode.community.mapper.QuestionMapper;
import cn.noahcode.community.model.Comment;
import cn.noahcode.community.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author NoahCode
 * @date 2020/2/2
 * @description
 */
@Service
public class CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private QuestionExtMapper questionExtMapper;

    public void insert(Comment comment) {
        if (comment.getParentId() == null || comment.getParentId() == 0) {
            throw new CustomizeException(CustomizeErrorCode.TARGET_PARAM_NOT_FOUND);
        }
        if (comment.getType() == null || !CommentTypeEnum.isExist(comment.getType())) {
            throw new CustomizeException(CustomizeErrorCode.TYPE_PARAM_WRONG);
        }
        if (comment.getType().equals(CommentTypeEnum.QUESTION.getType())) {
            //回复问题
            Question dbQuestion = questionMapper.selectByPrimaryKey(comment.getParentId());
            if (dbQuestion == null) {
                throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
            }
            dbQuestion.setCommentCount(1);
            questionExtMapper.incComment(dbQuestion);
        } else {
            //回复评论
            Comment dbComment = commentMapper.selectByPrimaryKey(comment.getParentId());
            if (dbComment == null) {
                throw new CustomizeException(CustomizeErrorCode.COMMENT_NOT_FOUND);
            }
        }
        commentMapper.insertSelective(comment);
    }
}
