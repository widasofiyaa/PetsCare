/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import DAO.GroomingDAO;
import DAO.OrderDAO;
import DAO.PenitipanDAO;
import Model.HistoryGrooming;
import Model.CekTransaksi;
import Model.HistoryPenitipan;
import View.LaporanPenjualan;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author imama
 */
public class LaporanController {
    LaporanPenjualan laporanView;
    List<CekTransaksi> orderList;   
    List<HistoryGrooming> groomingList;
    List<HistoryPenitipan> penitipanList;
    OrderDAO orderDAO;
    GroomingDAO groomingDAO;
    PenitipanDAO penitipanDAO;
    String[] headerOrder, headerGrooming, headerPenitipan;

    public LaporanController(LaporanPenjualan laporanView) {
        this.laporanView = laporanView;
        orderDAO = new OrderDAO();
        penitipanDAO = new PenitipanDAO();
        groomingDAO = new GroomingDAO();
        headerOrder = new String[]{"No", "Id Pembeli", "Id Produk", "Qty", "Harga"};
        headerPenitipan = new String[]{"No", "Id Pembeli", "Id Hewan", "Lama Penitipan", "Harga"};
        headerGrooming = new String[]{"No", "Id Pembeli", "Id Hewan", "Tanggal Masuk", "Tanggal Keluar", "Harga"};
    }
    
    public void renderTable1() {
        orderList = orderDAO.getAll();
        
        DefaultTableModel tblModel = new DefaultTableModel(new Object[][]{}, headerOrder) {
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };
        
        Object[] data = new Object[headerOrder.length];
        int no = 0;
        for (CekTransaksi historyOrder : orderList) {
            no++;
            data[0] = no;
            data[1] = historyOrder.getIdUser();
            data[2] = historyOrder.getIdProduk();
            data[3] = historyOrder.getKuantiti();
            data[4] = historyOrder.getHarga();
            tblModel.addRow(data);
        }
        
        laporanView.setTabelProduk(tblModel);
    }
    
    public void renderTable2() {
        penitipanList = penitipanDAO.getAllLaporan();
        
        DefaultTableModel tblModel = new DefaultTableModel(new Object[][]{}, headerPenitipan) {
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };
        
        Object[] data = new Object[headerOrder.length];
        int no = 0;
        for (HistoryPenitipan historyPenitipan : penitipanList) {
            no++;
            data[0] = no;
            data[1] = historyPenitipan.getIdUser();
            data[2] = historyPenitipan.getIdHewan();
            data[3] = historyPenitipan.getLamaPenitipan();
            data[4] = historyPenitipan.getHarga();
            tblModel.addRow(data);
        }
        
        laporanView.setTabelPenitipan(tblModel);
    }  
    
    public void renderTable3() {
        groomingList = groomingDAO.getAllLaporan();
        
        DefaultTableModel tblModel = new DefaultTableModel(new Object[][]{}, headerGrooming) {
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };
        
        Object[] data = new Object[headerGrooming.length];
        int no = 0;
        for (HistoryGrooming historyGrooming : groomingList) {
            no++;
            data[0] = no;
            data[1] = historyGrooming.getIdUser();
            data[2] = historyGrooming.getIdHewan();
            data[3] = historyGrooming.getTimestamp();
            data[4] = historyGrooming.getDate();
            data[5] = historyGrooming.getHarga();
            tblModel.addRow(data);
        }
        
        laporanView.setTabelGrooming(tblModel);
    }  
}
