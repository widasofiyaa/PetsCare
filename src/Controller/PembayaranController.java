/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.OrderDAO;
import DAO.PembayaranDAO;
import Model.Pembayaran;
import DAO.ProdukDAO;
import Database.Koneksi;
import Model.CekTransaksi;
import Model.Produk;
import View.Order;
import View.PembayaranOrder;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author wida
 */
public class PembayaranController {
    Connection connection = Koneksi.getKoneksi();
    private int idUser;
    private int idOrder;
    List<CekTransaksi> cekTransaksiList;
    private PembayaranOrder pembayaranView;
    private PembayaranController pembayaranController;
    private OrderDAO orderDAO;
    private PembayaranDAO pembayaranDAO;
    private String[] kuantitiHeader;
    static String kuantitiField;
    //private Database db;
    
    public PembayaranController(PembayaranOrder pembayaranView, int idUser, int idOrder){
        this.pembayaranView = pembayaranView;
        this.idUser = idUser;
        this.idOrder =idOrder;
        orderDAO = new OrderDAO(idUser);
        pembayaranDAO = new PembayaranDAO(idUser,idOrder);
        kuantitiHeader = new String[]{"kuantiti"};
        
    }
    //String kuantitiInput = pembayaranView.kuantitiLabel.getText();
    //int kuantitiInt = Integer.parseInt(kuantitiInput);
    public void init(String namaproduk, int harga, int kuantiti){
        //kuantitiField(kuantiti);
        Pembayaran pembayaran = new Pembayaran();
        pembayaranView.produkLabel.setText(namaproduk);
        pembayaranView.hargaLabel.setText(String.valueOf(harga));
        //int hargaInt = Integer.parse(harga);
        String kuantitiInput = pembayaranView.kuantitiLabel.getText();
        //int kuantiti = Integer.parseInt(kuantitiInput);
        pembayaranView.totalField.setText(String.valueOf((harga*kuantiti)));
        
        
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM cek_transaksi");
            //statement.setInt(1, idUser);
            //statement.setInt(2, idOrder);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                pembayaranView.kuantitiLabel.setText(String.valueOf(rs.getInt("kuantiti")));
                kuantiti = rs.getInt("kuantiti");
                pembayaranView.ongkosField.setText("10000");
            }
                    
        } catch (Exception e) {
            e.printStackTrace();
        }  
        
        pembayaranView.totalField.setText(String.valueOf((harga*kuantiti+10000)));       
    }
    
    public void bayar(int idUser,int idOrder){
        Pembayaran pembayaran = new Pembayaran();
        //pembayaran.setStatus("dikemas");
        //pembayaran.setIdTransaksi(idOrder);
        pembayaran.setIdUser(idUser);
        pembayaran.setIdOrder(idOrder);
        pembayaranDAO.insert(pembayaran);
        
        JOptionPane.showMessageDialog(null, "Pembayaran Berhasil!");
        pembayaranView.dispose();
    }
}
