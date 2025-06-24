public class Solution {
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        long total = 0;
        int left = 0;
        long count = 0;

        for (int right = 0; right < n; right++) {
            total += nums[right];

            while (left <= right && total * (right - left + 1) >= k) {
                total -= nums[left];
                left++;
            }

            count += (right - left + 1);
        }

        return count;
    }
}