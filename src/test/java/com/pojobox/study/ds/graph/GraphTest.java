package com.pojobox.study.ds.graph;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GraphTest {

  @Test
  void test_basic_print_graph_success() {

    Graph graph = Fixtures.getBasicGraph();
    List<Node> nodes = graph.getNodes();

    System.out.println("Graph Matrix:");
    System.out.println();
    graph.printMatrix();
    System.out.println();

    System.out.println("Graph Adjacency List:");
    graph.printAdjList();

    System.out.println();
    System.out.println("Graph Adjacency List 2:");
    graph.printAdjList2();

    System.out.println();
    System.out.println("All Nodes:");
    for (Node node : nodes) {
      System.out.println(node.toString());
    }
  }

  @Test
  void test_basic_graph_adjacent_matrix() {

    Graph graph = Fixtures.getBasicGraph();
    List<Node> nodes = graph.getNodes();

    assertEquals(true, graph.hasEdge("L1", "L2"));
    assertEquals(true, graph.hasEdge("L1", "L4"));

    assertEquals(true, graph.hasEdge("L2", "L4"));

    assertEquals(true, graph.hasEdge("L4", "L1"));
    assertEquals(true, graph.hasEdge("L4", "L11"));
    assertEquals(true, graph.hasEdge("L4", "L55"));

    assertEquals(false, graph.hasEdge("L11", "L1"));

    assertEquals(true, graph.hasEdge("L55", "L1"));
    assertEquals(true, graph.hasEdge("L55", "L2"));
    assertEquals(false, graph.hasEdge("L55", "L11"));

  }

  @Test
  void test_basic_graph_adjacent_lists() {

    Graph graph = Fixtures.getBasicGraph();
    List<Node> nodes = graph.getNodes();

    assertEquals(true, graph.hasEdgeInAdjList("L1", "L2"));
    assertEquals(true, graph.hasEdgeInAdjList("L1", "L4"));

    assertEquals(true, graph.hasEdgeInAdjList("L2", "L4"));

    assertEquals(true, graph.hasEdgeInAdjList("L4", "L1"));
    assertEquals(true, graph.hasEdgeInAdjList("L4", "L11"));
    assertEquals(true, graph.hasEdgeInAdjList("L4", "L55"));

    assertEquals(false, graph.hasEdgeInAdjList("L11", "L1"));

    assertEquals(true, graph.hasEdgeInAdjList("L55", "L1"));
    assertEquals(true, graph.hasEdgeInAdjList("L55", "L2"));
    assertEquals(false, graph.hasEdgeInAdjList("L55", "L11"));

  }
}
