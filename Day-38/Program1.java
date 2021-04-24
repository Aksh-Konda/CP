import java.util.*;

public class Program1 {
    static int cross[] = { 9, 8, 7, 6, -1, 4, 3, 2, 1 };

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int m = scn.nextInt();
        int n = scn.nextInt();

        HashSet<Integer> used = new HashSet<>();
        int count = 0;
        for (int i = 1; i < 10; i++) {
            used.add(i);
            count += getAllPossibleUniqKeyCombinations(m, n, i, used);
            used.remove(i);
        }

        System.out.println(count);

        scn.close();
    }

    static int getAllPossibleUniqKeyCombinations(int m, int n, int prev, HashSet<Integer> used) {
        if (used.size() == n)
            return 1;
        int count = 0;
        if (used.size() >= m)
            count++;

        for (int i = 1; i < 10; i++) {
            if (!used.contains(i) && canPassThrough(prev, i, used)) {
                used.add(i);
                count += getAllPossibleUniqKeyCombinations(m, n, i, used);
                used.remove(i);
            }
        }

        return count;
    }

    static boolean canPassThrough(int n1, int n2, HashSet<Integer> used) {
        int middle = getMiddle(n1, n2);
        if (middle != -1 && !used.contains(middle))
            return false;
        return true;
    }

    static int getMiddle(int n1, int n2) {
        if (cross[n1 - 1] == n2)
            return 5;
        if ((n1 == 1 && n2 == 3) || (n1 == 3 && n2 == 1))
            return 2;
        if ((n1 == 1 && n2 == 7) || (n1 == 7 && n2 == 1))
            return 4;
        if ((n1 == 3 && n2 == 9) || (n1 == 9 && n2 == 3))
            return 6;
        if ((n1 == 7 && n2 == 9) || (n1 == 9 && n2 == 7))
            return 4;
        return -1;
    }
}