import java.lang.Math;
import java.util.HashMap;
import java.util.Map;

public class FrogJump {

    public static int frogJump(int n, int[] heights, int[] dp) {
        if ( n -1 == 0)
            return 0;
        else if ( dp[n -1] != 1) return dp[n  -1];

        int fs = frogJump(n -1, heights, dp) + Math.abs(heights[n - 1] - heights[n -2]);
        int ss = Integer.MAX_VALUE;

        if ( n -1 > 1) ss = frogJump(n -2, heights, dp) + Math.abs(heights[n - 1] - heights[n -3]);

        return dp[n -1] = Math.min(fs, ss);
    }

    public static int frogJump( int n, int[] heights) {
        int prev = 0, prev2 = 0;

        for( int i=1; i < n; i++) {
            int fs = prev + Math.abs(heights[n - 1] - heights[n -2]);
            int ss = Integer.MAX_VALUE;

            if ( n -1 > 1) ss = prev2 + Math.abs(heights[n - 1] - heights[n -3]);

            prev2 = prev;
            prev = Math.min(fs, ss);
        }
        return prev;
    }

    public static int binarySearch(int[] stones, int left, int target) {
        int right = stones.length -1;

        if ( stones[left] == target)
            return left;
        else if ( stones[right] == target)
            return right;

        while ( right >= left) {
            int mid = right - ( right - left) /2;

            if ( stones[mid] == target)
                return mid;
            else if ( stones[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return -1;
    }

    public static boolean crossRiver(int[] stones, int positions, int unitofjump, Map<Integer, Boolean>dp){
        if ( positions >= stones.length)
            return true;
        else if ( dp.containsKey(positions) )
            return dp.get(positions);

        int[] target = new int[3];
        target[0] = stones[positions] + unitofjump - 1;
        target[1] = stones[positions] + unitofjump;
        target[2] = stones[positions] + unitofjump + 1;
        
        int[] search = new int[3];
        search[0] = binarySearch(stones, positions + 1, target[0]);
        search[1] = binarySearch(stones, positions + 1, target[1]);
        search[2] = binarySearch(stones, positions + 1, target[2]);

        boolean stat1 = false;
        boolean stat2 = false;
        boolean stat3 = false;

        if ( search[0] != -1) {
            dp.put(search[0], true);
            stat1 = crossRiver(stones, search[0], target[0] - stones[positions], dp);
        }
        if ( search[1] != -1) {
            dp.put(search[1], true);
            stat2 = crossRiver(stones, search[1], target[1] - stones[positions], dp);
        }
        if ( search[2] != 2) {
            dp.put(search[2], true);
            stat2 = crossRiver(stones, search[2], target[2] - stones[positions], dp);
        }

        dp.put(positions, (stat1 || stat2 || stat3) ? true : false);

        return stat1 || stat2 || stat3;
    }
    
    public static boolean canCross(int[] stones) {

        /*
         * A frog is crossing a river. The river is divided into some number of units, and at each unit, there may or may not exist a stone. The frog can jump on a stone, but it must not jump into the water.

        * Given a list of stones positions (in units) in sorted ascending order,determine if the frog can cross the river by landing on the last stone. 
        Initially, the frog is on the first stone and assumes the first jump must be 1 unit.
        If the frog's last jump was k units, its next jump must be either k - 1, k, or k + 1 units. The frog can only jump in the forward direction.

        * Example 1:
        * Input: stones = [0,1,3,5,6,8,12,17]
        * Output: true
        * Explanation: The frog can jump to the last stone by jumping 1 unit to the 2nd stone, then 2 units to the 3rd stone, then 2 units to the 4th stone, then 3 units to the 6th stone, 4 units to the 7th stone, and 5 units to the 8th stone.

         */

        Map<Integer, Boolean> dp= new HashMap<>();
        return crossRiver(stones, 0, 1, dp);
    }

    public static void main(String[] args) {
        int[] heights = {10, 20, 30, 10};
        int[] dp = new int[heights.length];

        System.out.println("frog Jump using recursion and memoization" + frogJump(heights.length, heights, dp));
        System.out.println("frog Jum using DP - Space Complexity O(1) - Time Complexity O(N) - Free of stack space" + frogJump(heights.length, heights));
    }
}