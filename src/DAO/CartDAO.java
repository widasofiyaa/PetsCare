/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Database.Koneksi;
import Model.CartProduk;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wida
 */
public class CartDAO implements DAOInterface<CartProduk>{
    Connection connection = Koneksi.getKoneksi();
    private int idUser;
    
    public CartDAO(int idUser) {
        this.idUser = idUser;
    }
    @Override
    public void insert(CartProduk object) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("INSERT INTO `cart` (`id`,`id_pembeli`,`id_product`,`total`) VALUES (NULL, ?, ?, ?)");
            statement.setInt(1, idUser);
            statement.setInt(2, object.getIdProduk());
            //statement.setInt(3, object.getKuantiti());
            statement.setInt(4, object.getHarga());
            statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(CartProduk object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CartProduk> get(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CartProduk> getAll() {
        List<CartProduk> list = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM `cart` WHERE id_pembeli=?");
            statement.setInt(1, idUser);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                CartProduk cartProduk = new CartProduk(rs.getInt("id"),rs.getInt("id_product"),rs.getInt("harga"));
                cartProduk.setId(rs.getInt("id"));
                cartProduk.setIdUser(rs.getInt("id_pembeli"));
                cartProduk.setIdProduk(rs.getInt("id_product"));
                cartProduk.setHarga(rs.getInt("harga"));
                list.add(cartProduk);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
}
