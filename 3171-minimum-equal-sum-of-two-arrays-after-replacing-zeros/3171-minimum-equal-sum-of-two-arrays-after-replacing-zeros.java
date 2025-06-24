class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long sum1 = 0, sum2 = 0;
        int zero1 = 0, zero2 = 0;

        // Calcular a soma e contar os zeros de nums1
        for (int num : nums1) {
            if (num == 0) zero1++;
            else sum1 += num;
        }

        // Calcular a soma e contar os zeros de nums2
        for (int num : nums2) {
            if (num == 0) zero2++;
            else sum2 += num;
        }

        // Se ambos têm zeros, sempre é possível equilibrar
        if (zero1 > 0 && zero2 > 0) {
            return Math.max(sum1 + zero1, sum2 + zero2);
        }

        // Se só nums1 tem zeros
        if (zero1 > 0) {
            // Precisamos que sum1 + zero1 * X == sum2, com X >= 1
            // A menor soma possível de nums1 é sum1 + zero1
            if (sum1 + zero1 > sum2) return -1;
            return sum2;
        }

        // Se só nums2 tem zeros
        if (zero2 > 0) {
            if (sum2 + zero2 > sum1) return -1;
            return sum1;
        }

        // Nenhum dos dois tem zeros
        return sum1 == sum2 ? sum1 : -1;
    }
}