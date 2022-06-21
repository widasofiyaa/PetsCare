package DAO;

import Database.Koneksi;
import Model.Owner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author MFI
 */
public class AdminDAO implements DAOInterface<Owner> {
    Connection connection = Koneksi.getKoneksi();
    private int idUser;

    public AdminDAO(int id) {
        this.idUser = id;
    }
    
    public AdminDAO(){
    }
    
    @Override
    public void insert(Owner object) {
        PreparedStatement statement = null;
        boolean cekUsername;
        
        cekUsername = isTaken(object.getUsername());
        if(!cekUsername){
            try {
                statement = connection.prepareStatement("INSERT INTO `admin` (`id`, `username`, `password`) VALUES (?, ?, ?)");
                statement.setString(1, null);
                statement.setString(2, object.getUsername());
                statement.setString(3, object.getPassword());
                statement.executeUpdate();
                statement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else{
            JOptionPane.showMessageDialog(null, "Username Sudah Ada!");
        }
        
    }
    
    public boolean isTaken(String username) {
        PreparedStatement statement = null;
        try {
            
            statement = connection.prepareStatement("SELECT * FROM admin WHERE username = ?");
            statement.setString(1, username);
            ResultSet rs = statement.executeQuery();
            
            //jika data sudah pernah disimpan
            if (rs.next()) {
                statement.close();
                return true;
            //jika data belum pernah disimpan
            } else {                
                statement.close();
                return false;
            }            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public ResultSet cekAkun(String username) {
        ResultSet result = null;

        String query = "SELECT id, password FROM `owner` WHERE username = '" + username + "'";

        try {
            result = connection.createStatement().executeQuery(query);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        return result;
        
    }
    
        public ResultSet cekAkunAdmin(String username) {
        ResultSet result = null;

        String query = "SELECT id, password FROM `admin` WHERE username = '" + username + "'";

        try {
            result = connection.createStatement().executeQuery(query);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        return result;
        
    }

    @Override
    public void update(Owner object) {
        try {
        PreparedStatement statement = null;
            statement = connection.prepareStatement("UPDATE `admin` SET `id` = ?, `username` = ?, `password` = ? WHERE `admin`.`id` = ?");                
            statement.setInt(1, object.getId());
            statement.setString(2, object.getUsername());
            statement.setString(3, object.getPassword());
            statement.setInt(4, object.getId());
            statement.executeUpdate();                    
            JOptionPane.showMessageDialog(null, "Data berhasil di ubah!");                
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }        
    }


    @Override
    public void delete(Integer id) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("DELETE FROM `admin` WHERE `admin`.`id` = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil di hapus!");
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Owner> get(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Owner> getAll() {
        List<Owner> list = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM admin");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                list.add(new Owner(rs.getInt("id"), rs.getString("username"), rs.getString("password")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
}
