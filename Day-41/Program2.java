import java.util.*;

public class Program2 {
    static HashMap<String, Integer> memo = new HashMap<>();

    static int getMinW(int[] W, int t) {
        int left = 0;
        int right = 0;
        for (int w : W) {
            right += w;
            if (left < w)
                left = w;
        }

        while (left < right) {
            int mid = (left + right) / 2;
            int count = 1;
            int temp = 0;
            for (int w : W) {
                if (temp + w > mid) {
                    temp = 0;
                    count++;
                }
                temp += w;
            }

            if (count > t)
                left = mid + 1;
            else
                right = mid;
        }

        return left;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int t = scn.nextInt();

        int w[] = new int[n];

        for (int i = 0; i < w.length; i++) {
            w[i] = scn.nextInt();
        }

        System.out.println(getMinW(w, t));

        scn.close();
    }

    static int getMinWeight(int n, int t, int[] w) {
        return dfs(w, 0, t);
    }

    static int dfs(int[] w, int i, int t) {

        String key = i + ":" + t;

        if (memo.containsKey(key))
            return memo.get(key);

        if (t == 1) {
            int res = 0;

            while (i < w.length) {
                res += w[i++];
            }

            return res;
        }

        int min = Integer.MAX_VALUE;
        int tw = 0;
        for (; i <= (w.length - t); i++) {
            tw += w[i];
            min = Math.min(min, Math.max(tw, dfs(w, i + 1, t - 1)));
        }

        memo.put(key, min);

        return min;
    }
}
