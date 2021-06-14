import java.util.*;

public class Program2 {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        char[] p = scn.next().toCharArray();
        char[] q = scn.next().toCharArray();

        boolean flag = false;
        for (int i = 0; i <= p.length && !flag; i++) {
            flag = checkPalindrome(p, q, i);
        }

        System.out.println(flag);

        scn.close();
    }

    public static boolean isPalindrome(char[] s, int i, int j) {
        while (i < j) {
            if (s[i] != s[j])
                return false;
            i++;
            j--;
        }
        return true;
    }

    public static boolean checkPalindrome(char[] p, char[] q, int i) {
        int j = 0;
        int k = q.length - 1;

        boolean flag = true;
        while (j < i && k >= i) {
            if (p[j] != q[k]) {
                flag = false;
                break;
            }
            j++;
            k--;
        }

        if (flag) {
            if (j < i)
                flag = isPalindrome(p, j, i - 1);
            else if (k >= i)
                flag = isPalindrome(q, i, k);
        }

        if (flag)
            return true;

        j = 0;
        k = p.length - 1;
        flag = true;
        while (j < i && k >= i) {
            if (q[j] != p[k]) {
                flag = false;
                break;
            }
            j++;
            k--;
        }

        if (flag) {
            if (j < i)
                flag = isPalindrome(q, j, i - 1);
            else if (k >= i)
                flag = isPalindrome(p, i, k);
        }

        return flag;
    }
}