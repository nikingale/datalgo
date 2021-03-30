package com.github.nikingale.datastructures.graph;

/**
 * @author Nikhil Ingale 06-01-2021
 */

public class Vertex {

    private String label;

    public Vertex(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return label;
    }

}