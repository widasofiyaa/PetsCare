/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.OrderDAO;
import DAO.ProdukDAO;
import Model.CekTransaksi;
import Model.Produk;
import View.CekTransaksiOrder;
import View.Order;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author wida
 */
public class OrderController {
    private int idUser;
    Order orderView;
    ProdukDAO produkDAO;
    OrderDAO orderDAO;
    List<Produk> produkList;
    String [] header;

    public OrderController(Order orderView, int idUser) {
        this.orderView = orderView;
        this.idUser = idUser;
        produkDAO = new ProdukDAO(idUser);
        orderDAO = new OrderDAO(idUser);
        header = new String []{"id","Nama","Harga","Kategori"};
    }   

            

    public void renderTable() {
        produkList = produkDAO.getAll();
        
        DefaultTableModel tblModel = new DefaultTableModel(new Object[][]{}, header) {
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };
        
        Object[] data = new Object[header.length];
        for (Produk produk : produkList){
            data[0] = produk.getId();
            data[1] = produk.getNama();
            data[2] = produk.getHarga();
            data[3] = produk.getCategory();
            tblModel.addRow(data);
        }
        orderView.produkTbl.setModel(tblModel);
    }

    public void hitung(int idProduk, String namaProduk, int harga) {
        String inputKuantiti = orderView.kuantitiField.getText();
        int kuantiti = Integer.parseInt(inputKuantiti);
        int totalorder = kuantiti*harga;
        
        orderView.totalField.setText(String.valueOf(totalorder));
        
    }

    public void beli(int idProduk, String namaProduk, int harga) {
        CekTransaksi cekTransaksi = new CekTransaksi();
        
        String inputKuantiti = orderView.kuantitiField.getText();
        int kuantiti = Integer.parseInt(inputKuantiti);
        int totalorder = kuantiti*harga;
        
        cekTransaksi.setIdProduk(idProduk);
        cekTransaksi.setKuantiti(kuantiti);
        cekTransaksi.setHarga(totalorder);
        orderDAO.insert(cekTransaksi);
        orderView.dispose();
        
    }
        
}
