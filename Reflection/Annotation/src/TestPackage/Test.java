

public class Test {
    public static void main(String[] args) {
        String str = "%";
        char[] crList = str.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (char c : crList) {
            sb.append(Integer.toBinaryString((int) c));
        }
        System.out.println(sb.toString());
    }

}
