// 3870. Count Commas in Range

class Solution {
    public int countCommas(int n) {
        int totalCommas = 0;
        long threshold = 1000;
        
        while (n >= threshold) {
            totalCommas += (n - threshold + 1);
            
            threshold *= 1000;
        }
        
        return totalCommas;
    }
}
