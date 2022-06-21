/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author wida
 */
import java.util.Date;
public class HistoryOrder {
    private Integer id;
    private String timestamp;
    private int kuantiti;
    private int harga;
    private int idProduk;
    private int idUser;
    
    public HistoryOrder(){
    }
    public HistoryOrder(Integer id){
        this.id = id;
    }
    public HistoryOrder(Integer id, String timestamp, int kuantiti, int harga) {
        this.id = id;
        this.timestamp = timestamp;
        this.kuantiti = kuantiti;
        this.harga = harga;
    }
    
    public HistoryOrder(String timestamp, int kuantiti, int harga, int idProduk, int idUser){
        this.timestamp = timestamp;
        this.kuantiti = kuantiti;
        this.harga = harga;
        this.idProduk = idProduk;
        this.idUser = idUser;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public int getKuantiti() {
        return kuantiti;
    }

    public void setKuantiti(int kuantiti) {
        this.kuantiti = kuantiti;
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
    
    
}
