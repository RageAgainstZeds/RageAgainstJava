package com.company;

import java.io.IOException;
import java.util.Scanner;

public class RunAutorization {

    private String login;
    private String passwd;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    Scanner scanner = new Scanner(System.in);

    public void checkUser() throws IOException {
        while (true) {
            System.out.println("Enter your login: ");
            login = scanner.nextLine();
            System.out.println("Enter your password: ");
            passwd = scanner.nextLine();

            Autorization autorization = new Autorization(login, passwd);
            int valid = autorization.send(Utils.getURL() + "/login");

            //System.err.println(valid);

            if (valid == 1) {
                Thread th = new Thread(new GetThread());
                th.setDaemon(true);
                th.start();
                break;
            } else {
                System.out.println("Login or password incorrect or doesn't exist");
                System.out.println("Do You have account? y/n");
                String registerCheck = scanner.nextLine();
                if (registerCheck.equals("n")) {
                    Boolean reg = false;
                    while (reg == false) {
                        System.out.println("Create new account");
                        System.out.println("Enter new login: ");
                        login = scanner.nextLine();
                        System.out.println("Enter new password: ");
                        passwd = scanner.nextLine();

                        Autorization register = new Autorization(login, passwd);
                        int regData = register.send(Utils.getURL() + "/reg");
                        if (regData==4) {
                            System.out.println("Registration complete. Sign in using your login and password");
                            reg = true;
                        } else if (regData==3) {
                            System.out.println("Login already exist! Try new on.");
                        }
                    }
                } else if (registerCheck.equals("y")) {
                    System.out.println("Try again");
                }
            }
        }
    }

}
