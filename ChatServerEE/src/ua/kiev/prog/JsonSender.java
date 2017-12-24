package ua.kiev.prog;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class JsonSender {


    public static String toJSON(Object object) {
        Gson gson = new GsonBuilder().create();
        return gson.toJson(object);
    }

    public static Autorization fromJSON(String s) {
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(s, Autorization.class);
    }

    public static int sendJson(String url, Object object) throws IOException {
        URL obj = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) obj.openConnection();

        conn.setRequestMethod("POST");
        conn.setDoOutput(true);

        OutputStream os = conn.getOutputStream();
        try {
            String json = JsonSender.toJSON(object);
            os.write(json.getBytes(StandardCharsets.UTF_8));
            return conn.getResponseCode();
        } finally {
            os.close();
        }
    }
}
