/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author wida
 */
import Database.Koneksi;
import Model.Produk;
import Model.CekTransaksi;
import Model.HistoryOrder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO implements DAOInterface<CekTransaksi>{
    Connection connection = Koneksi.getKoneksi();
    private int idUser;
    
    private static CekTransaksi currentTransaksi;
    private ArrayList<CekTransaksi> listTransaksi = new ArrayList<>();

    public OrderDAO(int idUser) {
        this.idUser = idUser;
    }

    public OrderDAO() {}

    @Override
    public void insert(CekTransaksi object) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("INSERT INTO `cek_transaksi` (`id`,`id_pembeli`,`id_produk`,`timestamp`,`kuantiti`,`harga`,`status`) VALUES (NULL, ?, ?, current_timestamp(), ?, ?, ?)");
            statement.setInt(1, idUser);
            statement.setInt(2, object.getIdProduk());
            statement.setInt(3, object.getKuantiti());
            statement.setInt(4, object.getHarga());
            statement.setString(5, object.getStatus());
            statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(CekTransaksi object) {
        
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CekTransaksi> get(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CekTransaksi> getAll() {
        List<CekTransaksi> list = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM `cek_transaksi` WHERE id_pembeli=?");
            statement.setInt(1, idUser);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                CekTransaksi cekTransaksi = new CekTransaksi(rs.getDate("timestamp"),rs.getInt("id_produk"),rs.getInt("harga"),rs.getString("status"));
                cekTransaksi.setIdUser(rs.getInt("id_pembeli"));
                cekTransaksi.setIdProduk(rs.getInt("id_produk"));
                list.add(cekTransaksi);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
     public List<CekTransaksi> getAllLaporan() {
        List<CekTransaksi> list = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM `cek_transaksi`");
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                list.add(new CekTransaksi(rs.getString("timestamp"), rs.getInt("kuantiti") , rs.getInt("harga"), rs.getInt("id_produk"), rs.getInt("id_pembeli"), rs.getString("status")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static CekTransaksi getCurrentTransaksi() {
        return currentTransaksi;
    }

    public ArrayList<CekTransaksi> getListTransaksi() {
        return listTransaksi;
    }
    
    
    
}
