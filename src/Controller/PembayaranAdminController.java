/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.OrderDAO;
import static DAO.OrderDAO.getCurrentTransaksi;
import DAO.ProdukDAO;
import Database.Koneksi;
import Model.CekTransaksi;
import Model.Produk;
import View.Order;
import View.PembayaranOrder;
import View.PembayaranAdmin;
import java.awt.event.ActionEvent;
import java.util.List;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import sun.security.pkcs11.Secmod;

/**
 *
 * @author wida
 */
public class PembayaranAdminController implements ActionListener {
    Connection connection = Koneksi.getKoneksi();
    private int idUser;
    private int idOrder;
    List<CekTransaksi> cekTransaksiList;
    private PembayaranAdmin PembayaranAdminView;
    private PembayaranAdminController PembayaranAdminController;
    private OrderDAO orderDAO;
    private String[] kuantitiHeader;
    static String kuantitiField;
    //private Database db;
    
    public PembayaranAdminController(PembayaranOrder pembayaranView){
        this.PembayaranAdminView = PembayaranAdminView;
        this.idUser = idUser;
        this.idOrder =idOrder;
        orderDAO = new OrderDAO(idUser);
        kuantitiHeader = new String[]{"kuantiti"};
        
    }
    
    public void init(String namaproduk, int harga, int kuantiti){
        kuantitiField(kuantiti);
        //PembayaranAdminView.namaPembeliLabel.setText(namaproduk);
        //PembayaranAdminView.hargaLabel.setText(String.valueOf(harga));
        //pembayaranView.kuantitiLabel.setText(("jj"+String.valueOf(kuantiti)));
        //pembayaranView.setKuantitiLabel(orderdb.getCurrentTransaksi().getKuantiti());
        
        //pembayaranView.setKuantitiLabel(OrderDAO.getCurrrentTransaksi().getKuantiti());
        //view.setTfAlamat(db.getCurrentPelanggar().getAlamat());
        
    }
    public void kuantitiField(int id){
        //PreparedStatement statement = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM cek_transaksi");
            //statement.setInt(1, idUser);
            //statement.setInt(2, idOrder);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                //PembayaranAdminView.kuantitiLabel.setText(String.valueOf(rs.getInt("kuantiti")));
            }
                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
