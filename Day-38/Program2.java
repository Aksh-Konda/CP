import java.util.*;

public class Program2 {
    static HashMap<Integer, List<String>> memo = new HashMap<>();

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        char input[] = scn.nextLine().toCharArray();
        List<List<String>> groups = new ArrayList<>();

        int i = 0;

        List<String> curr = new ArrayList<>();
        StringBuilder currStr = new StringBuilder();

        while (i < input.length) {
            if (input[i] == ',' || input[i] == ']' || input[i] == '[') {
                if (currStr.length() > 0) {
                    curr.add(currStr.toString());
                    currStr = new StringBuilder();
                }
                if (input[i] == ']' || input[i] == '[' && curr.size() > 0) {
                    groups.add(curr);
                    curr = new ArrayList<>();
                }
            } else {
                currStr.append(input[i]);
            }
            i++;
        }
        if (curr.size() > 0 || currStr.length() > 0) {
            if (currStr.length() > 0) {
                curr.add(currStr.toString());
            }
            groups.add(curr);
        }

        for (List<String> list : groups) {
            Collections.sort(list);
        }

        System.out.println(getCombinations(groups, 0));

        scn.close();
    }

    static List<String> getCombinations(List<List<String>> groups, int i) {
        List<String> result = new ArrayList<>();

        if (memo.containsKey(i))
            return memo.get(i);

        if (i == groups.size()) {
            result.add("");
            return result;
        }

        for (String str : groups.get(i)) {
            List<String> combis = getCombinations(groups, i + 1);
            for (String combi : combis) {
                result.add(str + combi);
            }
        }

        memo.put(i, result);

        return result;
    }
}
