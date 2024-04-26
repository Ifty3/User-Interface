import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class Temp {
    private String userName, email, password;
    private String searchName, searchPass, searchEmail;

    public void login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("----------LOGIN---------");
        System.out.println("Enter Your User Name :: ");
        searchName = scanner.nextLine();
        System.out.println("Enter Your Password :: ");
        searchPass = scanner.nextLine();

        try {
            File file = new File("loginData.txt");
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] data = line.split("\\*");
                userName = data[0];
                email = data[1];
                password = data[2];
                if (userName.equals(searchName)) {
                    if (password.equals(searchPass)) {
                        System.out.println("\nAccount Login Successful...!");
                        System.out.println("Username :: " + userName);
                        System.out.println("Email :: " + email);
                    } else {
                        System.out.println("Password is Incorrect...!");
                    }
                }
            }
            fileScanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void signUp() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter Your User Name :: ");
        userName = scanner.nextLine();
        System.out.println("Enter Your Email Address :: ");
        email = scanner.nextLine();
        System.out.println("Enter Your Password :: ");
        password = scanner.nextLine();

        try {
            FileWriter fileWriter = new FileWriter("loginData.txt", true);
            fileWriter.write(userName + "*" + email + "*" + password + "\n");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void forgot() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter Your UserName :: ");
        searchName = scanner.nextLine();
        System.out.println("\nEnter Your Email Address :: ");
        searchEmail = scanner.nextLine();

        try {
            File file = new File("loginData.txt");
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] data = line.split("\\*");
                userName = data[0];
                email = data[1];
                password = data[2];
                if (userName.equals(searchName)) {
                    if (email.equals(searchEmail)) {
                        System.out.println("\nAccount Found...!");
                        System.out.println("Your Password :: " + password);
                    } else {
                        System.out.println("Not found...!");
                    }
                } else {
                    System.out.println("\nNot found...!");
                }
            }
            fileScanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Temp obj = new Temp();

        char choice;
        System.out.println("\n1- Login");
        System.out.println("2- Sign-Up");
        System.out.println("3- Forgot Password");
        System.out.println("4- Exit");
        System.out.println("Enter Your Choice :: ");
        choice = scanner.next().charAt(0);

        switch (choice) {
            case '1':
                scanner.nextLine();
                obj.login();
                break;
            case '2':
                scanner.nextLine();
                obj.signUp();
                break;
            case '3':
                scanner.nextLine();
                obj.forgot();
                break;
            case '4':
                System.exit(0);
                break;
            default:
                System.out.println("Invalid Selection...!");
        }
    }
}
