package chang.model.response.myException;

import chang.model.response.ResultCode;

public class MyException extends RuntimeException {

    //错误代码
    ResultCode resultCode;

    public MyException(ResultCode resultCode){
        this.resultCode = resultCode;
    }
    public ResultCode getResultCode(){
        return resultCode;
    }

}
