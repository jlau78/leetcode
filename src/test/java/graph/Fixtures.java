package graph;


import com.pojobox.study.ds.graph.Graph;
import com.pojobox.study.ds.graph.Node;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Fixtures {

  static final String FILE_STUDENTS = "data/dataStudents.txt";

  static List<String> readData(String filename) throws IOException {
    return Files.readAllLines(new File(filename).getAbsoluteFile().toPath());
  }

  public static Graph getBasicGraph() {
    List<Node> nodes = getBasicNodes();
    Graph graph = new Graph(nodes.size());

    nodes.stream()
        .forEach(node -> {
          graph.addNode(node);
        });

    nodes.stream()
        .forEach(node -> {
          String friends = node.getFriends();
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

  public static List<Node> getBasicNodes() {
    List<Node> nodes = new ArrayList<>();
    try {
      readData(FILE_STUDENTS).stream()
          .filter(row -> Objects.nonNull(row))
          .map(row -> row.split(","))
          .forEach(row -> {
            var friends = row.length == 4 ? row[3] : "";
            nodes.add(new Node(row[0], row[1], row[2], friends));
          });

    } catch (IOException e) {
      throw new RuntimeException("Unable to read data", e);
    }

    return nodes;
  }

}
