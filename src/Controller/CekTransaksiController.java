/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import DAO.OrderDAO;
import DAO.ProdukDAO;
import Model.Produk;
import Model.CekTransaksi;
import View.CekTransaksiOrder;
import java.util.List;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author wida
 */
public class CekTransaksiController {
    private CekTransaksiOrder cekTransaksiView;
    private List<CekTransaksi> cekTransaksiList;
    private OrderDAO orderDAO;
    private int idUser;
    private String[] cekTransaksiHeader;

    public CekTransaksiController(CekTransaksiOrder cekTransaksiView, int idUser) {
        this.cekTransaksiView = cekTransaksiView;
        this.idUser = idUser;
        orderDAO = new OrderDAO(idUser);
        cekTransaksiHeader = new String[]{"Timestamp","ID Produk","Harga","Status"};
    }
    
    public void renderTable(){
        cekTransaksiList = orderDAO.getAll();
        
        DefaultTableModel cekTransaksiTblModel = new DefaultTableModel(new Object[][]{}, cekTransaksiHeader){
            public boolean isCellEditable(int rowIndex, int columnIndex){
                return false;
            }
        };
        
        Object[] cekTransaksiData = new Object[cekTransaksiHeader.length];
        for(CekTransaksi cekTransaksi : cekTransaksiList){
        cekTransaksiData[0] = cekTransaksi.getTimestamp();
        cekTransaksiData[1] = cekTransaksi.getIdProduk();
        cekTransaksiData[2] = cekTransaksi.getHarga();
        cekTransaksiData[3] = cekTransaksi.getStatus();
        
        cekTransaksiTblModel.addRow(cekTransaksiData);
        }
        
        cekTransaksiView.cekTransaksiTbl.setModel(cekTransaksiTblModel);
        
    }
    
    
}
