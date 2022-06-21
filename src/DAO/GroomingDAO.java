/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Database.Koneksi;
import Model.HistoryGrooming;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MZA
 */
public class GroomingDAO implements DAOInterface<HistoryGrooming>{
    Connection connection = Koneksi.getKoneksi();
    private int idUser;
    
    public GroomingDAO(int idUser) {
        this.idUser = idUser;
    }

    public GroomingDAO() {
    }
    
    @Override
    public void insert(HistoryGrooming object) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("INSERT INTO `history_grooming` (`id`, `id_pembeli`, `id_hewan`, `timestamp`, `jam`, `harga`) VALUES (NULL, ?, ?, current_timestamp(), ?, ?)");
            statement.setInt(1, idUser);
            statement.setInt(2, object.getIdHewan());
            statement.setString(3, object.getDate());
            statement.setInt(4, object.getHarga());
            statement.executeUpdate();
            statement.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void update(HistoryGrooming object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<HistoryGrooming> get(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<HistoryGrooming> getAll() {
        List<HistoryGrooming> list = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM `history_grooming` WHERE id_pembeli=?");
            statement.setInt(1, idUser);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                HistoryGrooming grooming = new HistoryGrooming(rs.getInt("id"), rs.getDate("timestamp"), rs.getString("jam"), rs.getInt("harga"));
                grooming.setIdUser(rs.getInt("id_pembeli"));
                grooming.setIdHewan(rs.getInt("id_hewan"));
                list.add(grooming);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public List<HistoryGrooming> getAllLaporan() {
        List<HistoryGrooming> list = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM `history_grooming`");
            //statement.setInt(1, idUser);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                list.add(new HistoryGrooming(rs.getInt("id_pembeli"), rs.getInt("id_hewan"), rs.getDate("timestamp"), rs.getString("jam"), rs.getInt("harga")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    } 
    
}
