import java.util.*;

public class Program2 {

    static int[] digits = { 0, 1, 6, 8, 9 };

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        System.out.println(countValidReflections(n));

        scn.close();
    }

    static int countValidReflections(int n) {
        int count = 0;

        List<Integer> possibleReflections = new ArrayList<>();
        for (int i = 1; i < digits.length; i++) {
            possibleReflections.add(digits[i]);
        }
        possibleReflections.addAll(generateList(possibleReflections, n));

        for (int reflection : possibleReflections) {
            if (isValidReflection(reflection)) {
                count++;
            }
        }

        return count;
    }

    static List<Integer> generateList(List<Integer> list, int n) {
        List<Integer> result = new ArrayList<>();

        for (int num : list) {
            for (int digit : digits) {
                int temp = num * 10 + digit;
                if (temp > n) {
                    return result;
                }
                result.add(temp);
            }
        }
        result.addAll(generateList(result, n));
        return result;
    }

    static boolean isValidReflection(int num) {
        int newNum = 0;
        int temp = num;
        while (temp != 0) {
            int digit = temp % 10;
            temp /= 10;
            newNum = newNum * 10;
            if (digit == 0 || digit == 1 || digit == 8) {
                newNum += digit;
            } else if (digit == 6) {
                newNum += 9;
            } else if (digit == 9) {
                newNum += 6;
            } else {
                return false;
            }
        }

        return newNum != num;
    }
}