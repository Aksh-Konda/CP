import java.util.*;

class Program1 {
    public static void main(String[] args) {
        String w1 = "Explicabo";
        String w2 = "Lorem, ipsum dolor sit amet consectetur adipisicing elit. Explicabo non sed voluptas quo porro neque expedita mollitia, recusandae Explicabo fuga inventore eos nulla delectus pariatur? Ex aliquid tempora Explicabo labore sequi dolor.";

        checkSubstring(w1, w2);
    }

    public static void checkSubstring(String w1, String w2) {
        char w1Chars[] = w1.toCharArray();
        char w2Chars[] = w2.toCharArray();
        if (w1Chars.length > w2Chars.length)
            return;

        int p = 256;
        long h = 1;
        long m = 5915587277l;

        long w1Hash = 0;
        long w2Hash = 0;

        for (int i = 0; i < w1Chars.length - 1; i++) {
            h = (h * p) % m;
        }

        for (int i = 0; i < w1Chars.length; i++) {
            w1Hash = (w1Hash * p + w1Chars[i]) % m;
            w2Hash = (w2Hash * p + w2Chars[i]) % m;
        }

        for (int i = 0; i <= w2Chars.length - w1Chars.length; i++) {
            if (w1Hash == w2Hash) {
                // int j = 0;
                // while (j < w1Chars.length && w1Chars[j] == w2Chars[i + j])
                // j++;

                // if (j == w1Chars.length) {
                System.out.println("found at index: " + i);
                // }
            }
            if (i < w2Chars.length - w1Chars.length) {
                w2Hash = (p * (w2Hash - h * w2Chars[i]) + w2Chars[i + w1Chars.length]) % m;
                if (w2Hash < 0) {
                    w2Hash += m;
                }
            }
        }
    }
}

class Solution {
    public boolean checkSubstring(String w1, String w2) {
        char w1Chars[] = w1.toCharArray();
        char w2Chars[] = w2.toCharArray();
        if (w1Chars.length > w2Chars.length)
            return false;

        int m = Integer.MAX_VALUE;
        // int p = 10;
        // long pow[] = new long[w2Chars.length + 1];
        // pow[0] = 1;

        // for (int i = 1; i < pow.length; i++) {
        // pow[i] = (pow[i - 1] * p) % m;
        // }

        long rollingHash[] = new long[w2Chars.length + 1];

        for (int i = 0; i < w2Chars.length; i++) {
            rollingHash[i + 1] = (rollingHash[i] + (w2Chars[i] - 'a' + 1)) % m;
        }

        long w1Hash = 0;

        for (int i = 0; i < w1Chars.length; i++) {
            w1Hash = (w1Hash + (w1Chars[i] - 'a' + 1)) % m;
        }

        for (int i = 0; i <= w2Chars.length - w1Chars.length; i++) {
            long currHash = rollingHash[i + w1Chars.length] - rollingHash[i];
            if (currHash == w1Hash && areAnagrams(w1Chars, w2Chars, i))
                return true;
        }

        return false;
    }

    boolean areAnagrams(char w1[], char w2[], int i) {
        int count[] = new int[26];

        for (int j = 0; j < w1.length; j++) {
            count[w1[j] - 'a'] += 1;
            count[w2[i + j] - 'a'] -= 1;
        }

        for (int c : count) {
            if (c != 0)
                return false;
        }

        return true;
    }
}