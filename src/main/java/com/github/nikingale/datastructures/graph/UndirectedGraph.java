package com.github.nikingale.datastructures.graph;

import java.util.*;

/**
 * @author Nikhil Ingale 06-01-2021
 */

public class UndirectedGraph implements Graph {

    private Map<Vertex, List<Vertex>> graph;

    public UndirectedGraph() {
        this.graph = new HashMap<>();
    }

    public UndirectedGraph(HashMap<Vertex, List<Vertex>> graph) {
        this.graph = graph;
    }

    public void addVertex(String label) {
        graph.putIfAbsent(new Vertex(label), new LinkedList<>());
    }

    public void removeVertex(String label) {
        Vertex vertex = new Vertex(label);
        graph.values().stream().forEach(e -> e.remove(vertex));
        graph.remove(new Vertex(label));
    }

    public void addEdge(String label1, String label2) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        graph.get(v1).add(v2);
        graph.get(v2).add(v1);
    }

    public void removeEdge(String label1, String label2) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        List<Vertex> v1AdjacentList = graph.get(v1);
        List<Vertex> v2AdjacentList = graph.get(v2);

        if (v1AdjacentList != null) {
            v1AdjacentList.remove(v2);
        }
        if (v2AdjacentList != null) {
            v2AdjacentList.remove(v1);
        }
    }

    public List<Vertex> getAdjacentVertices(String label) {
        Vertex vertex = new Vertex(label);
        List<Vertex> adjacentVertices = graph.get(vertex);
        return adjacentVertices;
    }

    public Set<String> breadthFirstTraversal(String root) {
        Set<String> visited = new LinkedHashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(root);
        visited.add(root);

        while (!queue.isEmpty()) {
            String vertex = queue.poll();
            for (Vertex v : getAdjacentVertices(vertex)) {
                if (!visited.contains(v.getLabel())) {
                    visited.add(v.getLabel());
                    queue.add(v.getLabel());
                }
            }
        }
        return visited;
    }

    public Set<String> depthFirstTraversal(String root) {
        Set<String> visited = new LinkedHashSet<>();
        Stack<String> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            String vertex = stack.pop();
            if (!visited.contains(vertex)) {
                visited.add(vertex);
                for (Vertex v : getAdjacentVertices(vertex)) {
                    stack.push(v.getLabel());
                }
            }
        }
        return visited;
    }

}