package at.fh_burgenland.bswe.algo;

import at.fh_burgenland.bswe.algo.graph.WeightedUndirectedGraph;
import at.fh_burgenland.bswe.algo.graph.WeightedUndirectedGraphImpl;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class Main {

    public static void main(String[] args) {
        WeightedUndirectedGraph undirectedGraph = new WeightedUndirectedGraphImpl();
        undirectedGraph.addVertex("a");
        undirectedGraph.addVertex("b");
        undirectedGraph.addVertex("c");
        undirectedGraph.addVertex("d");

        undirectedGraph.addEdge("a", "b", 11);
        undirectedGraph.getNumberOfEdges();
        undirectedGraph.getNeighbors("a");
        undirectedGraph.getNumberOfVertices();
        undirectedGraph.getWeight("a", "b");
        undirectedGraph.hasEdge("a", "b");
    }

}
