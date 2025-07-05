package com.pojobox.study.ds.graph;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class GraphProcessor {

  public static Graph createGraph(List<String> rows) {

    List<Node> nodes = getBasicNodes(rows);
    Graph graph = new Graph(nodes.size());

    nodes.stream()
        .forEach(node -> {
          graph.addNode(node);
        });

    nodes.stream()
        .forEach(node -> {
          String friends = node.getEdges();
          if (friends.indexOf("-") > -1) {
            Arrays.stream(friends.split("-"))
                .forEach(friend -> {
                  graph.addEdge(node.getId(), friend);
                });
          } else if (StringUtils.isNotBlank(friends)) {
            graph.addEdge(node.getId(), friends.trim());
          }
        });

    return graph;
  }

  /**
   * This method depneds on the data with the format
   * id,name,grade,friends
   * L1,Jon Turret,A,L2-L4
   *
   * Todo: Use DSL or other mechanism to the data-columns instead of getting row-array value by index, e.g. row[1]
   * Ideal format should be: row("id"), row("data"), row("edges")
   *
   * @param rows
   * @return
   */
  public static List<Node> getBasicNodes(List<String> rows) {
    List<Node> nodes = new ArrayList<>();
       rows.stream()
          .filter(row -> Objects.nonNull(row))
          .map(row -> row.split(","))
          .forEach(row -> {
            var friends = row.length == 4 ? row[3] : "";
            nodes.add(new Node(row[0], row[1], row[2], friends));
          });

    return nodes;
  }

}