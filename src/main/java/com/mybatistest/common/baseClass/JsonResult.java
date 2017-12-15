package com.mybatistest.common.baseClass;

/**
 * Created by zhang_jian on 2017/12/15.
 */
public class JsonResult {

    public static final String SUCCESS_CODE = "000000";  //成功的代码

    public static final String FAILURE_CODE = "000001";  //失败的代码

    public static final String TOKEN_FAILURE_CODE = "000002";  //token失效

    public static final String TOKEN_FAILURE_MSG = "登录信息已失效";  //token失效,提示语

    public static final String NO_REGISTER = "000003";  //用户名不存在

    public static final String WRONG_PWD = "000004";  //密码错误

    public static final String IDENTITY_NO_USED = "000005";  //身份证号码已经注册

    public static final String INSUFFICIENT_BALANCE = "000006";  //余额不足

    public static final String REJECT_NO_BLANK = "000007";  //操作被拒绝，关联数据不为空

    public static final String DATA_BLANK = "000008";  // 数据为空

    private String code;

    private String message;

    private Object result;

    public void setSuccessful() {
        this.setCode(SUCCESS_CODE);
        this.setMessage("successful");
    }

    public void setSuccessful(String msg) {
        this.setCode(SUCCESS_CODE);
        this.setMessage(msg);
    }

    public void setFailure() {
        this.setCode(FAILURE_CODE);
        this.setMessage("failure");
    }

    public void setFailure(String msg) {
        this.setCode(FAILURE_CODE);
        this.setMessage(msg);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
