import java.util.*;

public class Program2 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String pat = scn.next();
        String str = scn.next();

        System.out.println(isMatch(str, pat, 0, 0, new HashMap<>()));

        scn.close();
    }

    public static boolean isMatch(String str, String pat, int i, int j, Map<Character, String> map) {
        int n = str.length(), m = pat.length();

        if (n < m) {
            return false;
        }
        if (i == n && j == m) {
            return true;
        }

        if (i == n || j == m) {
            return false;
        }

        char curr = pat.charAt(j);

        if (map.containsKey(curr)) {
            String s = map.get(curr);
            int k = s.length();

            String ss;
            if (i + k < str.length()) {
                ss = str.substring(i, i + k);
            } else {
                ss = str.substring(i);
            }

            if (ss.compareTo(s) != 0) {
                return false;
            }

            return isMatch(str, pat, i + k, j + 1, map);
        }
        for (int k = 1; k <= n - i; k++) {
            String part = str.substring(i, i + k);

            if (!map.values().contains(part)) {
                map.put(curr, part);
                if (isMatch(str, pat, i + k, j + 1, map)) {
                    return true;
                }

                map.remove(curr);
            }
        }

        return false;
    }
}
