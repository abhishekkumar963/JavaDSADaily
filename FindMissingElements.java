import java.util.*;

public class FindMissingElements {

    public static List<Integer> findMissingElements(int[] nums) {
        int mn = Integer.MAX_VALUE;
        int mx = Integer.MIN_VALUE;

        Set<Integer> s = new HashSet<>();

        for (int x : nums) {
            mn = Math.min(mn, x);
            mx = Math.max(mx, x);
            s.add(x);
        }

        List<Integer> ans = new ArrayList<>();

        for (int x = mn + 1; x < mx; x++) {
            if (!s.contains(x)) {
                ans.add(x);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        List<Integer> result = findMissingElements(nums);

        System.out.println("Missing Elements: " + result);

        sc.close();
    }
}
