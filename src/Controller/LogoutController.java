/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.Dashboard;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author wida
 */
public class LogoutController{
    Dashboard DashboardView;
    public void confirmLogout(ActionEvent ae){
        DashboardView.dispose();
    }

    //@Override
    public void actionPerformed() {
        //Object source = ae.getSource();
        
        DashboardView.dispose();
    }
}
