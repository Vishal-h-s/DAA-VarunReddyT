import java.util.*;

/*
 * T(n)=T(n−1)+T(n−2)+O(1)
 * O(2^n)
 */

public class ClimbingStairs {
    // Recursive implementation
    public int climbStairsRecur(int n) {
        if (n <= 2)
            return n;

        return climbStairsRecur(n - 1) + climbStairsRecur(n - 2);
    }

    // top down approach - Memoization
    public int climbStairsMem(int n) {
        if (n <= 2)
            return n;
        int[] dp = new int[n + 1];
        return solve(n, dp);
    }

    int solve(int n, int[] dp) {
        if (n <= 2)
            return n;
        if (dp[n] != 0)
            return dp[n];
        return dp[n] = solve(n - 1, dp) + solve(n - 2, dp);
    }

    // bottom up approach - tabulation
    public int climbStairsTab(int n) {
        if (n <= 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(new ClimbingStairs().climbStairsRecur(n));
        System.out.println(new ClimbingStairs().climbStairsMem(n));
        System.out.println(new ClimbingStairs().climbStairsTab(n));
        sc.close();
    }
}