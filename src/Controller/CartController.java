/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.CartDAO;
import DAO.OrderDAO;
import DAO.ProdukDAO;
import Model.CartProduk;
import Model.Produk;
import View.Cart;
import View.Order;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author wida
 */
public class CartController {
    private int idUser;
    Cart cartView;
    Order orderView;
    ProdukDAO produkDAO;
    OrderDAO orderDAO;
    CartDAO cartDAO;
    List<CartProduk> produkList;
    String [] header;
    
    public CartController(Cart cartView, int idUser) {
        this.cartView = cartView;
        this.idUser = idUser;
        produkDAO = new ProdukDAO(idUser);
        orderDAO = new OrderDAO(idUser);
        cartDAO = new CartDAO(idUser);
        header = new String []{"id","Produk","Harga"};
    } 
    
    public void renderTable() {
        produkList = cartDAO.getAll();
        
        DefaultTableModel tblModel = new DefaultTableModel(new Object[][]{}, header) {
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };
        
        Object[] data = new Object[header.length];
        for (CartProduk produk : produkList){
            data[0] = produk.getId();
            data[1] = produk.getIdProduk();
            data[2] = produk.getHarga();
            //data[3] = produk.getHarga();
            tblModel.addRow(data);
        }
        cartView.cartTbl.setModel(tblModel);
    }
    
    public void keranjang(int idProduk, String namaProduk, int harga) {
        CartProduk cartProduk = new CartProduk();
        
        //String inputKuantiti = orderView.kuantitiField.getText();
        //int kuantiti = Integer.parseInt(inputKuantiti);
        //int totalorder = kuantiti*harga;
        
        cartProduk.setIdProduk(idProduk);
        //cartProduk.setKuantiti(kuantiti);
        cartProduk.setHarga(harga);
        cartDAO.insert(cartProduk);
        //orderView.dispose();
        
    }
}
