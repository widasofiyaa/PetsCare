package Model;

import java.util.List;
public class Hewan {
    private Integer id;
    private Integer idUser;
    private String nama;
    private int tahunLahir;
    private String jenis;
    private List<HistoryGrooming> historyGroomingList;
    private List<HistoryPenitipan> historyPenitipanList;
    private User user;

    public Hewan() {
    }

    public Hewan(Integer id) {
        this.id = id;
    }
    
    public Hewan(String nama, int tahunLahir, String jenis) {
        this.nama = nama;
        this.tahunLahir = tahunLahir;
        this.jenis = jenis;
    }

    public Hewan(Integer idUser, String nama, int tahunLahir, String jenis) {
        this.idUser = idUser;
        this.nama = nama;
        this.tahunLahir = tahunLahir;
        this.jenis = jenis;
    }
    
    public Hewan(Integer id, Integer idUser, String nama, int tahunLahir, String jenis) {
        this.id = id;
        this.idUser = idUser;
        this.nama = nama;
        this.tahunLahir = tahunLahir;
        this.jenis = jenis;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getTahunLahir() {
        return tahunLahir;
    }

    public void setTahunLahir(int tahunLahir) {
        this.tahunLahir = tahunLahir;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public List<HistoryGrooming> getHistoryGroomingList() {
        return historyGroomingList;
    }

    public void setHistoryGroomingList(List<HistoryGrooming> historyGroomingList) {
        this.historyGroomingList = historyGroomingList;
    }

    public List<HistoryPenitipan> getHistoryPenitipanList() {
        return historyPenitipanList;
    }

    public void setHistoryPenitipanList(List<HistoryPenitipan> historyPenitipanList) {
        this.historyPenitipanList = historyPenitipanList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
}
