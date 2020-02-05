package cn.noahcode.community.exception;

/**
 * @author NoahCode
 * @date 2020/2/1
 * @description
 */
public enum CustomizeErrorCode implements ICustomizeErrorCode {
    //问题找不到
    QUESTION_NOT_FOUND(2001, "You find the question is not presence ，you can try other please !"),
    //目标丢失
    TARGET_PARAM_NOT_FOUND(2002, "You didn't choose any question or comment , so you can't reply !"),
    //没有登录
    NO_LOGIN(2003, "You aren't logged in , please log in before commenting !"),
    //系统错误
    SYSTEM_ERROR(2004, "Sorry , we have a problem , please try again later !"),
    //类型错误
    TYPE_PARAM_WRONG(2005, "The comment's type is wrong or not exist !"),
    //回复丢失
    COMMENT_NOT_FOUND(2006, "The comment is not found , you can try other please !");


    private Integer code;
    private String message;

    CustomizeErrorCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getCode() {
        return code;
    }
}
