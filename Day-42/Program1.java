import java.util.*;

public class Program1 {

    static HashMap<Integer, Integer> memo = new HashMap<>();

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();

        System.out.println(getMinSteps(num));

        scn.close();
    }

    static int getMinSteps(int num) {
        if (num == 1)
            return 0;
        if (memo.containsKey(num))
            memo.get(num);

        int steps = 1;

        if (num % 2 != 0) {
            steps += Math.min(getMinSteps(num + 1), getMinSteps(num - 1));
        } else {
            steps += getMinSteps(num / 2);
        }

        memo.put(num, steps);
        return steps;
    }
}
