package NumTwo;


import java.io.FileWriter;
import java.io.IOException;

@SaveTo(path = "Z:\\Courses_JAVA\\src\\reflex\\one.txt")
public class Container {
    String str = "Say Hello!";

    @Saver
    public void save(String path) {
        try (FileWriter fw = new FileWriter(path)) {
            fw.write(str);
        } catch (IOException e) {
            e.getMessage();
        }
    }
}
