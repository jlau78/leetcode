package com.pojobox.study.ds.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Learing Graph DS - https://www.youtube.com/watch?v=CBYHwZcbD-s
 */
public class Graph {

  final List<Node> nodes = new ArrayList<>();

  int[][] matrix;

  List<LinkedList<Node>> adjList;

  public Graph() {
    this(11);
  }

  public Graph(int size) {
    matrix = new int[size][size];

    LinkedList<Node> nodeList = new LinkedList<>();
    adjList = new ArrayList<>();
    adjList.add(nodeList);

  }

  public void addNode(Node node) {
    Optional.ofNullable(node)
            .ifPresent( (n) -> {
                  nodes.add(n);
                }
            );
  }

  public void addEdge(String sourceId, String destId) {
    int sourceNodeIndex = findNodeIndex(sourceId);
    int destNodeIndex = findNodeIndex(destId);

    if (destNodeIndex != -1) {
      matrix[sourceNodeIndex][destNodeIndex] = 1;
    }
  }

  public boolean hasEdge(int source, int destination) {
    if (matrix[source][destination] == 1) {
      return true;
    } else {
      return false;
    }
  }

  public Node findNode(int id) {
    return this.nodes.stream()
        .filter(node -> Integer.valueOf(node.getId()) == id)
        .findFirst()
        .orElse(null);
  }

  public int findNodeIndex(String id) {
    AtomicInteger index = new AtomicInteger(0);
    Node found = this.nodes.stream()
        .peek(node -> index.incrementAndGet())
        .filter(node -> node.getId().equals(id))
        .findFirst()
        .orElse(null);

    if (Objects.nonNull(found)) {
      return index.get() - 1;
    } else {
      return -1;
    }
  }

  public Node getNodeByIndex(int index) {
    return this.nodes.get(index);
  }

  public List<Node> getNodes() {
    return this.nodes;
  }

  public int[][] getMatrix() {
    return this.matrix;
  }

  // Adjust the padding size to display the matrix. Especially if the Node id is long
  static final int PADDING_SIZE = 5;

  static final String padding = " ".repeat(PADDING_SIZE);

  public void printMatrix() {
    System.out.print(padding);
    this.nodes.stream()
        .forEach(node -> System.out.print(" " + node.getId()));

    System.out.println();
    for (int i=0; i < matrix.length; i++) {

      System.out.print((getNodeByIndex(i).getId() + padding ).substring(0,PADDING_SIZE + 1));

      for (int j=0; j < matrix[i].length; j++) {
        System.out.print(matrix[i][j] + "  ");
      }
      System.out.println();
    }
  }

}
