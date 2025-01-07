package at.fh_burgenland.bswe.algo.algorithm;

import at.fh_burgenland.bswe.algo.graph.WeightedUndirectedGraph;

import java.util.*;

/**
 * Class implementing Prim's algorithm for finding the Minimum Spanning Tree (MST)
 * in a weighted undirected graph.
 */
public class Prim {

    /**
     * Returns a list of edges (in string format) representing the MST of the given weighted undirected graph.
     * Each edge in the resulting list is represented as "u-v:weight".
     *
     * @param graph a weighted undirected graph (must be connected)
     * @return a list of edges of the minimum spanning tree
     */
    public static List<String> prim(WeightedUndirectedGraph graph) {

        List<String> mstEdges = new ArrayList<>();

        Set<String> allVertices = graph.getVertices();
        if (allVertices.isEmpty()) {
            return mstEdges;
        }

        Iterator<String> it = allVertices.iterator();
        String startVertex = it.next();

        Set<String> visited = new HashSet<>();
        visited.add(startVertex);

        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(edge -> edge.weight));

        for (String neighbor : graph.getNeighbors(startVertex)) {
            int weight = graph.getWeight(startVertex, neighbor);
            pq.offer(new Edge(startVertex, neighbor, weight));
        }

        while (visited.size() < allVertices.size() && !pq.isEmpty()) {
            Edge edge = pq.poll();

            if (!visited.contains(edge.to)) {
                visited.add(edge.to);

                mstEdges.add(edge.from + "-" + edge.to + ":" + edge.weight);

                for (String neighbor : graph.getNeighbors(edge.to)) {
                    if (!visited.contains(neighbor)) {
                        pq.offer(new Edge(edge.to, neighbor, graph.getWeight(edge.to, neighbor)));
                    }
                }
            }
        }
        return mstEdges;
    }

    private static class Edge {
        String from;
        String to;
        int weight;

        public Edge(String from, String to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
}
