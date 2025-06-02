public class Dp {
    public static void main(String[] args) {
        int[] arr = new int[]{10 ,20 ,30 ,10};
        System.out.println(jumpFrog(0, arr));
    }

    public static int countNumberOfWays(int n) {
        if( n == 0) return 0;
        if ( n <= 2) return n;

        return countNumberOfWays(n -1) + countNumberOfWays(n -2);
    }

    public static int jumpFrog(int i, int[] nums, int[] memo) {
        if( i + 1 >= nums.length || i + 2 >= nums.length) return 0;
        if( memo[i] != -1) return memo[i];

        int totalEnergytoJump1 = (Math.abs(nums[i] - nums[i+1]) + jumpFrog(i + 1, nums, memo));
        int totalEnergytoJump2 = (Math.abs(nums[i] - nums[i+2]) + jumpFrog(i + 2, nums, memo));

        int result =  Math.min(totalEnergytoJump1, totalEnergytoJump2);
        memo[i]= result;
        return result;
    }

    public static int jumpFrog(int n, int[] nums) {
        int prev2 = 0;
        int prev1 = Math.abs(nums[1] - nums[0]);

        for( int i= 2; i <nums.length; i++) {
            int result1 = Math.abs(nums[i] - nums[i -1]) + prev1;
            int result2 = Math.abs(nums[i] - nums[i - 2]) + prev2;

            prev2 = prev1;
            prev1 = Math.min(result1, result2);
        }
        return prev1;
    }

    
}
