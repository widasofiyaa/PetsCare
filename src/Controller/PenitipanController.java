package Controller;
import DAO.HewanDAO;
import DAO.PenitipanDAO;
import Model.Hewan;
import Model.HistoryPenitipan;
import View.Penitipan;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class PenitipanController {
    Penitipan penitipanView;
    List<Hewan> hewanList;   
    private int idUser;
    HewanDAO hewanDAO;
    PenitipanDAO penitipanDAO;
    String[] header;
    
    public PenitipanController(Penitipan penitipanView, int idUser) {
        this.penitipanView = penitipanView;
        this.idUser = idUser;
        hewanDAO = new HewanDAO(idUser);
        penitipanDAO = new PenitipanDAO(idUser);
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
        
        penitipanView.petTbl.setModel(tblModel);
    }
    
    public void konfirmasi(int idHewan, String namaHewan) {
        String inputLama = penitipanView.lamaField.getText();
        boolean isValid = validasi(inputLama);
        
        if (!isValid) {
            return;
        }
        
        HistoryPenitipan penitipan = new HistoryPenitipan();
        
        int lama = Integer.parseInt(inputLama);
        int harga = lama * 25000;
        
        penitipan.setIdHewan(idHewan);
        penitipan.setLamaPenitipan(lama);
        penitipan.setHarga(lama * 25000);
        
        int n = JOptionPane.showConfirmDialog(
                            penitipanView, String.format("Apakah anda ingin menitipkan %s selama %s dengan biaya %s?", namaHewan, lama, harga),
                            "Konfirmasi",
                            JOptionPane.YES_NO_OPTION);
        
        if (n == JOptionPane.YES_OPTION) {
            penitipanDAO.insert(penitipan);
        }
                
    }
    
    public boolean validasi(String lamaHari) {
        if(lamaHari.equals("")) {
            JOptionPane.showMessageDialog(null, "Mohon isi lama hari.");
            return false;
        }
        
        if(Integer.parseInt(lamaHari) < 1 || Integer.parseInt(lamaHari) > 45) {
            JOptionPane.showMessageDialog(null, "Lama hari minimal 1 hari dan maksimal 45 hari!");
            return false;
        }
        
        return true;
    }
}
