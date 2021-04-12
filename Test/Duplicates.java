import java.util.HashSet;
import java.util.stream.Stream;

public class Duplicates {
    public static void main(String[] args) {
        int nums[] = {};

        HashSet<Integer> seen = new HashSet<>();

        for (int num : nums) {
            if (seen.contains(num)) {
                System.out.println(num);
                break;
            }
        }
    }
}