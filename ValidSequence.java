import java.util.*;

public class ValidSequence {

    public static int[] validSequence(String word1, String word2) {

        int[] ans = new int[word2.length()];

        int[] last = new int[word2.length()];
        Arrays.fill(last, -1);

        int i = word1.length() - 1;
        int j = word2.length() - 1;

        // Find the last possible matching positions
        while (i >= 0 && j >= 0) {

            if (word1.charAt(i) == word2.charAt(j)) {
                last[j--] = i;
            }

            --i;
        }

        boolean canSkip = true;
        j = 0;

        for (i = 0; i < word1.length(); ++i) {

            if (j == word2.length()) {
                break;
            }

            if (word1.charAt(i) == word2.charAt(j)) {
                ans[j++] = i;
            } 
            else if (canSkip &&
                    (j == word2.length() - 1 || i < last[j + 1])) {

                canSkip = false;
                ans[j++] = i;
            }
        }

        return j == word2.length() ? ans : new int[0];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter word1: ");
        String word1 = sc.nextLine();

        System.out.print("Enter word2: ");
        String word2 = sc.nextLine();

        int[] result = validSequence(word1, word2);

        if (result.length == 0) {
            System.out.println("No valid sequence found.");
        } else {
            System.out.println("Valid Sequence: " + Arrays.toString(result));
        }

        sc.close();
    }
}