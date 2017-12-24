package ua.kiev.prog;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        byte[] buf = AddServlet.requestBodyToArray(request);
        String bufStr = new String(buf, StandardCharsets.UTF_8);

        Autorization register = Autorization.fromJSON(bufStr);

        if (LoginServlet.getUsers().contains(register.login.toLowerCase())) {
            response.setStatus(3);
        } else {
            LoginServlet.setUserPass(register.login.toLowerCase(), register.passwd);
            response.setStatus(4);
        }
    }
}
