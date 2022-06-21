package DAO;

import Database.Koneksi;
import Model.Produk;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ProdukDAO implements DAOInterface<Produk>{
    Connection connection = Koneksi.getKoneksi();
    private int idUser;
    
    public ProdukDAO(int username){
        this.idUser = idUser;
    }

    public ProdukDAO() {
    }

    @Override
    public void insert(Produk object) {
       try {
            PreparedStatement statement = null;
            statement = connection.prepareStatement("INSERT INTO `product`(`id`, `nama`, `harga`, `kategori`) VALUES (?, ?, ?, ?)");
            statement.setInt(1, object.getId());
            statement.setString(2, object.getNama());
            statement.setInt(3, object.getHarga());
            statement.setString(4, object.getCategory());
            statement.executeUpdate();                    
            JOptionPane.showMessageDialog(null, "Data berhasil di tambah!");
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Produk object) {
        try {
        PreparedStatement statement = null;
            statement = connection.prepareStatement("UPDATE `product` SET `id` = ?, `nama` = ?, `harga` = ?, `kategori` = ? WHERE `product`.`id` = ?");                
            statement.setInt(1, object.getId());
            statement.setString(2, object.getNama());
            statement.setInt(3, object.getHarga());
            statement.setString(4, object.getCategory());
            statement.setInt(5, object.getId());
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
            statement = connection.prepareStatement("DELETE FROM `product` WHERE `product`.`id` = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil di hapus!");
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Produk> get(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Produk> getAll() {
        List<Produk> list = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM product");
            //statement.setInt(1, idUser);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                list.add(new Produk(rs.getInt("id"), rs.getString("nama"), rs.getInt("harga") ,rs.getString("kategori")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
