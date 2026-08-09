import java.util.*;

public class StoneGameII {

    private int[] prefixSum;
    private Integer[][] dp;
    private int n;

    public int stoneGameII(int[] piles) {
        n = piles.length;

        prefixSum = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + piles[i];
        }

        dp = new Integer[n][n + 1];

        return dfs(0, 1);
    }

    private int dfs(int index, int M) {

        if (2 * M >= n - index) {
            return prefixSum[n] - prefixSum[index];
        }

        if (dp[index][M] != null) {
            return dp[index][M];
        }

        int maxStones = 0;

        for (int X = 1; X <= 2 * M; X++) {

            int currentPlayerStones =
                    prefixSum[n] - prefixSum[index]
                    - dfs(index + X, Math.max(M, X));

            maxStones = Math.max(maxStones, currentPlayerStones);
        }

        dp[index][M] = maxStones;

        return maxStones;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of piles: ");
        int n = sc.nextInt();

        int[] piles = new int[n];

        System.out.println("Enter pile values:");

        for (int i = 0; i < n; i++) {
            piles[i] = sc.nextInt();
        }

        StoneGameII obj = new StoneGameII();

        int result = obj.stoneGameII(piles);

        System.out.println("Maximum stones Alice can get: " + result);

        sc.close();
    }
}
