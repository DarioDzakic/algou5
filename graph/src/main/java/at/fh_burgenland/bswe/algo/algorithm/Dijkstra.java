package at.fh_burgenland.bswe.algo.algorithm;

import at.fh_burgenland.bswe.algo.graph.WeightedDirectedGraph;

import java.util.*;

public class Dijkstra {

    /**
     * Calculates the shortest path from the start vertex to all other vertices in the graph.
     *
     * @param graph The graph to calculate the shortest path on
     * @param start The start vertex
     * @return A map containing the shortest distances from the start vertex to all other vertices
     */
    public static Map<String, Integer> dijkstra(WeightedDirectedGraph graph, String start) {
        if(!graph.hasVertex(start)){
            throw new IllegalArgumentException("Invalid start vertex");
        }
        Map<String, Integer> distances = new HashMap<>();
        PriorityQueue<String> pq = new PriorityQueue<>(Comparator.comparingInt(distances::get));
        Set<String> visited = new HashSet<>();
        for (String vertex : graph.getVertices()) {
            distances.put(vertex, Integer.MAX_VALUE);
        }
        distances.put(start, 0);
        pq.add(start);
        while (!pq.isEmpty()) {
            String current = pq.poll();

            if (!visited.contains(current)) {
                visited.add(current);
                for (String neighbor : graph.getNeighbors(current)) {
                    int newDist = distances.get(current) + graph.getWeight(current, neighbor);
                    if (newDist < distances.get(neighbor)) {
                        distances.put(neighbor, newDist);
                        pq.add(neighbor);
                    }
                }
            }
        }

        return distances;
    }

    /**
     * Returns the shortest path from the start vertex to the end vertex.
     *
     * @param graph     The graph to calculate the shortest path on
     * @param start     The start vertex
     * @param end       The end vertex
     * @return A list containing the vertices of the shortest path from the start vertex to the end vertex
     */
    public static List<String> getShortestPath(WeightedDirectedGraph graph, String start, String end) {
        Map<String, Integer> distances = dijkstra(graph, start);
        Map<String, String> predecessors = new HashMap<>();
        for (String current : graph.getVertices()) {
            for (String neighbor : graph.getNeighbors(current)) {
                int currentDistance = distances.get(current);
                int edgeWeight = graph.getWeight(current, neighbor);
                if (distances.get(neighbor) == currentDistance + edgeWeight) {
                    predecessors.put(neighbor, current);
                }
            }
        }
        List<String> path = new LinkedList<>();
        for (String at = end; at != null; at = predecessors.get(at)) {
            path.add(0, at);
        }
        if (!path.isEmpty() && !path.get(0).equals(start)) {
            return Collections.emptyList();
        }
        return path;
    }

}
