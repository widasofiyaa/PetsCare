package Controller;

import DAO.ProdukDAO;
import Model.Produk;
import View.ManageProduk;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class ManageProdukController {
    ManageProduk manageProdukView;
    List<Produk> produkList;   
    ProdukDAO produkDAO;
    String[] header;

    public ManageProdukController(ManageProduk manageProdukView) {
        this.manageProdukView = manageProdukView;
        produkDAO = new ProdukDAO();
        header = new String[]{"id", "nama", "harga", "kategori"};
    }
    
    public void renderTable() {
        produkList = produkDAO.getAll();
        
        DefaultTableModel tblModel;
        tblModel = new DefaultTableModel(new Object[][]{}, header) {
            private static final long serialVersionUID = 1L;
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };

        Object[] data = new Object[header.length];
        for (Produk produk : produkList) {
            data[0] = produk.getId();
            data[1] = produk.getNama();
            data[2] = produk.getHarga();
            data[3] = produk.getCategory();
            tblModel.addRow(data);
        }
        
        manageProdukView.setTabelProduk(tblModel);
    }
    
    public void isiField(int row) {
        manageProdukView.idprodukField.setText(String.valueOf(produkList.get(row).getId()));
        manageProdukView.namaprodukField.setText(String.valueOf(produkList.get(row).getNama()));
        manageProdukView.hargaField.setText(String.valueOf(produkList.get(row).getHarga()));
        manageProdukView.kategoriField.setText(String.valueOf(produkList.get(row).getCategory()));
    }
    
    public void insert() {
        Produk produk = new Produk(Integer.parseInt(manageProdukView.idprodukField.getText()), manageProdukView.namaprodukField.getText(), Integer.parseInt(manageProdukView.hargaField.getText()), manageProdukView.kategoriField.getText());
        produkDAO.insert(produk);
    }
    
    public void update(int row) {
        String id = (String.valueOf(produkList.get(row).getId()));
        Produk produk = new Produk(Integer.parseInt(id), manageProdukView.namaprodukField.getText(), Integer.parseInt(manageProdukView.hargaField.getText()), manageProdukView.kategoriField.getText());
        produkDAO.update(produk);
    }
    
    public void delete(int row) {
        String id = (String.valueOf(produkList.get(row).getId()));
        produkDAO.delete(Integer.parseInt(id));
    }
}
