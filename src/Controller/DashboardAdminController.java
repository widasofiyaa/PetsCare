package Controller; // Package

import View.DashboardAdmin; 

public class DashboardAdminController { 
    DashboardAdmin form; 
  
    public DashboardAdminController(DashboardAdmin form) {
        this.form = form;
    }
   
    public void initialization(String username) {
        //Mengatur form welcome untuk ditampilkan di view
        form.setWelcomeLabel(username);
    }
}
