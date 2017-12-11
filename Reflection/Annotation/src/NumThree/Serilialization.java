package NumThree;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.security.InvalidParameterException;

public class Serilialization {
    public static String serialize(Object Obj) throws IllegalAccessException {
        Class cls = Obj.getClass();
        StringBuilder sb = new StringBuilder();

        Field[] field = cls.getDeclaredFields();
        for (Field f : field) {
            if (!f.isAnnotationPresent(Save.class)) {
                continue;
            }
            if (Modifier.isPrivate(f.getModifiers())) {
                f.setAccessible(true);
            }

            sb.append(f.getName() + "=");

            if (f.getType() == int.class) {
                sb.append(f.getInt(Obj));
            } else
            if (f.getType() == String.class) {
                sb.append((String)f.get(Obj));
            } else
            if (f.getType() == double.class) {
                sb.append(f.getDouble(Obj));
            }
            sb.append(";");
        }
        return sb.toString();
    }
    public static<T> T deserialize(String s, Class<T> cls) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        T res = (T)cls.newInstance();
        String[] pairs = s.split(";");

        for (String pair : pairs) {
            String[] st = pair.split("=");
            if (st.length != 2)
                throw new InvalidParameterException(s);
            String name = st[0];
            String val = st[1];

            Field f  = cls.getDeclaredField(name);
            if (Modifier.isPrivate(f.getModifiers()))
                f.setAccessible(true);
            if (f.isAnnotationPresent(Save.class)) {
                if (f.getType() == int.class) {
                    f.set(res, Integer.parseInt(val));
                }
                else if (f.getType() == double.class) {
                    f.set(res, Double.parseDouble(val));
                }
                else if (f.getType() == String.class) {
                    f.set(res, val);
                }
            }
        }
        return res;
    }
}
