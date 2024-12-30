package at.fh_burgenland.bswe.algo.graph;

import java.util.*;

public class WeightedDirectedGraphImpl  implements WeightedDirectedGraph{
    Map<String, Map<String, Integer>> graph;

    public WeightedDirectedGraphImpl(){
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
        if (graph.containsKey(vertex)) {
            List<String> neighbors = new ArrayList<>(graph.get(vertex).keySet());
            for (String neighbor : neighbors) {
                removeEdge(vertex, neighbor);
            }
            graph.remove(vertex);
        }
    }

    /**
     * @param from
     * @param to
     * @return
     */
    @Override
    public boolean hasEdge(String from, String to) {
        if(graph.containsKey(from) && graph.containsKey(to)){
            return this.graph.get(from).containsKey(to);
        }
        return false;
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
        int count = 0;
        for (Map<String, Integer> edges : this.graph.values()) {
            count += edges.size();
        }
        return count;
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
