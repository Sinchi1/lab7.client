package project.Common;

import project.ProgrammEnums.OperationCode;

import java.io.Serial;
import java.io.Serializable;

public class Response implements Serializable {

    @Serial
    private static final long serialVersionUID = 121321L;

    private final String ResponseBody;

    private final OperationCode operationCode;

    public Response(String responseBody, OperationCode operationCode) {
        ResponseBody = responseBody;
        this.operationCode = operationCode;
    }

    public OperationCode getOperationCode() {
        return operationCode;
    }
    public String getResponseBody() {
        return ResponseBody;
    }
}
