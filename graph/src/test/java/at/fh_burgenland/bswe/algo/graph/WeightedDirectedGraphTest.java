package at.fh_burgenland.bswe.algo.graph;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class WeightedDirectedGraphTest {

    @Test
    void addVertex() {
        WeightedDirectedGraphImpl graph = new WeightedDirectedGraphImpl();
        graph.addVertex("A");
        assertTrue(graph.hasVertex("A"));
    }

    @Test
    void hasVertex() {
        WeightedDirectedGraphImpl graph = new WeightedDirectedGraphImpl();
        graph.addVertex("B");
        assertTrue(graph.hasVertex("B"));
        assertFalse(graph.hasVertex("C"));
    }

    @Test
    void removeVertex() {
        WeightedDirectedGraphImpl graph = new WeightedDirectedGraphImpl();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addEdge("A", "B", 69);
        graph.removeVertex("A");
        assertFalse(graph.hasVertex("A"));
        assertFalse(graph.hasEdge("A", "B"));
    }

    @Test
    void addEdge() {
        WeightedDirectedGraphImpl graph = new WeightedDirectedGraphImpl();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addEdge("A", "B", 10);
        assertTrue(graph.hasEdge("A", "B"));
        assertEquals(10, graph.getWeight("A", "B"));
    }

    @Test
    void hasEdge() {
        WeightedDirectedGraphImpl graph = new WeightedDirectedGraphImpl();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addEdge("A", "B", 20);
        assertTrue(graph.hasEdge("A", "B"));
        assertFalse(graph.hasEdge("B", "A"));
    }

    @Test
    void removeEdge() {
        WeightedDirectedGraphImpl graph = new WeightedDirectedGraphImpl();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addEdge("A", "B", 69);
        graph.removeEdge("A", "B");
        assertFalse(graph.hasEdge("A", "B"));
    }

    @Test
    void getNeighbors() {
        WeightedDirectedGraphImpl graph = new WeightedDirectedGraphImpl();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addEdge("A", "B", 5);
        graph.addEdge("A", "C", 10);
        List<String> neighbors = graph.getNeighbors("A");
        assertTrue(neighbors.contains("B"));
        assertTrue(neighbors.contains("C"));
        assertFalse(neighbors.contains("A"));
    }

    @Test
    void getWeight() {
        WeightedDirectedGraphImpl graph = new WeightedDirectedGraphImpl();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addEdge("A", "B", 25);
        assertEquals(25, graph.getWeight("A", "B"));
    }

    @Test
    void getVertices() {
        WeightedDirectedGraphImpl graph = new WeightedDirectedGraphImpl();
        graph.addVertex("A");
        graph.addVertex("B");
        Set<String> vertices = graph.getVertices();
        assertTrue(vertices.contains("A"));
        assertTrue(vertices.contains("B"));
        assertEquals(2, vertices.size());
    }

    @Test
    void getNumberOfVertices() {
        WeightedDirectedGraphImpl graph = new WeightedDirectedGraphImpl();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        assertEquals(3, graph.getNumberOfVertices());
    }

    @Test
    void getNumberOfEdges() {
        WeightedDirectedGraphImpl graph = new WeightedDirectedGraphImpl();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addEdge("A", "B", 10);
        graph.addEdge("A", "C", 15);
        assertEquals(2, graph.getNumberOfEdges());
    }
    @Test
    void addEdgeToNonExistentVertex() {
        WeightedDirectedGraphImpl graph = new WeightedDirectedGraphImpl();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> graph.addEdge("A", "B", 10));
        assertEquals("One or both vertices do not exist", exception.getMessage());
    }

    @Test
    void removeNonExistentVertex() {
        WeightedDirectedGraphImpl graph = new WeightedDirectedGraphImpl();
        graph.addVertex("A");
        graph.removeVertex("B");
        assertTrue(graph.hasVertex("A"));
    }

    @Test
    void removeNonExistentEdge() {
        WeightedDirectedGraphImpl graph = new WeightedDirectedGraphImpl();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.removeEdge("A", "B");
        assertFalse(graph.hasEdge("A", "B"));
    }

    @Test
    void getWeightOfNonExistentEdge() {
        WeightedDirectedGraphImpl graph = new WeightedDirectedGraphImpl();
        graph.addVertex("A");
        graph.addVertex("B");
        assertEquals(Integer.MAX_VALUE, graph.getWeight("A", "B"));
    }

    @Test
    void largeGraph() {
        WeightedDirectedGraphImpl graph = new WeightedDirectedGraphImpl();
        for (int i = 0; i < 1000; i++) {
            graph.addVertex("V" + i);
        }
        for (int i = 0; i < 999; i++) {
            graph.addEdge("V" + i, "V" + (i + 1), i);
        }
        assertEquals(1000, graph.getNumberOfVertices());
        assertEquals(999, graph.getNumberOfEdges());
    }

    @Test
    void cyclicGraph() {
        WeightedDirectedGraphImpl graph = new WeightedDirectedGraphImpl();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addEdge("A", "B", 5);
        graph.addEdge("B", "C", 10);
        graph.addEdge("C", "A", 15);
        assertTrue(graph.hasEdge("A", "B"));
        assertTrue(graph.hasEdge("B", "C"));
        assertTrue(graph.hasEdge("C", "A"));
    }
}
