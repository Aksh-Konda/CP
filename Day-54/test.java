import java.util.*;

public class test {
    static Set<Integer> res = new TreeSet<Integer>();
    static HashMap<String, Integer> memo = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ns = sc.nextInt();
        int gates[][] = new int[ns + 1][3];
        for (int i = 0; i < gates.length; i++) {
            int a = sc.nextInt();
            if (a > 0)
                gates[i][a - 1] = -1;
        }
        /*
         * for (int i = 0; i < gates.length; i++) {
         * System.out.println(Arrays.toString(gates[i])); }
         */
        System.out.println(getMinimumJumps(gates, 0, 1, 0, ns));

        sc.close();
    }

    private static int getMinimumJumps(int[][] gates, int i, int j, int jumps, int ns) {
        // System.out.println("step: "+i+" lane: "+j+" Jumps: "+jumps);
        // System.out.println(memo);
        String key = i + ":" + j;
        if (memo.containsKey(key)) {
            // System.out.println(key+" returning:"+jumps+memo.get(key));
            return jumps + memo.get(key);
        }

        if (i == ns) {

            // System.out.println("Reached Hill with "+jumps);

            return jumps;
        }
        if (gates[i + 1][j] != -1) {
            int a = getMinimumJumps(gates, i + 1, j, jumps, ns);
            memo.put(key, a - jumps);
            return a;
        } else {
            int min = Integer.MAX_VALUE;

            if (j > 0 && gates[i][j - 1] != -1) {
                int a = getMinimumJumps(gates, i, j - 1, jumps + 1, ns);
                min = min > a ? a : min;
            }
            if (j < 2 && gates[i][j + 1] != -1) {

                int a = getMinimumJumps(gates, i, j + 1, jumps + 1, ns);
                min = min > a ? a : min;
            }
            if (j == 0 && gates[i][j + 1] == -1) {

                int a = getMinimumJumps(gates, i, j + 2, jumps + 1, ns);
                min = min > a ? a : min;
            } else if (j == 2 && gates[i][j - 1] == -1) {
                getMinimumJumps(gates, i, j - 2, jumps + 1, ns);
                int a = getMinimumJumps(gates, i, j - 2, jumps + 1, ns);
                min = min > a ? a : min;
            }
            memo.put(key, min - jumps);
            return min;

        }
    }

}