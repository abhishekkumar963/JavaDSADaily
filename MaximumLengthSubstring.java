// 3090. Maximum Length Substring With Two Occurrences

import java.util.*;

public class MaximumLengthSubstring {

    public static int maximumLengthSubstring(String s) {

        int[] charFrequency = new int[26];
        int maxLength = 0;

        int left = 0;

        for (int right = 0; right < s.length(); right++) {

            int currentCharIndex = s.charAt(right) - 'a';

            charFrequency[currentCharIndex]++;

            while (charFrequency[currentCharIndex] > 2) {

                int leftCharIndex = s.charAt(left) - 'a';

                charFrequency[leftCharIndex]--;

                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String s = sc.nextLine();

        int result = maximumLengthSubstring(s);

        System.out.println("Maximum Length: " + result);

        sc.close();
    }
}