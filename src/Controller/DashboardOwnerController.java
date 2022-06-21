package Controller; // Package

import View.DashboardOwner; 

public class DashboardOwnerController { 
    DashboardOwner form; 
    
    public DashboardOwnerController(DashboardOwner form) {
        this.form = form;
    }
    
    
    public void initialization(String username) {
        form.setWelcomeLabel(username);
    }
}
