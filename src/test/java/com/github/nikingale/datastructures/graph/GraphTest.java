package com.github.nikingale.datastructures.graph;

import org.junit.Test;
import org.junit.Before;
import org.junit.Assert;

/**
 * @author Nikhil Ingale 06-01-2021
 */

public class GraphTest {

    UndirectedGraph graph = new UndirectedGraph();

    @Before
    public void setup() {
        graph.addVertex("Mumbai");
        graph.addVertex("Delhi");
        graph.addVertex("Bangalore");
        graph.addVertex("Pune");
        graph.addVertex("Kolkata");
        graph.addEdge("Mumbai", "Delhi");
        graph.addEdge("Mumbai", "Pune");
    }

    @Test
    public void testGetAdjacentVertices() {
        String expected = "[Mumbai, Delhi, Pune]";
        String actual = graph.breadthFirstTraversal("Mumbai").toString();
        Assert.assertEquals(expected, actual);

        graph.addEdge("Mumbai", "Bangalore");
        expected = "[Mumbai, Delhi, Pune, Bangalore]";
        actual = graph.breadthFirstTraversal("Mumbai").toString();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testBreadthFirstTraversal() {
        graph.addEdge("Mumbai", "Bangalore");
        graph.addEdge("Delhi", "Kolkata");

        String expected = "[Mumbai, Delhi, Pune, Bangalore, Kolkata]";
        String actual = graph.breadthFirstTraversal("Mumbai").toString();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testDepthFirstTraversal() {
        graph.addEdge("Mumbai", "Bangalore");
        graph.addVertex("Chennai");
        graph.addEdge("Bangalore", "Chennai");
        graph.addEdge("Delhi", "Kolkata");

        String expected = "[Mumbai, Bangalore, Chennai, Pune, Delhi, Kolkata]";
        String actual = graph.depthFirstTraversal("Mumbai").toString();
        Assert.assertEquals(expected, actual);
    }

}