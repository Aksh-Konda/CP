import java.util.*;

public class Program3 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        String str = scn.nextLine();

        int n = scn.nextInt();

        System.out.println(getLenOfLongestSubStr(str.toCharArray(), n));

        scn.close();
    }

    public static int getLenOfLongestSubStr(char[] str, int n) {
        int maxLen = 0;

        int i = 0, j = 0;

        HashMap<Character, Integer> count = new HashMap<>();

        int uniqCount = 0;

        while (j < str.length) {
            count.put(str[j], count.getOrDefault(str[j], 0) + 1);

            if (count.get(str[j]) == 1)
                uniqCount++;

            while (uniqCount > n) {
                count.put(str[i], count.get(str[i]) - 1);

                if (count.get(str[i]) == 0) {
                    uniqCount--;
                }

                i++;
            }

            maxLen = Math.max(j - i + 1, maxLen);

            j++;
        }

        return maxLen;
    }
}
