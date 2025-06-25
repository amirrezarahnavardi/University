package amir;

import java.util.Scanner;


public class Teachermenu {




        public void teachermenu (String namemach , int  filed){
            System.out.println("welcome  " + namemach);
            System.out.println("1.Choosing a class");
            Scanner scanner = new Scanner(System.in);
            int i = Integer.parseInt(scanner.nextLine());

            if (i == 1){
                Courses courseselection = new Courses();
                courseselection.courseselection(namemach , filed);
            }
        }
    }


