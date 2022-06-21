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
public class CartProduk {
    private Integer id;
    private Date timestamp;
    private int harga;
    private int idProduk;
    private int idUser;
    private String date;
    private int kuantiti;
    private User user;
    private List<CartProduk> cekProdukList;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<CartProduk> getCekProdukList() {
        return cekProdukList;
    }

    public void setCekProdukList(List<CartProduk> cekProdukList) {
        this.cekProdukList = cekProdukList;
    }
    
    public int getKuantiti() {
        return kuantiti;
    }

    public void setKuantiti(int kuantiti) {
        this.kuantiti = kuantiti;
    }
    public CartProduk(){}
    public CartProduk(Integer id){
        this.id = id;
    }
    public CartProduk(Integer id, Integer kuantiti){
        this.id = id;
        this.kuantiti= kuantiti;
    }
    public CartProduk(Date timestamp, int idProduk, int harga, String status){
        this.timestamp = timestamp;
        this.idProduk = idProduk;
        this.harga = harga;
    };
    public CartProduk(Integer id, Date timestamp, int harga, int idProduk, int idUser, String date, String status) {
        this.id = id;
        this.timestamp = timestamp;
        this.harga = harga;
        this.idProduk = idProduk;
        this.idUser = idUser;
        this.date = date;
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
    
    
}
