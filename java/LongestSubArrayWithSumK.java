import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithSumK {

    public int subarray(int[] nums, int k, int tracker, int maxi) {
        if ( tracker == nums.length ) 
            return maxi;
        
        int sum = 0, ptr = tracker, cnt = 0;

        while (ptr < nums.length && sum < k){
            sum += nums[ptr];
            ptr += 1;
            cnt++;
        }

        if ( sum == k && cnt > maxi)
            return subarray(nums, k, tracker + 1, cnt);

        return subarray(nums, k, tracker + 1, maxi);
    }

    public int longestSubarray(int[] nums, int k) {
       return this.subarray(nums, k, 0, 0);
    }

    public int sumSubarray(int[] nums, int k, int tracker, int maxi) {
        if ( tracker == nums.length ) 
            return maxi;
        int sum=0, cnt = 0, ptr = tracker;

        while (ptr < nums.length) {
            sum += nums[ptr];
            if ( sum == k )
                cnt++;
            ptr++;
        }

        return sumSubarray(nums, k, tracker + 1, maxi + cnt);
    }

    public int sumOfAllSubarray(int[]nums, int k) {
        // return this.sumSubarray(nums, k,0, 0);
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);
        int sum = 0, cnt = 0;

        for( int i = 0; i < nums.length; i++) {
            sum += nums[i];

            int prefix = mp.getOrDefault(sum - k, 0);
            cnt += prefix;
            mp.put(sum, mp.getOrDefault(sum, 0) + 1);
        }

        return cnt;
    }


    public static void main(String[] args) {
        // int[] arr = new int[] {1,1,1};
        // System.out.println();
    }

}
