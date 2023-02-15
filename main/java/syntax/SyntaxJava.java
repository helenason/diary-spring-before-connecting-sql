package syntax;

import java.util.ArrayList;
import java.util.Arrays;

public class SyntaxJava {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>(Arrays.asList("n0", "N1", "n2", "n3"));
        System.out.println(names.remove(0)); // 값을 리턴해줌

        System.out.println(names.remove("n2"));
        System.out.println(names);
        names.clear();
        System.out.println(names);
    }
}
