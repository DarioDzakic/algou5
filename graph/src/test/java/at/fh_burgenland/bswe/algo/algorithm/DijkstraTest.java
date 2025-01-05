package at.fh_burgenland.bswe.algo.algorithm;

import at.fh_burgenland.bswe.algo.graph.WeightedDirectedGraphImpl;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class DijkstraTest {

    @Test
    void dijkstra() {
        WeightedDirectedGraphImpl graph = new WeightedDirectedGraphImpl();

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");

        graph.addEdge("A", "B", 1);
        graph.addEdge("A", "C", 4);
        graph.addEdge("B", "C", 2);
        graph.addEdge("B", "D", 6);
        graph.addEdge("C", "D", 3);

        Map<String, Integer> distances = Dijkstra.dijkstra(graph, "A");

        assertEquals(0, distances.get("A"));
        assertEquals(1, distances.get("B"));
        assertEquals(3, distances.get("C"));
        assertEquals(6, distances.get("D"));
    }

    @Test
    void getShortestPath() {
        WeightedDirectedGraphImpl graph = new WeightedDirectedGraphImpl();

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");

        graph.addEdge("A", "B", 1);
        graph.addEdge("A", "C", 4);
        graph.addEdge("B", "C", 2);
        graph.addEdge("B", "D", 6);
        graph.addEdge("C", "D", 3);

        List<String> path = Dijkstra.getShortestPath(graph, "A", "D");

        assertNotNull(path);
        assertEquals(List.of("A", "B", "C", "D"), path);
    }

    @Test
    void getShortestPath2() {
        WeightedDirectedGraphImpl graph = new WeightedDirectedGraphImpl();

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");

        graph.addEdge("A", "B", 2);
        graph.addEdge("A", "C", 1);
        graph.addEdge("C", "D", 1);
        graph.addEdge("D", "E", 1);
        graph.addEdge("B", "E", 5);

        List<String> path = Dijkstra.getShortestPath(graph, "A", "E");

        assertNotNull(path);
        assertEquals(List.of("A", "C", "D", "E"), path); // Shortest path
    }

    @Test
    void dijkstraWithInvalidStartVertex() {
        WeightedDirectedGraphImpl graph = new WeightedDirectedGraphImpl();

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addEdge("A", "B", 1);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> Dijkstra.dijkstra(graph, "Z"));
        assertEquals("Invalid start vertex", exception.getMessage());
    }
    @Test
    void getShortestPathDisconnectedGraph() {
        WeightedDirectedGraphImpl graph = new WeightedDirectedGraphImpl();

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");

        graph.addEdge("A", "B", 1);

        List<String> path = Dijkstra.getShortestPath(graph, "A", "C");

        assertNotNull(path);
        assertTrue(path.isEmpty()); // No path exists
    }
}
