class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long low = -100_000L * 100_000L;
        long high = 100_000L * 100_000L;

        while (low < high) {
            long mid = low + (high - low) / 2;

            if (countLessEqual(nums1, nums2, mid) < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    // Conta quantos produtos nums1[i] * nums2[j] <= x
    private long countLessEqual(int[] nums1, int[] nums2, long x) {
        long count = 0;

        for (int a : nums1) {
            if (a > 0) {
                // busca quantos b em nums2 com a*b <= x
                int left = 0, right = nums2.length;
                while (left < right) {
                    int mid = (left + right) / 2;
                    if ((long)a * nums2[mid] <= x) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                count += left;
            } else if (a < 0) {
                // busca quantos b em nums2 com a*b <= x
                int left = 0, right = nums2.length;
                while (left < right) {
                    int mid = (left + right) / 2;
                    if ((long)a * nums2[mid] <= x) {
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                }
                count += nums2.length - left;
            } else {
                // a == 0: todo produto 0 <= x se x >= 0
                if (x >= 0) count += nums2.length;
            }
        }

        return count;
    }
}