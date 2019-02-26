/*
 * Given the head of a graph, return a deep copy (clone) of the graph.
 * Each node in the graph contains a label (int) and a list (List[UndirectedGraphNode]) of its neighbors.
 * There is an edge between the given node and each of the nodes in its neighbors.
 */
 /**
  * Definition for undirected graph.
  * class UndirectedGraphNode {
  *     int label;
  *     List<UndirectedGraphNode> neighbors;
  *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
  * };
  */

// BFS solution
// Runtime: 4 ms, faster than 60.02% of Java online submissions for Clone Graph.
// Memory Usage: 29 MB, less than 13.24% of Java online submissions for Clone Graph.
// My Submission: https://leetcode.com/submissions/detail/206154667/
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;

        // Create a map to store visited nodes
        Map<Integer, UndirectedGraphNode> cache = new HashMap<>();
        cache.put(node.label, new UndirectedGraphNode(node.label));

        // Use Queue for BFS
        Deque<UndirectedGraphNode> queue = new ArrayDeque<>();
        queue.addLast(node);

        // Process unvisited nodes
        while (!queue.isEmpty()) {
            UndirectedGraphNode n = queue.removeFirst();

            for (UndirectedGraphNode neighbor : n.neighbors) {
                if (!cache.containsKey(neighbor.label)) {
                    cache.put(neighbor.label, new UndirectedGraphNode(neighbor.label));
                    queue.addLast(neighbor);
                }
                cache.get(n.label).neighbors.add(cache.get(neighbor.label));
            }
        }

        return cache.get(node.label);
    }
}

// DFS Solution
// Runtime: 3 ms, faster than 79.87% of Java online submissions for Clone Graph.
// Memory Usage: 29.6 MB, less than 0.95% of Java online submissions for Clone Graph.
// My Submission: https://leetcode.com/submissions/detail/206149552/
public class Solution {
    Map<Integer, UndirectedGraphNode> nodes = new HashMap<>();

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;

        UndirectedGraphNode start = new UndirectedGraphNode(node.label);
        nodes.put(start.label, start);

        traverse(node);

        return start;
    }

    private void traverse(UndirectedGraphNode node) {
        UndirectedGraphNode copy = nodes.get(node.label);

        for (UndirectedGraphNode n : node.neighbors) {
            if (!nodes.containsKey(n.label)) nodes.put(n.label, new UndirectedGraphNode(n.label));
            UndirectedGraphNode neighborCopy = nodes.get(n.label);
            copy.neighbors.add(neighborCopy);
            if (neighborCopy.neighbors.isEmpty()) traverse(n);
        }
    }
}
