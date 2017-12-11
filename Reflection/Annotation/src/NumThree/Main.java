package NumThree;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchFieldException, ClassNotFoundException {
        UnderDogClass under = new UnderDogClass(14, "Hail!", 19.39, "Text Me!");
        String str = Serilialization.serialize(under);
        System.out.println("Serilialized --> " + "\n" + str);

        under = Serilialization.deserialize(str, UnderDogClass.class);
        System.out.println("Desirialization --> " + under.toString());
    }
}
