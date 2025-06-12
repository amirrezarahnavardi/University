package amir;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Courses extends Department {

    public void courseselection(String name, int fieldcod) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<String> lines = new ArrayList<>();
        try (BufferedReader read = new BufferedReader(new FileReader("Course.txt"))) {
            String line;
            while ((line = read.readLine()) != null) {
                lines.add(line);
            }

            boolean found = false;
            for (int i = 0; i < lines.size(); i++) {
                String s = lines.get(i);

                if (s.startsWith("Field code:")) {

                    String field3 = s.substring(12).trim();
                   int fieldcod2 = Integer.parseInt(field3);

                    if (this.fieldcod == fieldcod2) {
                        found = true;

                        for (int k = i; k >= i-6 && k>=0 ; k--) {
                            System.out.println(lines.get(k));

                        }
                        System.out.println(lines.get(i+1));
                        System.out.println(lines.get(i+2));
                    }
                }
            }read.close();
            System.out.println("Please enter the name of the desired class");
            nameclass = scanner.nextLine();
            for (int i = 0; i < lines.size(); i++) {
                String s = lines.get(i);
                if (s.startsWith("Name class: ")) {
                    String classname = s.substring(12).trim();
                    if (classname.equals(nameclass)) {
                        try (BufferedWriter writer = new BufferedWriter(new FileWriter("CourseStudent.txt", true))) {
                            for (int k = i ;  k < i+8 ; k++) {
                                writer.write(lines.get(k));
                                writer.newLine();
                            }
                            writer.write("Name Teacher: " + classname);
                            writer.newLine();
                            writer.write("--------------------------");
                            writer.newLine();

                        }
                    }

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void GreateClass(){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate today = null;
        LocalDate today1 = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the name of class ");
        this.nameclass = scanner.nextLine();

        System.out.println("Please enter the Capacity ");
        this.exam = Integer.parseInt(scanner.nextLine());

        System.out.println("Please enter the field ");
        this.field = scanner.nextLine();

        System.out.println("Please enter the Grade ");
        this.grade = scanner.nextLine();


        System.out.println("Please enter the Number of units ");
        int number = Integer.parseInt(scanner.nextLine());

        while (today==null) {
            System.out.println("Please enter the start date of classes yyyy/MM/dd ");
            try {
                today = LocalDate.parse(scanner.nextLine(), formatter);
            } catch (DateTimeParseException e) {

            }
        }



        while (today1==null){
            System.out.println("Please enter the end date of classes  yyyy/MM/dd  ");
            try{
                today1 = LocalDate.parse(scanner.nextLine(), formatter);
            }  catch (DateTimeParseException  e) {
            }

        }



        System.out.println("Field code : ");
        this.fieldcod = Integer.parseInt(scanner.nextLine());

        try {
            FileWriter writer = new FileWriter("Course.txt" , true );

            writer.write("Name class: " + nameclass  + "\n");
            writer.write("Capacity: "  +  exam  + "\n");
            writer.write("Field: "  +  field + "\n");
            writer.write("Grade: "  +  grade + "\n");
            writer.write("Start date Class: "  +  today + "\n");
            writer.write("End date Class: "  +  today1 + "\n");
            writer.write("Field code: "  +  fieldcod + "\n");
            writer.write("Number of units : "  +  number + "\n");
            writer.write("-----------------------------");
            writer.write("\n");


            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


