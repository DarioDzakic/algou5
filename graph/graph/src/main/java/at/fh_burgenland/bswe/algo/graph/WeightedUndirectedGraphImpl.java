package at.fh_burgenland.bswe.algo.graph;

import java.util.*;

public class WeightedUndirectedGraphImpl implements WeightedUndirectedGraph{
    Map<String, Map<String, Integer>> graph;

    public WeightedUndirectedGraphImpl(){
        graph = new HashMap<>();
    }

    /**
     * @param label
     */
    @Override
    public void addVertex(String label) {
        graph.put(label, new HashMap<>());
    }

    /**
     * @param vertex
     * @return
     */
    @Override
    public boolean hasVertex(String vertex) {
        return this.graph.containsKey(vertex);
    }

    /**
     * @param vertex
     */
    @Override
    public void removeVertex(String vertex) {
        this.graph.remove(vertex);
    }

    /**
     * @param from
     * @param to
     * @return
     */
    @Override
    public boolean hasEdge(String from, String to) {
        return this.graph.get(from).containsKey(to);
    }

    /**
     * @param from
     * @param to
     */
    @Override
    public void removeEdge(String from, String to) {
        this.graph.get(from).remove(to);
    }

    /**
     * @param vertex
     * @return
     */
    @Override
    public List<String> getNeighbors(String vertex) {
        return this.graph.get(vertex).keySet().stream().toList();
    }

    /**
     * @return
     */
    @Override
    public Set<String> getVertices() {
        return this.graph.keySet();
    }

    /**
     * @return
     */
    @Override
    public int getNumberOfVertices() {
        return this.graph.keySet().size();
    }

    /**
     * @return
     */
    @Override
    public int getNumberOfEdges() {
        return this.graph.size();
    }

    /**
     * @param from
     * @param to
     * @param weight
     */
    @Override
    public void addEdge(String from, String to, int weight) {
        this.graph.get(from).put(to, weight);
    }

    /**
     * @param from
     * @param to
     * @return
     */
    @Override
    public int getWeight(String from, String to) {
        return this.graph.get(from).get(to);
    }
}
