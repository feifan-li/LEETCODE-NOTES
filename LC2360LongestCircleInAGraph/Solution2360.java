package LC2360LongestCircleInAGraph;

import java.util.HashMap;
import java.util.Map;

public class Solution2360 {
    int ans = -1;
    boolean[] visited;
    public void dfs(int node, int[] edges, Map<Integer, Integer> dist) {
        visited[node] = true;
        int neighbor = edges[node];
        if(neighbor==-1) return;
        if (!visited[neighbor]) {
            dist.put(neighbor, dist.get(node) + 1);
            dfs(neighbor, edges, dist);
        } else if (dist.containsKey(neighbor)) {
            ans = Math.max(ans, dist.get(node) - dist.get(neighbor) + 1);
        }
    }

    public int longestCycle(int[] edges) {
        int n = edges.length;
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                Map<Integer, Integer> dist = new HashMap<>();
                dist.put(i, 1);//offset
                dfs(i, edges, dist);
            }
        }
        return ans;
    }
}
