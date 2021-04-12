import java.util.*;

public class Program1 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        char words[][] = new char[n][];

        for (int i = 0; i < n; i++) {
            words[i] = scn.next().toCharArray();
        }

        System.out.println(isSatisfying(words));

        scn.close();
    }

    static boolean isSatisfying(char[][] words) {

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length; j++) {
                if (i >= words[j].length || words[i][j] != words[j][i]) {
                    return false;
                }
            }
        }

        return true;
    }
}