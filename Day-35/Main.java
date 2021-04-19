import java.util.HashMap;
import java.util.Map;

class Main {
    public static boolean isMatch(String str, int i, String pat, int j, Map<Character, String> map) {
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

            return isMatch(str, i + k, pat, j + 1, map);
        }
        for (int k = 1; k <= n - i; k++) {
            map.put(curr, str.substring(i, i + k));
            if (isMatch(str, i + k, pat, j + 1, map)) {
                return true;
            }

            map.remove(curr);
        }

        return false;
    }

    public static void main(String[] args) {

        String str = "codesleepcode";
        String pat = "XYX";

    }
}