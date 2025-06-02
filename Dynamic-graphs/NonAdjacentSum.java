import java.util.HashMap;

public class NonAdjacentSum {

    public static int nonAdjacentSum(int[] nums, int index, int nonAdjacentIndex, int maxi, HashMap<String, Integer> memo) {
        if (index + nonAdjacentIndex >= nums.length) return maxi;

        String key = Integer.toString(index).concat(",").concat(Integer.toString(nonAdjacentIndex));
        if ( memo.containsKey(key)) return memo.get(key);

        int nextAdjacentIndex = nonAdjacentIndex;
        int sum = nums[index];

        while (nextAdjacentIndex < nums.length) {

            sum += nums[nextAdjacentIndex];
            nextAdjacentIndex += 2;

        }

        int leftSumMaxi = nonAdjacentSum(nums, index, nonAdjacentIndex + 1, maxi > sum ? maxi : sum, memo);
        int rightSumMaxi = nonAdjacentSum(nums, index + 1, index + 3, Integer.MIN_VALUE, memo);
        
        int result = leftSumMaxi > rightSumMaxi ? leftSumMaxi : rightSumMaxi;

        memo.put(key, result);
        return result;
    }

    public static int nonAdjacentSum(int[] nums, int index, HashMap<Integer, Integer> memo) {
        if (index >= nums.length) return 0;
        if ( memo.containsKey(index)) return memo.get(index);

        int result = Math.max(
            nums[index] + nonAdjacentSum(nums, index + 2, memo),
            nonAdjacentSum(nums, index + 1, memo)
        );

        memo.put(index, result);
        return result;
    }

    public static int nonAdjacentSumTabulation( int[]nums) {
        if( nums.length == 0) return 0;
        if( nums.length == 1) return nums[0];

        int prev2 = nums[0];
        int prev1 = Math.max(nums[0], nums[1]);

        for( int i = 2; i < nums.length; i++) {
            int current = Math.max(nums[i] + prev2, prev1);
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }

    public static void main(String[] args) {
        // int[] nums = new int[]{2, 4, 5, 12, 7};
        int[] nums = new int[]{1,2,3,1};
        System.out.println(nonAdjacentSumTabulation(nums));
    }
}
