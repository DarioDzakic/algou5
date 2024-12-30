package at.fh_burgenland.bswe.algo.graph;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class WeightedUndirectedGraphTest {

    private WeightedUndirectedGraphImpl graph;

    @BeforeEach
    void setUp() {
        graph = new WeightedUndirectedGraphImpl();
    }

    @Test
    void addVertex() {
        graph.addVertex("A");
        assertTrue(graph.hasVertex("A"));
    }

    @Test
    void hasVertex() {
        graph.addVertex("A");
        assertTrue(graph.hasVertex("A"));
        assertFalse(graph.hasVertex("B"));
    }

    @Test
    void removeVertex() {
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addEdge("A", "B", 1);
        graph.removeVertex("A");
        assertFalse(graph.hasVertex("A"));
        assertFalse(graph.hasEdge("A", "B"));
    }

    @Test
    void addEdge() {
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addEdge("A", "B", 5);
        assertTrue(graph.hasEdge("A", "B"));
        assertEquals(5, graph.getWeight("A", "B"));
    }

    @Test
    void hasEdge() {
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addEdge("A", "B", 5);
        assertTrue(graph.hasEdge("A", "B"));
        assertFalse(graph.hasEdge("A", "C"));
    }

    @Test
    void removeEdge() {
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addEdge("A", "B", 5);
        graph.removeEdge("A", "B");
        assertFalse(graph.hasEdge("A", "B"));
    }

    @Test
    void getNeighbors() {
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addEdge("A", "B", 2);
        graph.addEdge("A", "C", 3);
        List<String> neighbors = graph.getNeighbors("A");
        assertEquals(2, neighbors.size());
        assertTrue(neighbors.contains("B"));
        assertTrue(neighbors.contains("C"));
    }

    @Test
    void getWeight() {
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addEdge("A", "B", 10);
        assertEquals(10, graph.getWeight("A", "B"));
    }

    @Test
    void getVertices() {
        graph.addVertex("A");
        graph.addVertex("B");
        Set<String> vertices = graph.getVertices();
        assertEquals(2, vertices.size());
        assertTrue(vertices.contains("A"));
        assertTrue(vertices.contains("B"));
    }

    @Test
    void getNumberOfVertices() {
        graph.addVertex("A");
        graph.addVertex("B");
        assertEquals(2, graph.getNumberOfVertices());
    }

    @Test
    void getNumberOfEdges() {
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addEdge("A", "B", 1);
        assertEquals(1, graph.getNumberOfEdges());
    }
}
