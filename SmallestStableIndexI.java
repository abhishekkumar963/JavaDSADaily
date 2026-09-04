// 3903. Smallest Stable Index I

class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        
        int[] suffixMin = new int[n];
        int currMin = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            currMin = Math.min(currMin, nums[i]);
            suffixMin[i] = currMin;
        }
        
        int currMax = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            currMax = Math.max(currMax, nums[i]);
            
            if (currMax - suffixMin[i] <= k) {
                return i; // Return the first (smallest) stable index found
            }
        }
        
        return -1; // No stable index exists
    }
}