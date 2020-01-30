package cn.noahcode.community.dto;

import lombok.Data;

/**
 * @author NoahCode
 * @date 2019/11/30
 * @description
 */
@Data
public class GithubUser {
    private String name;
    private Long id;
    private String bio;
    private String avatarUrl;
}
