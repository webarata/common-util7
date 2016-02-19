package link.arata.common.util;

public class Test {
    public static void main(String... args) {
        try {
            Integer.parseInt("1,000");
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
