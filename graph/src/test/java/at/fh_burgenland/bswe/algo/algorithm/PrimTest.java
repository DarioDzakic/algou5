package at.fh_burgenland.bswe.algo.algorithm;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import at.fh_burgenland.bswe.algo.graph.WeightedUndirectedGraph;
import at.fh_burgenland.bswe.algo.graph.WeightedUndirectedGraphImpl;
import java.util.List;

class PrimTest {

    @Test
        void testPrimOnSimpleGraph() {

            WeightedUndirectedGraph graph = new WeightedUndirectedGraphImpl();
            graph.addVertex("A");
            graph.addVertex("B");
            graph.addVertex("C");
            graph.addEdge("A", "B", 1);
            graph.addEdge("A", "C", 4);
            List<String> mst = Prim.prim(graph);
            assertEquals(2, mst.size());
            assertTrue(mst.contains("A-B:1"));
            assertTrue(mst.contains("A-C:4"));
        }

        @Test
        void testPrimOnTriangleGraph() {

            WeightedUndirectedGraph graph = new WeightedUndirectedGraphImpl();
            graph.addVertex("A");
            graph.addVertex("B");
            graph.addVertex("C");


            graph.addEdge("A", "B", 1);
            graph.addEdge("B", "C", 2);
            graph.addEdge("A", "C", 4);

            List<String> mst = Prim.prim(graph);

            assertEquals(2, mst.size());

            boolean hasAB1 = mst.contains("A-B:1") || mst.contains("B-A:1");
            boolean hasBC2 = mst.contains("B-C:2") || mst.contains("C-B:2");

            assertTrue(hasAB1);
            assertTrue(hasBC2);
        }

        @Test
        void testPrimOnBiggerGraph() {

            WeightedUndirectedGraph graph = new WeightedUndirectedGraphImpl();

            graph.addVertex("A");
            graph.addVertex("B");
            graph.addVertex("C");
            graph.addVertex("D");
            graph.addVertex("E");

            graph.addEdge("A", "B", 2);
            graph.addEdge("A", "C", 3);
            graph.addEdge("B", "C", 1);
            graph.addEdge("B", "D", 5);
            graph.addEdge("C", "D", 4);
            graph.addEdge("C", "E", 6);
            graph.addEdge("D", "E", 7);

            List<String> mst = Prim.prim(graph);

            assertEquals(4, mst.size());
            int totalWeight = 0;
            for (String edge : mst) {
                String[] parts = edge.split("[:-]");
                totalWeight += Integer.parseInt(parts[2]);
            }
            assertEquals(13, totalWeight);
        }

        @Test
        void testPrimOnEmptyGraph() {
            WeightedUndirectedGraph graph = new WeightedUndirectedGraphImpl();

            List<String> mst = Prim.prim(graph);
            assertTrue(mst.isEmpty());
        }
    }
