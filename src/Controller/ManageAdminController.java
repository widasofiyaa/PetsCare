package Controller;

import DAO.AdminDAO;
import Model.Owner;
import View.ManageAdmin;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kel4
 */
public class ManageAdminController {
    ManageAdmin manageAdminView;
    List<Owner> adminList;   
    private int idUser;
    AdminDAO adminDAO;
    String[] header;

    public ManageAdminController(ManageAdmin manageAdminView, int idUser) {
        this.manageAdminView = manageAdminView;
        this.idUser = idUser;
        adminDAO = new AdminDAO(idUser);
        header = new String[]{"Id", "Username", "Password"};
    }
    
    public void renderTable() {
        adminList = adminDAO.getAll();
        
        DefaultTableModel tblModel = new DefaultTableModel(new Object[][]{}, header) {
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };

        Object[] data = new Object[header.length];
        for (Owner owner : adminList) {
            data[0] = owner.getId();
            data[1] = owner.getUsername();
            data[2] = owner.getPassword();
            tblModel.addRow(data);
        }
        
        manageAdminView.adminTbl.setModel(tblModel);
    }
    
    public void isiField(int row) {
        manageAdminView.usernameField.setText(String.valueOf(adminList.get(row).getUsername()));
        manageAdminView.passwordField.setText(String.valueOf(adminList.get(row).getPassword()));
    }
    
    public void insert() {
        Owner owner = new Owner(idUser, manageAdminView.usernameField.getText(), manageAdminView.passwordField.getText());
        adminDAO.insert(owner);
    }
    
    public void update(int row) {
        String id = (String.valueOf(adminList.get(row).getId()));
        Owner owner = new Owner(Integer.parseInt(id), manageAdminView.usernameField.getText(), manageAdminView.passwordField.getText());
        adminDAO.update(owner);
    }
    
    public void delete(int row) {
        String id = (String.valueOf(adminList.get(row).getId()));
        adminDAO.delete(Integer.parseInt(id));
    }
}
