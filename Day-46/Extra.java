import java.util.*;

public class Extra {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        int a = scn.nextInt();
        int b = scn.nextInt();
        int mod = scn.nextInt();
        System.out.println(getSolution(a, b, mod));
        scn.close();
    }

    static int getSolution(int a, int b, int mod) {
        long fact = 1;

        for (int num = b + 1; num <= a; num++) {
            fact = (fact * num) % mod;
        }

        return (int) fact % mod;
    }
}