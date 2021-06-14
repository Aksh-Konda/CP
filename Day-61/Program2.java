import java.util.*;

public class Program2 {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();

        System.out.println(smallestStringPossible(s));

        scn.close();
    }

    static String smallestStringPossible(String s) {
        char[] chars = s.toCharArray();

        HashMap<Character, Integer> lastSeenAt = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            lastSeenAt.put(chars[i], i);
        }

        Stack<Character> stack = new Stack<>();
        HashSet<Character> usedChars = new HashSet<>();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (!usedChars.contains(ch)) {
                while (!stack.isEmpty() && stack.peek() > ch && lastSeenAt.get(stack.peek()) > i) {
                    usedChars.remove(stack.pop());
                }
                stack.push(ch);
                usedChars.add(ch);
            }
        }

        StringBuilder r = new StringBuilder();
        while (!stack.isEmpty()) {
            r.append(stack.pop());
        }

        return r.reverse().toString();
    }
}