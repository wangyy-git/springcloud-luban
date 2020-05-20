package com.wangyy.ltd.eurekafeignclient.web;

import com.wangyy.ltd.eurekafeignclient.result.WyyResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static com.wangyy.ltd.eurekafeignclient.constants.RetureCode.*;

public class BaseController {

    public WyyResult ok(){
        WyyResult result = new WyyResult();
        result.setSuccess(true);
        result.setStatusCode(OK.getCode());
        result.setMessage("ok");
        return result;
    }

    public WyyResult ok(Object data) {
        WyyResult result = ok();
        result.setData(data);
        return result;
    }

    public WyyResult fail(String message){
        WyyResult result = new WyyResult();
        result.setSuccess(false);
        result.setStatusCode(FAIL.getCode());
        result.setMessage(message);

        return result;
    }

    @ExceptionHandler
    public WyyResult exceptionHandler(Exception e){
        return e.getMessage() != null ? fail(e.getMessage()):fail("運行異常");
    }
}
