package amir;


public class Main {
    public static void main(String[] args) {
     int i =4;


     if ( i == 1) {




     }
     if (i == 2) {
         Admin admin = new Admin();
         admin.Search();
     }
     if (i == 3) {
         Department department = new Department();
         department.Menu();

     }

     if (i == 4) {
         Login login = new Login();
         login.login();
     }

    }
}