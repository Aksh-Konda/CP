import java.util.*;

public class Program1 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String[] vocabulary = scn.nextLine().split(" ");
        String[] words = scn.nextLine().split(" ");

        int[] vocHash = new int[vocabulary.length];
        int[] vocAcroHash = new int[vocabulary.length];

        int[] vocLens = new int[vocHash.length];

        for (int i = 0; i < vocabulary.length; i++) {
            vocHash[i] = vocabulary[i].hashCode();
            vocLens[i] = vocabulary[i].length();
            String acro = vocabulary[i].charAt(0) + new String(new char[vocLens[i] - 2])
                    + vocabulary[i].charAt(vocLens[i] - 1);
            vocAcroHash[i] = acro.hashCode();
        }

        for (int i = 0; i < words.length; i++) {
            boolean result = true;
            int wordLen = words[i].length();
            int wordHash = words[i].hashCode();
            int wordAcroHash = (words[i].charAt(0) + new String(new char[wordLen - 2]) + words[i].charAt(wordLen - 1))
                    .hashCode();
            for (int j = 0; j < vocabulary.length; j++) {
                if (wordLen == vocLens[j] && wordAcroHash == vocAcroHash[j]) {
                    if (wordHash != vocHash[j]) {
                        result = false;
                        break;
                    }
                }
            }
            System.out.print(result + " ");
        }

        scn.close();
    }
}
