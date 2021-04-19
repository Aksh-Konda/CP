import java.util.*;

public class Program3 {
    static HashMap<String, Integer> memo = new HashMap<>();

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String[] raw = scn.nextLine().split(" ");
        int points[] = new int[raw.length + 2];
        points[0] = points[points.length - 1] = 1;
        for (int i = 1; i <= raw.length; i++) {
            points[i] = Integer.parseInt(raw[i - 1]);
        }

        System.out.println(getMaxPoints(points, 0, points.length - 1));

        scn.close();
    }

    public static int getMaxPoints(int[] points, int i, int j) {
        if (i == j - 1)
            return 0;
        String key = i + ", " + j;
        // if (!memo.containsKey(key)) {
        int max = Integer.MIN_VALUE;

        for (int k = i + 1; k < j; k++) {
            int temp = points[k - 1] * points[k] * points[k + 1];
            int curr = points[k];
            points[k] = points[k + 1];
            temp += getMaxPoints(points, i, k);
            points[k] = points[k - 1];
            temp += getMaxPoints(points, k, j);
            points[k] = curr;
            max = Math.max(max, temp);
        }
        System.out.println(Arrays.toString(points));
        System.out.println(key);
        System.out.println(max);

        // memo.put(key, max);
        // }

        return max;
    }
}
