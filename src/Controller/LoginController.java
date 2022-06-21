package Controller;
import DAO.UserDAO;
import DAO.AdminDAO;
import Database.Koneksi;
import View.Dashboard;
import View.DashboardAdmin;
import View.DashboardOwner;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import View.Login;

public class LoginController {
    private UserDAO userDAO = new UserDAO();
    private AdminDAO adminDAO = new AdminDAO();
    private Login loginView;

    public LoginController(Login loginView) {
        this.loginView = loginView;
    }
    
    public void login() {
        String username = loginView.usernameField.getText();
        String password = loginView.passwordField.getText();

        ResultSet result = userDAO.cekAkun(username);    
        ResultSet resultOwner = adminDAO.cekAkun(username);
        ResultSet resultAdmin = adminDAO.cekAkunAdmin(username);
        
        try {
            validasi(username, password);
            if (result.next()) {
                if (password.equals(result.getString("password"))) {
                    new Dashboard(result.getInt("id"), username).setVisible(true);
                    loginView.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Password anda salah!");
                }
            } else if(resultAdmin.next()){
                if (password.equals(resultAdmin.getString("password"))) {
                    new DashboardAdmin(resultAdmin.getInt("id"), username).setVisible(true);
                    loginView.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Password anda salah!");
                }
                
            } else if(resultOwner.next()){
                if (password.equals(resultOwner.getString("password"))) {
                    new DashboardOwner(resultOwner.getInt("id"), username).setVisible(true);
                    loginView.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Password anda salah!");
                }
            }
        } catch (Exception ex) {            
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
        public boolean validasi(String username, String password) {
            if(username.equals("") ) {
                JOptionPane.showMessageDialog(null, "Mohon isi username anda.");
                return false;
            }

            if( password.equals("") ) {
                JOptionPane.showMessageDialog(null, "Mohon isi password anda.");
                return false;
            }

            if( password.length() < 8 ) {
                JOptionPane.showMessageDialog(null, "Password minimal harus berisi 8 karakter!");
                return false;
            }

            return true;
    }
}
