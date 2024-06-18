package project.Common;

import java.io.Serial;
import java.io.Serializable;

public class Account implements Serializable {

    @Serial
    private static final long serialVersionUID = 1555L;

    private String userName;
    private String password;

    private static Account instance;

    public static Account getInstance(){
        if (instance == null) {
            instance = new Account();
        }
        return instance;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
