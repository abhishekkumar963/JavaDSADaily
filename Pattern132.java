import java.util.*;

public class Pattern132 {

    public static boolean find132pattern(int[] nums) {

        int middleValue = Integer.MIN_VALUE;

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = nums.length - 1; i >= 0; i--) {

            // nums[i] is the "1"
            // middleValue is the "2"
            if (nums[i] < middleValue) {
                return true;
            }

            // Find the largest possible "2"
            while (!stack.isEmpty() && stack.peek() < nums[i]) {
                middleValue = stack.pop();
            }

            // Add current number to stack
            stack.push(nums[i]);
        }

        return false;
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

        boolean result = find132pattern(nums);

        System.out.println("132 Pattern exists: " + result);

        sc.close();
    }
}