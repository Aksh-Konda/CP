import java.util.*;

public class Program2 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        char[] s = scn.nextLine().toCharArray();

        int i = scn.nextInt();
        int[][] canSwap = new int[i][2];

        for (i = i - 1; i >= 0; i--) {
            canSwap[i][0] = scn.nextInt();
            canSwap[i][1] = scn.nextInt();
        }

        System.out.println(getModified(s, canSwap));

        scn.close();
    }

    static String getModified(char[] s, int canSwap[][]) {
        List<Set<Integer>> groups = getGrouped(canSwap);

        for (Set<Integer> group : groups) {
            Queue<Character> pq = new PriorityQueue<>();
            for (int i : group) {
                pq.add(s[i]);
            }
            for (int i : group) {
                s[i] = pq.poll();
            }
        }

        StringBuilder output = new StringBuilder(s.length);

        for (char ch : s) {
            output.append(ch);
        }

        return output.toString();
    }

    static List<Set<Integer>> getGrouped(int[][] pairs) {
        List<Set<Integer>> groups = new ArrayList<>();
        for (int[] pair : pairs) {
            Set<Integer> found1 = null;
            Set<Integer> found2 = null;

            for (Set<Integer> group : groups) {
                if (group.contains(pair[0])) {
                    found1 = group;
                }
                if (group.contains(pair[1])) {
                    found2 = group;
                }
            }

            if (found1 != null || found2 != null) {
                if (found1 != null && found2 != null && found1 != found2) {
                    found1.addAll(found2);
                    groups.remove(found2);
                } else if (found1 != null) {
                    found1.add(pair[1]);
                } else {
                    found2.add(pair[0]);
                }
            } else {
                groups.add(new TreeSet<Integer>() {
                    {
                        add(pair[1]);
                        add(pair[0]);
                    }
                });
            }
        }

        return groups;
    }
}