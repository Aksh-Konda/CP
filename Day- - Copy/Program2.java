import java.util.*;

public class Program2 {
    static HashMap<String, Integer> memo = new HashMap<>();

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        Bowler bowlers[] = new Bowler[n];
        for (int i = 0; i < n; i++) {
            bowlers[i] = new Bowler();
            bowlers[i].w = scn.nextInt();
        }
        for (int i = 0; i < n; i++) {
            bowlers[i].age = scn.nextInt();
        }

        System.out.println(maxWicketsGroup(bowlers));
        scn.close();
    }

    public static int maxWicketsGroup(Bowler bowlers[]) {
        Arrays.sort(bowlers, new Comparator<Bowler>() {
            @Override
            public int compare(Bowler o1, Bowler o2) {
                return o2.age != o1.age ? o2.age - o1.age : o2.w - o1.w;
            }
        });

        int n = bowlers.length;
        int dp[] = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = bowlers[i].w;
        }

        int max = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (bowlers[i].w < bowlers[j].w || bowlers[i].age == bowlers[j].age) {
                    dp[i] = Math.max(dp[i], dp[j] + bowlers[i].w);
                }
            }
            max = Math.max(dp[i], max);
        }

        return max;
    }

    static class Bowler {
        int w;
        int age;
    }
}
