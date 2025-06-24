class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];
        int index = 0;
        for (int i = 0; i <= nums1.length - 1; i++) {
            nums[index] = nums1[i];
            index++;
        }
        for (int i = 0; i <= nums2.length - 1; i++) {
            nums[index] = nums2[i];
            index++;
        }
        
        Arrays.sort(nums);
        double media = 0.0;
        
        if (nums.length%2 == 1) {
            media = nums[nums.length/2];
        } else {
            int meta = (nums.length / 2) - 1;
            media = (nums[meta] + nums[meta + 1]) / 2.0;
        }

        return media;
    }
}