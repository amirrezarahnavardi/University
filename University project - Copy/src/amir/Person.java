package amir;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Person{
    Scanner scanner = new Scanner(System.in);
    private static final long serialVersionUID = 1L;

    public String name;
    public int age;
    public String gender;
    public int id;
    public int phone;
    public String email;
    private String field;
    public String datebirth;
    public String password;
    public String jobposition;
    public int  fieldcod;
    public String statuse;
    Person(String name, int age, String gender, int id, int phone, String email, String field, String datebirth, String password , String jobposition , int filedcod , String status) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.id = id;
        this.phone = phone;
        this.email = email;
        this.field = field;
        this.datebirth = datebirth;
        this.password = password;
        this.jobposition = jobposition;
        this.fieldcod =  filedcod ;
        this.statuse = status ;

    }

   public Person() {

    }

    public void Takingspecifications() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the name ");
        this.name = scanner.nextLine();

        System.out.println("Please enter the age ");
        this.age = Integer.parseInt(scanner.nextLine());

        System.out.println("Please enter the gender");
        this.gender = scanner.nextLine();

        System.out.println("Please enter the id");
        this.id = Integer.parseInt(scanner.nextLine());

        System.out.println("Please enter the phone ");
        this.phone = Integer.parseInt(scanner.nextLine());

        System.out.println("Please enter the email ");
        this.email = scanner.nextLine();

        System.out.println("Please enter the field ");
        this.field = scanner.nextLine();

        System.out.println("Please enter the DateBirth ");
        this.datebirth = scanner.nextLine();

        System.out.println("Please enter the password ");
        this.password = scanner.nextLine();

        System.out.println("Enter the job position    ");
        this.jobposition = scanner.nextLine();

        System.out.println("Field code : ");
        this.fieldcod = Integer.parseInt(scanner.nextLine());

        System.out.println("Please enter the status ");
        this.statuse = scanner.nextLine();

        Savespecifications();
    }

    public void Savespecifications() {
        ArrayList<Person> persons = new ArrayList<>();
        persons.add(new Person(name, age, gender, id, phone, email, field, datebirth, password , jobposition , fieldcod, statuse ));
        try {
            FileWriter writer = new FileWriter("student.txt", true);
            for (Person person : persons) {
                writer.write("Name: " + person.name + "\n");
                writer.write("Age: " + person.age + "\n");
                writer.write("Gender: " + person.gender + "\n");
                writer.write("ID: " + person.id + "\n");
                writer.write("Phone: " + person.phone + "\n");
                writer.write("Email: " + person.email + "\n");
                writer.write("Field: " + person.field + "\n");
                writer.write("Date of Birth: " + person.datebirth + "\n");
                writer.write("Password: " + person.password + "\n");
                writer.write("Job position:" + person.jobposition + "\n");
                writer.write("Field code: " + person.fieldcod + "\n");
                writer.write("Status: " + person.statuse  + "\n");
                writer.write("--------------------------\n");
            }
            writer.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public void Changespecifications() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> chengs = new ArrayList<>();
        System.out.println("Please enter the name ");
        String namecheng = scanner.nextLine();
        boolean found = false;
        try (BufferedReader read = new BufferedReader(new FileReader("student.txt"))) {
            String chengeline;
            while ((chengeline = read.readLine()) != null) {
                chengs.add(chengeline);
            }

            for (int j = 0; j < chengs.size(); j++) {
                String cheng = chengs.get(j);
                if (cheng.startsWith("Name:")) {
                    this.name = cheng.substring(6).trim();
                    if (name.equalsIgnoreCase(namecheng)) {
                        System.out.println("new age");
                        this.age = Integer.parseInt(scanner.nextLine());
                        System.out.println("new Phone");
                        this.phone = Integer.parseInt(scanner.nextLine());
                        System.out.println("new email");
                        this.email = scanner.nextLine();
                        System.out.println("new Deta Brith");
                        this.datebirth = scanner.nextLine();
                        System.out.println("new Password");
                        this.password = scanner.nextLine();
                        chengs.set(j + 1, "Age:" + " " + this.age);

                        chengs.set(j + 4, "Phone:" + " " + this.phone);
                        chengs.set(j + 5, "Email:" + " " + this.email);

                        chengs.set(j + 7, "Date:" + " " + this.datebirth);
                        chengs.set(j + 8, "Password:" + " " + this.password);
                        found = true;
                        break;
                    }
                }
            }
            if (found == false) {
                System.out.println("not found Try again");
                new Person();
                System.exit(0);
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("student.txt"))) {
                for (String cheng : chengs) {
                    writer.write(cheng);
                    writer.newLine();
                }
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }



    public void ChangePassword() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> lines = new ArrayList<>();
        System.out.println("Please enter the name: ");
        String namemach = scanner.nextLine();
        System.out.println("Please enter the ID: ");
        int idmach = Integer.parseInt(scanner.nextLine());
        try (BufferedReader read = new BufferedReader(new FileReader("student.txt"))) {
            String line;
            while ((line = read.readLine()) != null) {
                lines.add(line);
            } read.close();
            boolean found = false;

            for (int j = 0; j < lines.size(); j++) {
                String ckline = lines.get(j);
                if (ckline.startsWith("Name:")) {
                    this.name = ckline.substring(6).trim();
                    if (name.equalsIgnoreCase(namemach)) {
                        String id1 = lines.get(j + 3);
                        id1 = id1.substring(4).trim();
                        this.id = Integer.parseInt(id1);
                        if (id == idmach) {
                            System.out.println("new password");

                            this.password = scanner.nextLine();

                            lines.set(j + 8, "Password:" + " " + this.password);
                            found = true;
                        }
                    }
                }
            }
            if (!found) {
                System.out.println("not found Try again");
                System.exit(0);
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("student.txt"))) {
                for (String s : lines) {
                    writer.write(s);
                    writer.newLine();
                }
                writer.close();
                System.out.println("Changes have been made.");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
