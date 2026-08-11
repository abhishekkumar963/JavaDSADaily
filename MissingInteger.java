import java.util.*;

public class MissingInteger {

    public static int missingInteger(int[] nums) {

        int sum = nums[0];

        // Find the longest consecutive prefix
        for (int i = 1; i < nums.length && nums[i] == nums[i - 1] + 1; i++) {
            sum += nums[i];
        }

        boolean[] isPresent = new boolean[51];

        // Mark numbers that are present
        for (int num : nums) {
            isPresent[num] = true;
        }

        // Find the smallest missing integer >= sum
        for (int candidate = sum; ; candidate++) {

            if (candidate >= isPresent.length || !isPresent[candidate]) {
                return candidate;
            }
        }
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

        int result = missingInteger(nums);

        System.out.println("Missing Integer: " + result);

        sc.close();
    }
}