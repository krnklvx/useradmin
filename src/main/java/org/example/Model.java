package org.example;

public class Model {
    public static Role Check(String login, String password) throws WrongLoginException, WrongPasswordException {
        if (!isValidLogin(login)) {
            throw new WrongLoginException("Логин может содержать только латинские буквы, цифры и @ . _ -\n");
        }

        if (!isValidPassword(password)) {
            throw new WrongPasswordException("Логин может содержать только латинские буквы, цифры и {}[](),.;&?!_-+\n");
        }

        if (login.equals(Main.admin.login) && password.equals(Main.admin.password)) {
            return Role.ADMIN;
        } else if (login.equals(Main.user.login) && password.equals(Main.user.password)) {
            return Role.USER;
        }
        return null;
    }

    public static boolean isValidLogin(String login) {
        return login.length() >= 20 && login.matches("[a-zA-Z0-9@._-]+");
    }

    public static boolean isValidPassword(String password) {
        return password.length() >= 8 && password.matches("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[{}\\[\\](),.;&?!_\\-+]).{8,}$");
    }

    public static void displayMenu(Role role) {
        switch (role) {
            case ADMIN:
                System.out.println("\n--- ADMIN MENU ---");
                System.out.println("1. File");
                System.out.println("2. Create new user");
                System.out.println("3. Exit");
                break;

            case USER:
                System.out.println("\n--- USER MENU ---");
                System.out.println("1. File");
                System.out.println("2. Get play list");
                System.out.println("3. Exit");
                break;
        }
    }
}
