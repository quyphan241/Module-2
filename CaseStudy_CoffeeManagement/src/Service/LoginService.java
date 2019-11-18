package Service;

import Model.Login;

import java.sql.SQLException;

public interface LoginService {
    boolean checkLogin(int id, String password) throws SQLException,ClassNotFoundException;
    Login getInformation();
    void out();
}
