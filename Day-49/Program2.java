import java.util.*;

public class Program2 {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        SortedSet<String> result = getAllCombinations("", 0, str);
        System.out.println(result);
        scn.close();
    }

    static SortedSet<String> getAllCombinations(String prev, int num, String left) {
        SortedSet<String> result = new TreeSet<>();
        result.add(prev + (num == 0 ? "" : num) + left.toString());

        if (left.isEmpty())
            return result;

        char curr = left.charAt(0);
        left = left.length() > 1 ? left.substring(1) : "";
        SortedSet<String> temp1 = getAllCombinations(prev, num + 1, left);
        SortedSet<String> temp2 = getAllCombinations(prev + (num == 0 ? "" : num) + curr, 0, left);

        result.addAll(temp1);
        result.addAll(temp2);

        return result;
    }
}