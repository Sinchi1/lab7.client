package project.Commands;

import project.Common.Account;
import project.Common.Request;

public class Logout extends AbstractCommand  {

    public Logout(String name, String description) {
        super(name, description);
    }

    Account account = Account.getInstance();

    /**
     * The method that logout user from account
     * @return void
     */
    @Override
    public Request execute(String args) {
        account.setUserName(null);
        account.setPassword(null);
        return new Request("logout", args);
    }

}
