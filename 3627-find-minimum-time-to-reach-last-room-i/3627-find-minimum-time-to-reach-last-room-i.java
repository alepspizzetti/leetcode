import java.util.PriorityQueue;

class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;
        
        int[] dirs = {-1, 0, 1, 0, -1, 0};
        
        int[][] dist = new int[n][m];
        
        for (int[] row : dist) {
            java.util.Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        
        dist[0][0] = 0;
        pq.offer(new int[]{0, 0, 0});
        
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int time = current[0];
            int i = current[1];
            int j = current[2];
            
            if (i == n - 1 && j == m - 1) {
                return time;
            }
            
            for (int d = 0; d < 4; d++) {
                int ni = i + dirs[d];
                int nj = j + dirs[d + 1];
                
                
                if (ni >= 0 && ni < n && nj >= 0 && nj < m) {
                    int waitTime = moveTime[ni][nj]; 
                    int newTime = Math.max(time, waitTime) + 1;
                    
                    if (newTime < dist[ni][nj]) {
                        dist[ni][nj] = newTime;
                        pq.offer(new int[]{newTime, ni, nj});
                    }
                }
            }
        }
        
        return -1;
    }
}