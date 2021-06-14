import java.util.*;

public class Program1 {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        String s = scn.next();

        System.out.println(ABDCount(s));

        scn.close();
    }

    static int ABDCount(String s) {
        char[] chars = s.toCharArray();

        int count = 0;
        for (int i = 0; i < chars.length - 1; i++) {
            Map<Character, Integer> countMap = new HashMap<>();
            for (int j = i; j < chars.length; j++) {
                int c = countMap.getOrDefault(chars[j], 0) + 1;
                countMap.put(chars[j], c);
                int min = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;
                for (int val : countMap.values()) {
                    min = Math.min(val, min);
                    max = Math.max(val, max);
                }
                count += max - min;
            }
        }

        return count;
    }

}