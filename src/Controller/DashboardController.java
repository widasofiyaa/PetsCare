/*
PENDAHULUAN
Code ini bertujuan untuk menjembatani antara Dashboard view dan user model.
Dalam code ini akan mengambil nama username dari database, lalu 
menampilkannya di view. Dalam controller terdapat contruktor DashboardController 
untuk form dan username. Controller ini akan merequest ke model dan ditampilkan 
ke view Dashboard
*/
package Controller; // Package

import View.Dashboard; // Mengimport View yaitu Dashboard.java
/*
Class dashboardController yang memiliki atribut Dashboard 
bertipe data form. Dalam class ini terdapat sebuah construktor yaitu 
DashboardController. Kemudian ada satu metode yaitu initializatio.
*/

/*
Data yang diolah pada code ini yaitu data user berupa username dari user.
*/
public class DashboardController { 
    Dashboard form; 
    /*
    Construktor DashboardController akan membentuk form yang ada di Dashboard.
    Contruktor ini memiliki sebuah parameter yaitu Dashboard. Adanya contruktor
    ini maka dashboard bisa ada di view dan dapat dilihat oleh user. 
    */
    public DashboardController(Dashboard form) {
        this.form = form;
    }
    /*
    Code dibawah merupakan metode dari class DashboardController ini.
    Metode ini memiliki satu parameter input yaitu username bertipe data string
    Input username akan didapat dari data user yang diinputkan saat registrasi.
    Metode ini akan meminta username dari database melalui model lalu akan di-
    tampilkan di Dashboard view pada saat user ada di dashboard.
    */
    public void initialization(String username) {
        //Mengatur form welcome untuk ditampilkan di view
        form.welcomeLabel.setText("Selamat datang, " + username  + "!");
    }
}
