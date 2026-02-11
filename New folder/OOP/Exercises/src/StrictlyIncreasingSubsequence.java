
import java.util.Arrays;

public class StrictlyIncreasingSubsequence {
    public static int longestIncreasingSubsequence(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = 0;
        for (int len : dp) {
            max = Math.max(max, len);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] sequence = {10, 22, 9, 33, 21, 50, 41, 60, 80};
        int longest = longestIncreasingSubsequence(sequence);
        System.out.println("The length of the longest strictly increasing subsequence is: " + longest);
    }
}