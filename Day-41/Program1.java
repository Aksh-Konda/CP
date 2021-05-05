import java.util.*;

public class Program1 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int d = scn.nextInt();
        int m = scn.nextInt();
        int n = scn.nextInt();

        System.out.println(CountOccurranceOfDigitInRange(d, m, n));

        scn.close();
    }

    static int digitCountUpto(int d, int n) {
        int count = 0;
        for (int m = 1; m <= n; m *= 10) {
            int msd = n / m;
            int lsd = n % m;
            int currPosD = msd % 10;

            if (currPosD > d) {
                count += ((msd / 10) + 1) * m;
            } else if (currPosD == d) {
                count += (msd / 10) * m + (lsd + 1);
            } else {
                count += (msd / 10) * m;
            }

            if (d == 0) {
                count -= m;
            }
        }
        return count;
    }

    static int CountOccurranceOfDigitInRange(int d, int m, int n) {
        return digitCountUpto(d, n) - digitCountUpto(d, m - 1);
    }
}