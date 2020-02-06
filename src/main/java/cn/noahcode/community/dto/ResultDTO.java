package cn.noahcode.community.dto;

import cn.noahcode.community.exception.CustomizeErrorCode;
import cn.noahcode.community.exception.CustomizeException;
import lombok.Data;

/**
 * @author NoahCode
 * @date 2020/2/2
 * @description
 */
@Data
public class ResultDTO<T> {
    private Integer code;
    private String message;
    private T data;

    public static ResultDTO errorOf(Integer code, String message) {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(code);
        resultDTO.setMessage(message);
        return resultDTO;
    }

    public static ResultDTO errorOf(CustomizeErrorCode customizeErrorCode) {
        return errorOf(customizeErrorCode.getCode(), customizeErrorCode.getMessage());
    }

    public static ResultDTO okOf() {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(200);
        resultDTO.setMessage("request succeeded");
        return resultDTO;
    }

    public static ResultDTO errorOf(CustomizeException e) {
        return errorOf(e.getCode(), e.getMessage());
    }

    public static <T> ResultDTO okOf(T t) {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(200);
        resultDTO.setMessage("request succeeded");
        resultDTO.setData(t);
        return resultDTO;
    }
}
