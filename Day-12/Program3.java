import java.util.Scanner;

public class Program3 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        char bits[] = scn.nextLine().toCharArray();

        System.out.println(minOps(bits));

        scn.close();
    }

    static int minOps(char[] bits) {
        boolean on = false;

        int ops = 0;
        for (char bit : bits) {
            if ((bit == '1') != on) {
                ops++;
                on = !on;
            }
        }

        return ops;
    }
}
