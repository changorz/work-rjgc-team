package chang.model.response;

public enum CommonCode implements ResultCode {
    FAIL(false,11111,"操作失败！"),
    SUCCESS(true,10000,"操作成功！"),
    UNAUTHENTICATED(false,10001,"此操作需要登陆系统！"),
    UNAUTHORISE(false,10002,"权限不足，无权操作！"),
    INVALID_PARAM(false,10003,"非法参数！"),
    // 文件
    FILE_UPLOAD_ERR(false,10004,"文件上传失败！"),
    FILE_READ_ERR(false,10005,"文件操作异常！"),
    FILE_READ_OK(true,10006,"文件上传完毕！"),
    FILE_FILE_ERR(true,10007,"非法文件！"),

    SERVER_ERROR(false,99999,"抱歉，系统繁忙，请稍后重试！");
    //操作是否成功
    boolean success;
    //操作代码
    int code;
    //提示信息
    String message;

    private CommonCode(boolean success,int code, String message){
        this.success = success;
        this.code = code;
        this.message = message;
    }

    public boolean success() {
        return success;
    }

    public int code() {
        return code;
    }

    public String message() {
        return message;
    }
}
