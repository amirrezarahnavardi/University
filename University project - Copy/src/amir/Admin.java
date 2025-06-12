package amir;
import java.io.*;
import java.util.*;
import java.io.FileReader;
public class Admin {

    public void Showlist(){
        List<String> studentList=new ArrayList<>();

        try (BufferedReader read = new BufferedReader(new FileReader("student.txt"))){
            String studentListline;
            while ((studentListline = read.readLine()) != null) {

                    System.out.println(studentListline);

            }read.close();
        }
        catch (IOException e){
          e.printStackTrace();
        }
    }

    public void Search() {
        List<String> lines = new ArrayList<>();
        System.out.println("please enter the name of the student");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        try (BufferedReader read = new BufferedReader(new FileReader("student.txt"))) {
            String line;
            while ((line = read.readLine()) != null) {
                lines.add(line);
            }
            read.close();
            boolean found = false;
            for (int i = 0; i < lines.size(); i++) {
                String name1 = lines.get(i);
                if (name1.startsWith("Name: ")) {
                    name1 = name1.substring(6).trim();
                    if (name1.equals(name)) {
                        found = true;
                        for (int k = 0; k < 12; k++) {
                            System.out.println(lines.get(i + k));
                        }
                        break;

                    }
                }

            }
            if (!found) {
                System.out.println("Student not found");
                System.out.println("please enter the id of the student");
                int id = Integer.parseInt(scanner.nextLine());
                for (int i = 0; i < lines.size(); i++) {
                    String id1 = lines.get(i);
                    if (id1.startsWith("ID:")) {
                        id1 = id1.substring(4).trim();
                        int id2 = Integer.parseInt(id1);
                        if (id == id2) {
                            found = true;
                            System.out.println(lines.get(i - 3));
                            System.out.println(lines.get(i - 2));
                            System.out.println(lines.get(i - 1));
                            for (int k = 0; k < 8; k++) {
                                System.out.println(lines.get(i + k));
                            }

                        }
                    }

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }



