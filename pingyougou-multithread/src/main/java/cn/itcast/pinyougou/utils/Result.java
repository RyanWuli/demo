package cn.itcast.pinyougou.utils;

/**
 * @Author: Ryan
 * @Date: 2020/7/18 10:59
 * @Version: 1.0
 * @Description:
 */
public class Result {

    private boolean success;
    private String message;

    public Result(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
