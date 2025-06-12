package amir;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.io.*;
public class Department extends  University {
Scanner scanner = new Scanner(System.in);
    public void Menu(){
        System.out.println("Unit presentation :\n");
        System.out.println("1. Create a new class\n2. Class extension");
        System.out.println("3. Delete a class");
        int choice = scanner.nextInt();
        if (choice == 3){
            Deleteclass();
        }
        if (choice == 1){
            Courses courseselection = new Courses();
            courseselection.GreateClass();
        }




    }
        public void Deleteclass(){
            Scanner scanner = new Scanner(System.in);
            ArrayList<String> lines = new ArrayList<>();
            System.out.println("Please enter the name of class ");
            this.nameclass = scanner.nextLine();

            try (BufferedReader read = new BufferedReader(new FileReader("Course.txt"))) {
                String chengeline;
                while ((chengeline = read.readLine()) != null) {
                    lines.add(chengeline);
                }
                boolean found = false;
                for (int j = 0; j < lines.size(); j++) {
                    String line = lines.get(j);
                    if (line.startsWith("Name class:")) {
                    String classname = line.substring(13).trim();
                    if (classname.equals(this.nameclass)) {
                        found = true;
                        lines.subList(j, j+8).clear();
                        break;
                    }
                    }
                }

                read.close();
                if (!found) {
                    System.out.println("Class not found");
                    new Department();
                }

                try(BufferedWriter writer = new BufferedWriter(new FileWriter("Course.txt" ))) {
                    for (String s : lines) {
                        writer.write(s);
                        writer.newLine();
                    }
                    writer.close();
                }catch (IOException e) {
                    throw new RuntimeException(e);
                }

                if (found) {
                    System.out.println("Class is deleta ");
                    Menu();
                }

            }catch (IOException e) {
                throw new RuntimeException(e);
            }

        }


    }

