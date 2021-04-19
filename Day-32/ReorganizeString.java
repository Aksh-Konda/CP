/*
You are provided a string of characters(lowercase only),
You can change the order of the characters of the string.
After changing the order, the resultant string should be 
no two immidiate characters equal.

Return true, if you are able to find such resultant string, 
Otherwise false.

Input Format:
-------------
A String S

Output Format:
--------------
Print a boolean value.


Sample Input-1:
---------------
aaabd

Sample Output-1:
----------------
true

Sample Input-2:
---------------
aaab

Sample Output-2:
----------------
false


***** Testcases *****
case =1
input =aaab
output =false

case =2
input =aaabd
output =true

case =3
input =abababaabbbababababbabababbbbbbababbb
output =false

case =4
input =abbaaabbbbaaaaaabbbbbbaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbcccccccccccccc
output =flase

case =5
input =aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbcccc
output =false

case =6
input =aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbccccc
output =true

case =7
input =abbaaabbbbaaaaaabbbbbbaaaaaaahhhhhhhhaaaaaaaaajjjjjjjjjjaaaaaaaaaabbbbbbbbbcccccccc
output =true

case =8
input =aaaaaaaaaaaaaaaaabbbbbbbbbcccccccc
output =true

*/
import java.util.*;

class ReorganizeString {
 public String reorganizeString(String S) {
        int[] hash = new int[26];
        for (int i = 0; i < S.length(); i++) {
            hash[S.charAt(i) - 'a']++;
        } 
        int max = 0, letter = 0;
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] > max) {
                max = hash[i];
                letter = i;
            }
        }
        if (max > (S.length() + 1) / 2) {
            return ""; 
        }
        char[] res = new char[S.length()];
        int idx = 0;
        while (hash[letter] > 0) {
            res[idx] = (char) (letter + 'a');
            idx += 2;
            hash[letter]--;
        }
        for (int i = 0; i < hash.length; i++) {
            while (hash[i] > 0) {
                if (idx >= res.length) {
                    idx = 1;
                }
                res[idx] = (char) (i + 'a');
                idx += 2;
                hash[i]--;
            }
        }
        return String.valueOf(res);
    }

	public static void main( String args[])
	{
		Scanner sc=new Scanner(System.in);
		String s=sc.next();
		String res=new ReorganizeString().reorganizeString(s);
		if(res.length()>0)
			System.out.println("true");
		else
			System.out.println("false");
	}
}