import java.util.*;

public class Program1 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        char digits[] = scn.nextLine().toCharArray();
        int k = scn.nextInt();

        int n = digits.length;

        System.out.println(getSmallestNum(digits, n - k, 0, ""));

        scn.close();
    }

    static long getSmallestNum(char digits[], int n, int i, String num) {
        if (i == digits.length || digits.length - i < n)
            return Long.MAX_VALUE;
        if (digits.length - i == n) {
            for (; i < digits.length; i++) {
                num = num + digits[i];
            }
            return Long.parseLong(num);
        }

        long temp1 = getSmallestNum(digits, n - 1, i + 1, num + digits[i]);
        long temp2 = getSmallestNum(digits, n, i + 1, num);

        return temp1 > temp2 ? temp2 : temp1;
    }
}
// 87641324683128648768
// Can be done using stack!