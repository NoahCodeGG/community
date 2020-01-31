package cn.noahcode.community.model;

import lombok.Data;

/**
 * @author NoahCode
 * @date 2019/12/1
 * @description
 */
@Data
public class User {
    private String id;
    private String name;
    private String accountId;
    private String token;
    private Long gmtCreate;
    private Long gmtModified;
    private String avatarUrl;
}
