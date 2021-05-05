import java.util.*;

public class Program2 {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();

        System.out.println(getValue(s));

        scn.close();
    }

    static int getValue(String s) {
        int value = 0;
        Stack<Integer> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '[') {
                stack.push(value);
                value = 0;
            } else {
                value = stack.pop() + (value == 0 ? 1 : value * 2);
            }
        }

        return value;
    }
}