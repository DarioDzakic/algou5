package at.fh_burgenland.bswe.algo.graph;

public interface WeightedGraph extends Graph {

    @Override
    default void addEdge(String from, String to) {
        throw new UnsupportedOperationException("Not supported in WeightedGraph");
    }

    void addEdge(String from, String to, int weight);

    int getWeight(String from, String to);

}
