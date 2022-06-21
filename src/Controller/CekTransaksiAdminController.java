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
import Model.CekTransaksi;
import java.util.List;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Kel4
 */
public class CekTransaksiAdminController {
    private View.CekTransaksi cekTransaksiView;
    private List<CekTransaksi> cekTransaksiList;
    private OrderDAO orderDAO;
    private String[] cekTransaksiHeader;


    public CekTransaksiAdminController(View.CekTransaksi cekTransaksiView) {
        this.cekTransaksiView = cekTransaksiView;
        orderDAO = new OrderDAO();
        cekTransaksiHeader = new String[]{"No","ID Pembeli","ID Produk","Timestamp","Kuantiti","Harga","Status"};
    }
    
    public void renderTable(){
        cekTransaksiList = orderDAO.getAllLaporan();
        
        DefaultTableModel cekTransaksiTblModel = new DefaultTableModel(new Object[][]{}, cekTransaksiHeader){
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex){
                return false;
            }
        };
        
        Object[] cekTransaksiData = new Object[cekTransaksiHeader.length];
        int no = 0;
        for(CekTransaksi cekTransaksi : cekTransaksiList){
            no++;
            cekTransaksiData[0] = no;
            cekTransaksiData[1] = cekTransaksi.getIdUser();
            cekTransaksiData[2] = cekTransaksi.getIdProduk();
            cekTransaksiData[3] = cekTransaksi.getTimestamp();
            cekTransaksiData[4] = cekTransaksi.getKuantiti();
            cekTransaksiData[5] = cekTransaksi.getHarga();
            cekTransaksiData[6] = cekTransaksi.getStatus();
            cekTransaksiTblModel.addRow(cekTransaksiData);
        }
        
        cekTransaksiView.tabelTransaksi.setModel(cekTransaksiTblModel);
        
    }
}
