import java.util.*;

public class Program1 {
    static HashMap<Integer, Long> memo = new HashMap<>();

    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        Long s = findSmallestS(n);
        System.out.println(s == Long.MAX_VALUE ? 0 : s);
        scn.close();
    }

    static long findSmallestS(int n) {
        if (n / 10 == 0)
            return n;
        if (!memo.containsKey(n)) {

            for (int i = 9; i > 1; i--) {
                if (n % i == 0) {
                    long tempS = findSmallestS(n / i);
                    if (tempS != Long.MAX_VALUE) {
                        memo.put(n, findSmallestS(n / i) * 10 + i);
                        break;
                    }
                }
            }
            if (!memo.containsKey(n)) {
                memo.put(n, 0l);
            }
        }

        return memo.get(n);
    }
}