package cn.noahcode.community.dto;

import lombok.Data;

/**
 * @author NoahCode
 * @date 2019/11/30
 * @description
 */
@Data
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_url;
    private String state;
}
