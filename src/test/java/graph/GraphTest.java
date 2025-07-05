package graph;

import com.pojobox.study.ds.graph.Graph;
import com.pojobox.study.ds.graph.Node;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;


public class GraphTest {


  @Test
  void test_basic_graph() {

    Graph graph = Fixtures.getBasicGraph();

    List<Node> nodes = graph.getNodes();

//    IntStream firstStream = Arrays.stream(matrix).flatMapToInt(f -> {
//      System.out.println("firstStream: " + f);
//      return null;
//    });

    graph.printMatrix();

    System.out.println();
    System.out.println("All Nodes:");
    for (Node node : nodes) {
      System.out.println(node.toString());
    }

  }

}
