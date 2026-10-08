// class Solution {

//     boolean dfs(int node, int currentColor, int[] color, int[][] graph) {

//         color[node] = currentColor;

//         for (int neighbour : graph[node]) {

//             // Neighbour is not colored yet
//             if (color[neighbour] == -1) {

//                 if (!dfs(neighbour, 1 - currentColor, color, graph)) {
//                     return false;
//                 }

//             }
//             // Neighbour has same color
//             else if (color[neighbour] == currentColor) {

//                 return false;
//             }
//         }

//         return true;
//     }

//     public boolean isBipartite(int[][] graph) {

//         int n = graph.length;

//         // -1 = not colored
//         //  0 = first group
//         //  1 = second group
//         int[] color = new int[n];

//         for (int i = 0; i < n; i++) {
//             color[i] = -1;
//         }

//         // Graph may be disconnected
//         for (int i = 0; i < n; i++) {

//             if (color[i] == -1) {

//                 if (!dfs(i, 0, color, graph)) {
//                     return false;
//                 }
//             }
//         }

//         return true;
//     }
// }



class Solution {

    int cycleLength;

    boolean dfs(int node, int parent,
                int[][] graph,
                boolean[] visited,
                int[] depth) {

        visited[node] = true;

        for (int neighbour : graph[node]) {

            if (neighbour == parent) {
                continue;
            }

            if (!visited[neighbour]) {

                depth[neighbour] = depth[node] + 1;

                if (dfs(neighbour, node, graph,
                        visited, depth)) {
                    return true;
                }

            } else {

                // Cycle found
                cycleLength = depth[node] - depth[neighbour] + 1;

                // Odd cycle
                if (cycleLength % 2 == 1) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean isBipartite(int[][] graph) {

        int n = graph.length;

        boolean[] visited = new boolean[n];
        int[] depth = new int[n];

        for (int i = 0; i < n; i++) {

            if (!visited[i]) {

                depth[i] = 0;

                if (dfs(i, -1, graph,
                        visited, depth)) {
                    return false;
                }
            }
        }

        return true;
    }
}