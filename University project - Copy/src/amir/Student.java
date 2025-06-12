package amir;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Student extends Person {
    public void Menu(String namemach, int fieldcod) {
        System.out.println("welcom " + namemach);
        System.out.println("1.Unit selection");

        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        if (i == 1) {
        Unitselection(fieldcod);

        }
    }

    public void Unitselection(int fieldcod) {
        ArrayList<String> lines = new ArrayList<>();
        try(BufferedReader read = new BufferedReader(new FileReader("CourseStudent.txt"))){
            String line;
            while ((line = read.readLine()) != null) {
                lines.add(line);

            }
            boolean found = false;
            for (int i = 0; i < lines.size(); i++) {
                String s = lines.get(i);

                if (s.startsWith("Field code: ")) {

                    String field3 = s.substring(12).trim();
                    int fieldcod2 = Integer.parseInt(field3);

                    if (fieldcod == fieldcod2) {
                        found = true;
                        for (int k = Math.max(0, i - 6); k <= i; k++) {
                            System.out.println(lines.get(k));
                        }

                       System.out.println(lines.get(i+1));
                        System.out.println(lines.get(i+2));
                        System.out.println(lines.get(i+3));
                    }

                }

            }read.close();
            if (!found) {
                System.out.println("There is no class to display.");
            }
            System.out.println("Please enter the name of the desired class");
            String nameclass = scanner.nextLine();
            for (int i = 0; i < lines.size(); i++) {
                String s = lines.get(i);
                if (s.startsWith("Name class: ")) {
                    String classname = s.substring(11).trim();
                    if (classname.equals(nameclass)) {
                        lines.set(i+1, "Capacity:" + (fieldcod - 1));
                    }




                }
            }
           try  (BufferedWriter writer = new BufferedWriter(new FileWriter("CourseStudent.txt"))) {
               for (int k = 0; k < lines.size(); k++) {
                   writer.write(lines.get(k));
                   writer.newLine();
               }
           }
        }catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }


}



