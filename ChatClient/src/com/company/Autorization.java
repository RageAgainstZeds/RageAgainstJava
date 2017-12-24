package com.company;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Autorization {
    String login;
    String passwd;

    public Autorization(String login, String passwd) {
        this.login = login;
        this.passwd = passwd;
    }

    public Autorization() {
    }

    public int send(String url) throws IOException {
         return JsonSender.sendJson( url, this);
    }





}
