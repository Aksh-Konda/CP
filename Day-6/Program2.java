import java.util.*;

public class Program2 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        String W = scn.next();
        int R = scn.nextInt();

        System.out.println(removeAllMemeographs(W, R));

        scn.close();
    }

    static String removeAllMemeographs(String w, int r) {
        char chars[] = w.toCharArray();
        Stack<Character> s = new Stack<Character>();
        Stack<Integer> count = new Stack<Integer>();
        char prev = ' ';
        for (char ch : chars) {
            if (!s.isEmpty() && prev == ch) {
                count.push(count.pop() + 1);
            } else {
                count.push(1);
                s.push(ch);
                prev = ch;
            }

            if (count.peek() == r) {
                s.pop();
                count.pop();
                prev = s.isEmpty() ? ' ' : s.peek();
            }
        }

        StringBuilder result = new StringBuilder(s.size());
        while (!s.isEmpty()) {
            result.insert(0, s.pop());
        }

        return result.toString();
    }
}
