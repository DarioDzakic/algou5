package at.fh_burgenland.bswe.algo.graph;

import java.util.List;
import java.util.Set;

public interface Graph {

    void addVertex(String label);

    boolean hasVertex(String vertex);

    void removeVertex(String vertex);

    void addEdge(String from, String to);

    boolean hasEdge(String from, String to);

    void removeEdge(String from, String to);

    List<String> getNeighbors(String vertex);

    Set<String> getVertices();

    int getNumberOfVertices();

    int getNumberOfEdges();

}
