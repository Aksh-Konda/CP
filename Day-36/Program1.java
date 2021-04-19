import java.util.*;

public class Program1 {
    static String combis[] = { "RBR", "BRB", "GRB", "RBG", "BRG", "GRG", "RGR", "BGR", "GBR", "RGB", "BGB", "GBG" };
    static HashMap<String, Integer> memo = new HashMap<>();
    static int mod = 1000000009;

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        System.out.println(getNumCombinations(n));

        scn.close();
    }

    static int getNumCombinations(int n) {
        int count = 0;
        for (String start : combis) {
            count = (count + getNextCombis(n - 1, start)) % mod;
        }

        return count;
    }

    static int getNextCombis(int n, String curr) {
        if (n == 0)
            return 1;

        String key = curr + n;

        if (!memo.containsKey(key)) {
            int count = 0;
            for (String next : combis) {
                if (canComeNext(curr, next)) {
                    count = (count + getNextCombis(n - 1, next)) % mod;
                }
            }
            memo.put(key, count);
        }

        return memo.get(key);
    }

    static boolean canComeNext(String curr, String next) {
        return curr.charAt(0) != next.charAt(0) && curr.charAt(1) != next.charAt(1) && curr.charAt(2) != next.charAt(2);
    }
}