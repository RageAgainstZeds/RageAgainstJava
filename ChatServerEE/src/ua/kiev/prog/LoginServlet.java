package ua.kiev.prog;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.*;

public class LoginServlet extends javax.servlet.http.HttpServlet {

    private static HashMap<String, String> userPass = new HashMap<String, String>() {{ put("admin", "admin");}};
    private static Set<String> users = userPass.keySet();

    public static void setUserPass(String login, String passwd) {
        LoginServlet.userPass.put(login, passwd);
    }

    public static HashMap<String, String> getUserPass() {
        return userPass;
    }

    public static Set<String> getUsers() {
        return users;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        byte[] buf = AddServlet.requestBodyToArray(request);
        String bufStr = new String(buf, StandardCharsets.UTF_8);

        Autorization valid = Autorization.fromJSON(bufStr);
        String login = valid.login;
        String passwd = valid.passwd;

        if (users.contains(login) && userPass.get(login).equals(passwd)) {
            HttpSession session = request.getSession(true);
            session.setAttribute("user_login", login);
            response.setStatus(1);
        } else {
            response.setStatus(0);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String a = request.getParameter("a");
        HttpSession session = request.getSession(false);

        if ("exit".equals(a) && (session != null))
            session.removeAttribute("user_login");
    }
}
