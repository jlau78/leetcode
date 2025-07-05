package com.pojobox.study.ds.graph;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class Fixtures {

  GraphProcessor processor;

  static final String FILE_STUDENTS = "data/dataStudents.txt";

  static List<String> readData(String filename) throws IOException {
    return Files.readAllLines(new File(filename).getAbsoluteFile().toPath());
  }

  public static Graph getBasicGraph() {
    Graph graph = null;
    try {
      graph = GraphProcessor.createGraph(readData(FILE_STUDENTS));
    } catch (IOException e) {
      throw new RuntimeException("Unable to read data", e);
    }

    return graph;
  }

}
