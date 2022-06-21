/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.util.Date;
import java.util.List;

/**
 *
 * @author wida
 */
public class CekTransaksi {
    private Integer id;
    private Date timestamp;
    private int harga;
    private int idProduk;
    private int idUser;
    private String date;
    private int kuantiti;
    private String status = "diproses";
    private List<CekTransaksi> cekTransaksiList;
    private User user;

    public CekTransaksi(String string, int aInt, int aInt0, int aInt1, int aInt2, String string0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<CekTransaksi> getCekTransaksiList() {
        return cekTransaksiList;
    }

    public void setCekTransaksiList(List<CekTransaksi> cekTransaksiList) {
        this.cekTransaksiList = cekTransaksiList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getKuantiti() {
        return kuantiti;
    }

    public void setKuantiti(int kuantiti) {
        this.kuantiti = kuantiti;
    }
    public CekTransaksi(){}
    public CekTransaksi(Integer id){
        this.id = id;
    }
    public CekTransaksi(Integer id, Integer kuantiti){
        this.id = id;
        this.kuantiti= kuantiti;
    }
    public CekTransaksi(Date timestamp, int idProduk, int harga, String status){
        this.timestamp = timestamp;
        this.idProduk = idProduk;
        this.harga = harga;
        this.status = status;
    };
    public CekTransaksi(Integer id, Date timestamp, int harga, int idProduk, int idUser, String date, String status) {
        this.id = id;
        this.timestamp = timestamp;
        this.harga = harga;
        this.idProduk = idProduk;
        this.idUser = idUser;
        this.date = date;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public int getIdProduk() {
        return idProduk;
    }

    public void setIdProduk(int idProduk) {
        this.idProduk = idProduk;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
