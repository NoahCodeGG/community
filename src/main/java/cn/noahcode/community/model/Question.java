package cn.noahcode.community.model;

import lombok.Data;

/**
 * @author NoahCode
 * @date 2019/12/2
 * @description
 */
@Data
public class Question {
    private Integer id;
    private String title;
    private String description;
    private Long gmtCreate;
    private Long gmtModified;
    private String creator;
    private int commentCount;
    private int viewCount;
    private int likeCount;
    private String tag;
}
