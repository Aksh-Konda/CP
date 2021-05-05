import java.util.*;

public class Program2 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int m = scn.nextInt();
        int n = scn.nextInt();
        int s = scn.nextInt();
        scn.nextLine();
        String words[] = scn.nextLine().split(" ");

        System.out.println(getRepeatableCount(m, n, words));

        scn.close();
    }

    static int getRepeatableCount(int m, int n, String words[]) {
        int lens[] = new int[words.length];

        for (int i = 0; i < words.length; i++) {
            lens[i] = words[i].length();
            if (lens[i] > n)
                return 0;
        }

        int k = 0;
        int i = 0;
        int count = 0;
        while (i < m) {
            count++;
            for (int j = 0; j < lens.length; j++) {
                if (lens[j] > n)
                    return 0;

                k += lens[j];
                if (k > n) {
                    i++;
                    k = lens[j];
                }
                k++;
            }
        }

        return count;
    }
}