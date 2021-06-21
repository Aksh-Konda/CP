import java.util.*;

public class Program2 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        String words[] = scn.nextLine().split(" ");

        System.out.println(getNonMatchingProduct(words));

        scn.close();
    }

    static int getNonMatchingProduct(String[] words) {
        int n = words.length;
        int[] bmaps = new int[n];

        for (int i = 0; i < n; i++) {
            for (char ch : words[i].toCharArray()) {
                bmaps[i] = bmaps[i] | (1 << (ch - 'a'));
            }
        }
        int res = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((bmaps[i] & bmaps[j]) == 0) {
                    res = Math.max(words[i].length() * words[j].length(), res);
                }
            }
        }

        return res;
    }
}
