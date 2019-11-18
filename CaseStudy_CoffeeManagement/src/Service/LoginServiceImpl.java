package Service;

import Model.Login;
import Utils.LoginDb;

import java.sql.SQLException;

public class LoginServiceImpl implements  LoginService {
    private Login information = null;
    @Override
    public boolean checkLogin(int id, String password) throws SQLException, ClassNotFoundException {
        Login check = LoginDb.checkLogin(id, password);
        if (check!=null){
            information = check;
            return true;
        }
        return false;
    }

    @Override
    public Login getInformation() {
        return information;
    }

    @Override
    public void out() {
        information = null;
    }
}
