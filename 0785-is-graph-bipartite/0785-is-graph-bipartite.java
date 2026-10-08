class Solution {

    boolean dfs(int node, int currentColor, int[] color, int[][] graph) {

        color[node] = currentColor;

        for (int neighbour : graph[node]) {

            // Neighbour is not colored yet
            if (color[neighbour] == -1) {

                if (!dfs(neighbour, 1 - currentColor, color, graph)) {
                    return false;
                }

            }
            // Neighbour has same color
            else if (color[neighbour] == currentColor) {

                return false;
            }
        }

        return true;
    }

    public boolean isBipartite(int[][] graph) {

        int n = graph.length;

        // -1 = not colored
        //  0 = first group
        //  1 = second group
        int[] color = new int[n];

        for (int i = 0; i < n; i++) {
            color[i] = -1;
        }

        // Graph may be disconnected
        for (int i = 0; i < n; i++) {

            if (color[i] == -1) {

                if (!dfs(i, 0, color, graph)) {
                    return false;
                }
            }
        }

        return true;
    }
}