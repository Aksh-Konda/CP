import java.util.*;

public class Program3 {

    public static void main(String[] args) {

        // Arrays.stream(scn.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();

        Scanner scn = new Scanner(System.in);

        char[] line = scn.nextLine().toCharArray();

        System.out.println(minChanges(line));

        scn.close();
    }

    static int minChanges(char[] line) {
        int min1 = 0;
        int min2 = 0;

        char prev = '0';
        min1 = line[0] == '0' ? 0 : 1;

        for (int i = 1; i < line.length; i++) {
            if (prev == line[i]) {
                prev = line[i] == '0' ? '1' : '0';
                min1++;
            } else {
                prev = line[i];
            }
        }

        prev = '1';
        min2 = line[0] == '1' ? 0 : 1;

        for (int i = 1; i < line.length; i++) {
            if (prev == line[i]) {
                prev = line[i] == '0' ? '1' : '0';
                min2++;
            } else {
                prev = line[i];
            }
        }

        return Math.min(min1, min2);
    }
}