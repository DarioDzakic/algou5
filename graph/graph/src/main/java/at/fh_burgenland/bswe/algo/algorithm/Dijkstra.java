package at.fh_burgenland.bswe.algo.algorithm;

import at.fh_burgenland.bswe.algo.graph.WeightedDirectedGraph;

import java.util.List;
import java.util.Map;

public class Dijkstra {

    /**
     * Calculates the shortest path from the start vertex to all other vertices in the graph.
     *
     * @param graph The graph to calculate the shortest path on
     * @param start The start vertex
     * @return A map containing the shortest distances from the start vertex to all other vertices
     */
    public static Map<String, Integer> dijkstra(WeightedDirectedGraph graph, String start) {
        // TODO: Implement Dijkstra's algorithm
        return null;
    }

    /**
     * Returns the shortest path from the start vertex to the end vertex.
     *
     * @param distances A map containing the shortest distances from the start vertex to all other vertices
     * @param start     The start vertex
     * @param end       The end vertex
     * @return A list containing the vertices of the shortest path from the start vertex to the end vertex
     */
    public static List<String> getShortestPath(Map<String, Integer> distances, String start, String end) {
        // TODO: Implement getting the shortest path
        return null;
    }
}
