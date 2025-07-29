class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        int[] lastSeen = new int[32]; // guarda última posição de cada bit
        Arrays.fill(lastSeen, -1);

        // Anda do final para o início
        for (int i = n - 1; i >= 0; i--) {
            for (int b = 0; b < 32; b++) {
                if (((nums[i] >> b) & 1) == 1) {
                    lastSeen[b] = i; // este bit foi visto na posição i
                }
            }

            int maxReach = i;
            for (int b = 0; b < 32; b++) {
                if (lastSeen[b] != -1) {
                    maxReach = Math.max(maxReach, lastSeen[b]);
                }
            }

            answer[i] = maxReach - i + 1;
        }

        return answer;
    }
}