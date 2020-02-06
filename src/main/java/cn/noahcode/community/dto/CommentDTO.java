package cn.noahcode.community.dto;

import cn.noahcode.community.model.User;
import lombok.Data;

/**
 * @author NoahCode
 * @date 2020/2/5
 * @description
 */
@Data
public class CommentDTO {
    private Long id;
    private Long parentId;
    private Integer type;
    private Long commentator;
    private Long gmtCreate;
    private Long gmtModified;
    private Long likeCount;
    private String content;
    private User user;
}
