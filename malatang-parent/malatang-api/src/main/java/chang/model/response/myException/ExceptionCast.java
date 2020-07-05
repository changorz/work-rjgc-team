package chang.model.response.myException;

import chang.model.response.ResultCode;

public class ExceptionCast {
    public static void cast(ResultCode resultCode){
        throw new MyException(resultCode);
    }
}
