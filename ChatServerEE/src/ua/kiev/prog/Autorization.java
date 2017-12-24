package ua.kiev.prog;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Autorization extends HttpServlet {
        String login;
        String passwd;

    public Autorization(String login, String passwd) {
        this.login = login;
        this.passwd = passwd;
    }

    public Autorization() {
    }


    public static Autorization fromJSON(String s) {
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(s, Autorization.class);
    }

}
