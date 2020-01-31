package cn.noahcode.community.dto;

import cn.noahcode.community.model.User;
import lombok.Data;

/**
 * @author NoahCode
 * @date 2019/12/4
 * @description
 */
@Data
public class QuestionDTO {
    private Integer id;
    private String title;
    private String description;
    private Long gmtCreate;
    private Long gmtModified;
    private String creator;
    private Integer commentCount;
    private Integer viewCount;
    private Integer likeCount;
    private String tag;
    private User user;
}
