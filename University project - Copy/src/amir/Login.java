package amir;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Login {

    private String name;
    private int fieldcod;
    private String field;
    private String password;

    public void login() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> lines = new ArrayList<>();
        System.out.println("Please enter the name: ");
        String namemach = scanner.nextLine();
        System.out.println("Please enter the Password: ");
        String passwordmach = scanner.nextLine();
        try (BufferedReader read = new BufferedReader(new FileReader("student.txt"))) {
            String line;
            while ((line = read.readLine()) != null) {
                lines.add(line);
            }
            boolean found = false;
            for (int j = 0; j < lines.size(); j++) {
                String ckline = lines.get(j);
                if (ckline.startsWith("Name:")) {
                    this.name = ckline.substring(6).trim();
                    if (name.equalsIgnoreCase(namemach)) {
                        String field2 = lines.get(j + 10).substring(12).trim();
                        this.fieldcod = Integer.parseInt(field2) ;
                        String password1 = lines.get(j + 8);
                        field =  lines.get(j + 6).substring(7).trim();
                        this.password = password1.substring(10).trim();
                        if (password.equalsIgnoreCase(passwordmach)) {
                            found = true;
                        }
                    }
                }
            }
            if (!found) {
                System.out.println("not found Try again");
                System.out.println("1.Did you forget your password?");
                int j = Integer.parseInt(scanner.nextLine());
                if (j == 1) {


                }

            }
            if (field.equalsIgnoreCase("T")){
                Teachermenu menu = new Teachermenu();
                menu.teachermenu(namemach , fieldcod );
            }
            if (field.equalsIgnoreCase("D")){


                Student menu = new Student();
                menu.Menu(namemach , fieldcod);

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
