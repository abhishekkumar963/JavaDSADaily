import java.util.*;

public class MaxSubarrayLength {

    public static int maxSubarrayLength(int[] nums, int k) {

        Map<Integer, Integer> frequencyMap = new HashMap<>();

        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {

            frequencyMap.merge(nums[right], 1, Integer::sum);

            while (frequencyMap.get(nums[right]) > k) {
                frequencyMap.merge(nums[left], -1, Integer::sum);
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        int result = maxSubarrayLength(nums, k);

        System.out.println("Maximum Subarray Length: " + result);

        sc.close();
    }
}