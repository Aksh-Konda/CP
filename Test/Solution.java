import java.util.*;

public class Solution {
    static String open = "(";
    static String close = ")";
    
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        
        int t = scn.nextInt();
        
        for(int i=1; i<=t; i++) {
            System.out.print("Case #"+i+": ");
            solve(scn);
        }
        
        scn.close();
    }
    
    public static void solve(Scanner scn) {
        char chars[] = scn.nextLine().toCharArray();
        StringBuilder result = new StringBuilder();
        
        int d = 0;
        
        for(char ch: chars) {
            int digit = ch-'0';
            if(digit > d) {
                result.append(open.repeat(digit-d));
            }
            else if(digit < d) {
                result.append(close.repeat(d-digit));
            }
            result.append(ch);
        }
        
        System.out.println(result.toString());
    }
}