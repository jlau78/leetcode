package com.pojobox.study.ds.graph;

public class Node <T> {

  private static final String DELIMITER = ",";

  private String id;

  private T value;

  private String grade;

  private String friends;

  public Node(String id, T value, String grade, String friends ) {
    this.id = id;
    this.value = value;
    this.grade = grade;
    this.friends = friends;
  }

  public String getId() {
    return id;
  }

  public T getValue(){
    return value;
  };

  public String getGrade() {
    return this.grade;
  }

  public String getFriends() {
    return this.friends;
  }

  public void setValue(T value) {
    this.value = value;
  }

  public String toString() {
    return new StringBuilder("")
        .append(String.valueOf(this.id)).append(DELIMITER)
        .append(String.valueOf(this.value)).append(DELIMITER)
        .append(grade).append(DELIMITER)
        .append(friends)
        .toString();
  }
}
