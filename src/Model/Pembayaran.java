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
public class Pembayaran {
    private Integer id;
    private int idUser;
    private int idOrder;
    private String status;
    private User user;

    public Pembayaran(Integer id, int idUser, int idOrder, String status) {
        this.id = id;
        this.idUser = idUser;
        this.idOrder = idOrder;
        this.status = status;
    }
    public Pembayaran(Integer id){
        this.idUser = idUser;
    }
    public Pembayaran(int idUser, int idOrder){
        this.idUser = idUser;
        this.idOrder = idOrder;
    }
    
    public Pembayaran(){}
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idTransaksi) {
        this.idOrder = idTransaksi;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
