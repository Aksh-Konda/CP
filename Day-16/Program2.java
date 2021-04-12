import java.util.*;

public class Program2 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int s = scn.nextInt();
        int weights[] = new int[n];

        for (int i = 0; i < weights.length; i++) {
            weights[i] = scn.nextInt();
        }

        System.out.println(minNumCranes(weights, s));
        scn.close();
    }

    static int minNumCranes(int[] weights, int s) {
        Arrays.sort(weights);

        int min = 0;

        int i = 0, j = weights.length - 1;
        while (i <= j) {
            if (i != j) {
                min++;
                if ((weights[i] + weights[j]) <= s) {
                    i++;
                    j--;
                } else {
                    j--;
                }
            } else {
                min++;
                j--;
            }
        }

        return min;
    }
}