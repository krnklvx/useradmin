package org.example;

import java.util.Scanner;

public class Main {
    static User admin = new User("sawosiiiiiiiit4rt@gmail", "12wwwreeweweew.",Role.ADMIN);
    static User user = new User("qwerty232@gmail", "12w5.eeweweew",Role.USER);



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String login;
        String password;
        while (true) {
            System.out.print("Введите логин: ");
            login = scanner.nextLine();

            if (login.equalsIgnoreCase("exit")) {
                System.out.println("всё");
                break;
            }

            System.out.print("Введите пароль: ");
            password = scanner.nextLine();

            try {
                Role role = Model.Check(login, password);

                if (role != null) {
                    Model.displayMenu(role);
                } else {
                    System.out.println("Incorrect login or password, try again!\n");
                }

            } catch (WrongLoginException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (WrongPasswordException e) {
                System.out.println("Error: " + e.getMessage());
            }

        }

        scanner.close();
    }
}