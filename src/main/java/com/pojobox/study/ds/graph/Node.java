package com.pojobox.study.ds.graph;

public class Node {

  private static final String DELIMITER = ",";

  private String id;

  private String value;

  private String value2;

  private String edges;

  public Node(String id, String value, String value2, String friends ) {
    this.id = id;
    this.value = value;
    this.value2 = value2;
    this.edges = friends;
  }

  public String getId() {
    return id;
  }

  public String getValue(){
    return value;
  };

  public String getValue2() {
    return this.value2;
  }

  public String getEdges() {
    return this.edges;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public String toString() {
    return new StringBuilder("")
        .append(this.id).append(DELIMITER)
        .append(this.value).append(DELIMITER)
        .append(this.value2).append(DELIMITER)
        .append(this.edges)
        .toString();
  }
}
