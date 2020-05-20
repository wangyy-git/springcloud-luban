package com.wangyy.ltd.eurekafeignclient.result;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class WyyResult {

    private Boolean success;
    private Integer statusCode;
    private String message;
    private Object data;
}
