import java.util.*;

public class Program1 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();
        int n = countDigit(num);

        int dgs[] = new int[n];

        int i = n - 1;
        while (num != 0) {
            dgs[i] = num % 10;
            num /= 10;
            i--;
        }

        System.out.println(findNextGreaterNumber(dgs));

        scn.close();
    }

    static int countDigit(long n) {
        return (int) Math.floor(Math.log10(n) + 1);
    }

    static void swap(int[] number, int i, int j) {
        int temp = number[i];
        number[i] = number[j];
        number[j] = temp;
    }

    static void sortSubarray(int[] number, int i, int j) {
        while (i < j) {
            swap(number, i, j);
            i += 1;
            j -= 1;
        }
    }

    static int findNextGreaterNumber(int[] number) {
        int lastDigitSeen = number[number.length - 1], i, j;
        for (i = number.length - 2; i >= 0; i--) {
            if (lastDigitSeen > number[i]) {
                break;
            }
            lastDigitSeen = number[i];
        }

        if (i >= 0) {
            for (j = number.length - 1; j > i; j--) {
                if (number[j] > number[i]) {
                    break;
                }
            }

            swap(number, i, j);

            sortSubarray(number, i + 1, number.length - 1);

            int result = 0;

            for (i = 0; i < number.length; i++) {
                result = result * 10 + number[i];
            }

            return result;
        } else {
            return -1;
        }
    }
}