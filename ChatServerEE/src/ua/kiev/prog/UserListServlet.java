package ua.kiev.prog;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;

public class UserListServlet extends HttpServlet {
    private static HashSet<User> usrList = new HashSet<>();
    private final Gson gson;

    private UserListServlet() {gson = new GsonBuilder().create();}

    public synchronized void addUser(User user) {
        usrList.add(user);
    }

    public static HashSet<User> getInstance() {
        return usrList;
    }

    public synchronized String toJSON() {
        return gson.toJson(usrList);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        byte[] buf = AddServlet.requestBodyToArray(req);
        String bufStr = new String(buf, StandardCharsets.UTF_8);

        User usr = User.fromJSON(bufStr);
        if (usr != null)
            usrList.add(usr);
        else
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String json = toJSON();
        if (json != null) {
            OutputStream os = resp.getOutputStream();
            byte[] buf = json.getBytes(StandardCharsets.UTF_8);
            os.write(buf);
        }
    }
}
