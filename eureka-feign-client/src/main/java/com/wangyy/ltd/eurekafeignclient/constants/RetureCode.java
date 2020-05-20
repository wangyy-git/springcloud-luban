package com.wangyy.ltd.eurekafeignclient.constants;

public enum RetureCode {

    OK(200),EXCEPTION(500),FAIL(400);

    private int code;


    RetureCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }


}
