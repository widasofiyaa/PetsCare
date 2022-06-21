package Controller;

import DAO.GroomingDAO;
import DAO.HewanDAO;
import Model.Hewan;
import Model.HistoryGrooming;
import View.Grooming;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class GroomingController {
    Grooming groomingView;
    List<Hewan> hewanList;   
    private int idUser;
    HewanDAO hewanDAO;
    GroomingDAO groomingDAO;
    String[] header;  
    
    public GroomingController(Grooming groomingView, int idUser) {
        this.groomingView = groomingView;
        this.idUser = idUser;
        hewanDAO = new HewanDAO(idUser);
        groomingDAO = new GroomingDAO(idUser);
        header = new String[]{"Id", "Nama"};
    }
    
    public void renderTable() {
        hewanList = hewanDAO.getAll();
        
        DefaultTableModel tblModel = new DefaultTableModel(new Object[][]{}, header) {
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };

        Object[] data = new Object[header.length];
        for (Hewan hewan : hewanList) {
            data[0] = hewan.getId();
            data[1] = hewan.getNama();
            tblModel.addRow(data);
        }
        
        groomingView.petTbl.setModel(tblModel);
    }
    
    public void konfirmasi(int idHewan, String namaHewan) {        
        HistoryGrooming grooming = new HistoryGrooming();
        
        int jam = (Integer) groomingView.jamSpinner.getValue();
        int menit = (Integer) groomingView.menitSpinner.getValue();
        int harga = 50000;
        
        LocalDate lt = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = lt.format(formatter);
        date = date + " " + jam + ":" + menit + ":00";
        grooming.setIdHewan(idHewan);
        grooming.setDate(date);
        grooming.setHarga(harga);
        
        int n = JOptionPane.showConfirmDialog(
                            groomingView, String.format("Apakah anda ingin melakukan grooming untuk hewan dengan nama ' %s ' pada waktu %s dengan biaya %s?", namaHewan, date, harga),
                            "An Inane Question",
                            JOptionPane.YES_NO_OPTION);
        
        if (n == JOptionPane.YES_OPTION) {
            groomingDAO.insert(grooming);
        }
                
    }
}
