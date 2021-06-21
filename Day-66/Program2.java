import java.util.*;

public class Program2 {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        String[] exps = scn.nextLine().split(" ");

        System.out.println(checkTransitive(exps));

        scn.close();
    }

    static boolean checkTransitive(String exps[]) {
        int[] eq = new int[26];

        for (int i = 0; i < 26; i++) {
            eq[i] = i;
        }

        for (String exp : exps) {
            int a = exp.charAt(0) - 'a';
            int b = exp.charAt(3) - 'a';
            int op = exp.charAt(1);
            if (op == '=') {
                eq[getRoot(a, eq)] = eq[getRoot(b, eq)];
            }
        }

        for (String exp : exps) {
            int a = exp.charAt(0) - 'a';
            int b = exp.charAt(3) - 'a';
            int op = exp.charAt(1);
            if (op == '!' && areEqual(a, b, eq)) {
                return false;
            }
        }

        return true;
    }

    static boolean areEqual(int a, int b, int eq[]) {
        return getRoot(a, eq) == getRoot(b, eq);
    }

    static int getRoot(int i, int[] p) {
        int v = i;
        while (p[i] != i) {
            i = p[i];
        }

        while (p[v] != v) {
            v = p[v];
            p[v] = i;
        }

        return i;
    }
}