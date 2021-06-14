import java.util.*;

public class Program2 {
    final static int MAX = 1000000007;

    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        char bin[] = scn.nextLine().toCharArray();
        System.out.println(countValidDivisions(bin, 3));
        scn.close();
    }

    static int countValidDivisions(char[] bin, int k) {
        int ones = 0;
        for (char ch : bin) {
            if (ch == '1')
                ones++;
        }
        int n = bin.length;

        if (ones == 0)
            return (((n - 1) * (n - 2)) / 2);
        if (ones % 3 != 0)
            return 0;

        int part = ones / 3;
        int i = 0;

        int count = 0;
        while (count < part) {
            count += bin[i++] == '1' ? 1 : 0;
        }

        int j = i;
        while (count == part) {
            count += bin[j++] == '1' ? 1 : 0;
        }

        long totalCombinations = j - i;

        count = 1;

        while (count < part) {
            count += bin[j++] == '1' ? 1 : 0;
        }

        i = j;
        while (count == part) {
            count += bin[j++] == '1' ? 1 : 0;
        }

        totalCombinations = (totalCombinations * (j - i)) % MAX;

        return (int) totalCombinations;
    }
}