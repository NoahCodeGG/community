package cn.noahcode.community.dto;

import lombok.Data;

/**
 * @author NoahCode
 * @date 2020/2/2
 * @description
 */
@Data
public class CommentCreateDTO {
    private Long parentId;
    private String content;
    private Integer  type;
}
