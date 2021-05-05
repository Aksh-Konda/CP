import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        String num1 = scn.next();
        String num2 = scn.next();

        System.out.println(getStringMultiplication(num1, num2));

        scn.close();
    }

    static String getStringMultiplication(String num1, String num2) {
        if (num1 == "0" || num2 == "0")
            return "0";

        byte[] mul = new byte[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            if (num1.charAt(i) != '0') {
                for (int j = num2.length() - 1; j >= 0; j--) {
                    int part = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + mul[i + j + 1];
                    mul[i + j + 1] = (byte) (part % 10);
                    mul[i + j] += part / 10;
                }
            }
        }

        StringBuilder result = new StringBuilder(mul.length);

        for (int num : mul) {
            if (num != 0 || result.length() > 0) {
                result.append(num);
            }
        }

        return result.toString();
    }
}