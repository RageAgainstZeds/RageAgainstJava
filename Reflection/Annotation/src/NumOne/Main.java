package NumOne;

import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        UnderdogClass under = new UnderdogClass();
        Class<?> cls = under.getClass();

        Method[] meth = cls.getDeclaredMethods();
        for (Method m : meth) {
            if (m.isAnnotationPresent(Test.class)) {
                Test test = m.getAnnotation(Test.class);
                double res = (Double) m.invoke(under, test.a(), test.b());
                System.out.println(res);
            }
        }
    }
}
