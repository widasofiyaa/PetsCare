/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.DAOInterface;
import Database.Koneksi;
import Model.Pembayaran;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

/**
 *
 * @author wida
 */
public class PembayaranDAO implements DAOInterface<Pembayaran>{
    Connection connection = Koneksi.getKoneksi();
    private int idUser;
    private int idOrder;
    
    public PembayaranDAO(int idUser, int idOrder){
        this.idUser =idUser;
        this.idOrder = idOrder;
    }
    
    public PembayaranDAO(){
    }
    
    @Override
    public void insert(Pembayaran object) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("INSERT INTO `pembayaran` (`id`, `id_pembeli`,`id_transaksi`) VALUES (null, ?,?)");
            statement.setInt(1, idUser);
            statement.setInt(2, object.getIdOrder());
            //statement.setString(3, object.getStatus());
            statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Pembayaran object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Pembayaran> get(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Pembayaran> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
