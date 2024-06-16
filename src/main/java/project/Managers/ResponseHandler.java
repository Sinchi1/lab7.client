package project.Managers;

import project.Common.Response;

public class ResponseHandler {
    public String handleResponse(Response response){
        String output = "";

        output = switch (response.getOperationCode()) {
            case ok -> "Успешно:\n" + response.getResponseBody();
            case error -> "Ошибка:\n" + response.getResponseBody();
        };

        return output.trim();
    }
}
