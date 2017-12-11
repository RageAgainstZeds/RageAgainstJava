package NumTwo;

import java.lang.reflect.*;


public class Main {
    public static void main(String[] args) {
        Container con = new Container();
        Class<?> cls = con.getClass();

        if (!cls.isAnnotationPresent(SaveTo.class)) {
            System.out.println("Error!");
            return;
        }

        SaveTo st = cls.getAnnotation(SaveTo.class);
        String path= st.path();
        Method[] mtd = cls.getDeclaredMethods();

        for (Method met : mtd) {
            if (cls.isAnnotationPresent(SaveTo.class)) {
                try {
                    met.invoke(con, path);
                    break;
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Complete!");





    }
}
