import java.util.HashMap;
import java.util.Scanner;

public class Program2 {
    static HashMap<String, Integer> memo = new HashMap<>();

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String bins[] = scn.nextLine().split(" ");
        int p = scn.nextInt();
        int q = scn.nextInt();
        System.out.println(getMinPossibleBins(bins, p, q));

        scn.close();
    }

    static int getMinPossibleBins(String[] bins, int p, int q) {
        BinCount counts[] = new BinCount[bins.length];

        for (int i = 0; i < bins.length; i++) {
            counts[i] = new BinCount();
            for (char bd : bins[i].toCharArray()) {
                if (bd == '0') {
                    counts[i].zeros++;
                } else {
                    counts[i].ones++;
                }
            }
        }

        return getMinPossible(counts, p, q, 0);
    }

    static int getMinPossible(BinCount[] counts, int p, int q, int i) {
        if (p == 0 && q == 0) {
            return 0;
        }
        if (p < 0 || q < 0 || i >= counts.length)
            return Integer.MIN_VALUE;

        String key = p + ", " + q + ", " + i;

        if (!memo.containsKey(key)) {
            int max = getMinPossible(counts, p - counts[i].ones, q - counts[i].zeros, i + 1) + 1;
            max = Math.max(max, getMinPossible(counts, p, q, i + 1));
            memo.put(key, max);
        }

        return memo.get(key);
    }
}

class BinCount {
    int ones;
    int zeros;
}