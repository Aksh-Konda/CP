import java.util.*;

public class Program1 {
    static HashMap<String, List<String>> memo = new HashMap<>();

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        String str = scn.nextLine();

        System.out.println(getAllValidIPs(str.toCharArray(), 4, 0));

        scn.close();
    }

    public static List<String> getAllValidIPs(char[] str, int parts, int i) {
        String key = parts + ", " + i;
        if (memo.containsKey(key))
            return memo.get(key);

        List<String> result = new ArrayList<>();
        if (parts == 0 || i >= str.length || str[i] == 0) {
            if (parts == 0 && i >= str.length)
                result.add("");
            return result;
        }

        int num = 0;

        while (num <= 255 && i < str.length) {
            num = num * 10 + (str[i++] - '0');
            if (num > 255) {
                break;
            }

            List<String> combis = getAllValidIPs(str, parts - 1, i);
            for (String combi : combis) {
                if (parts == 1) {
                    result.add(num + combi);
                } else {
                    result.add(num + "." + combi);
                }
            }

            if (num == 0)
                break;
        }

        memo.put(key, result);
        return result;
    }
}