package com.pojobox.study.ds.mixed;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Stack;
import java.util.stream.IntStream;

class Scratch1 {

  public int[] twoSum(int[] nums, int target) {
//    int[] result = {};
    for (int i = 0; i < nums.length; i++) {
      for (int j = 1; j < nums.length; j++) {
        if (nums[i] + nums[j] == target) {
          return new int[]{i, j};
        }
      }
    }
    return new int[]{};
  }


  //  Definition for singly-linked list.
  public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

    LinkedList<Integer> l3 = new LinkedList<>();

    return null;
  }

  public void findSecondLargest() {

    int[] myNum = {50, 10, 25, 1, 17, 99, 33, 12};
    Arrays.sort(myNum);
    for (int i = myNum.length - 1; i > 0; i--) {
      if (myNum[myNum.length - 1] > myNum[i]) {
        System.out.println(i);
      } else {
        System.out.println("no match: " + myNum[i]);
      }
    }
    System.out.println("CAnnot find 2nd largest =>");
    Arrays.asList(myNum).stream().forEach(i -> System.out.println(i));

  }

  public String reverseString(String s) {
    char[] chars = s.toCharArray();
    String newS = "";
    for (int i = chars.length - 1; i >= 0; i--) {
      newS = newS.concat(String.valueOf(chars[i]));
    }
//      System.out.println("Reversed string: " + newS);
    return newS;
  }

  public String reverseString2(String s) {
    char[] chars = s.toCharArray();
    int low = 0;
    int high = chars.length - 1;
    while (low < high) {
      char temp = chars[low];
      chars[low] = chars[high];
      chars[high] = temp;
      low++;
      high--;
    }

    return new String(chars);
  }

  /**
   * @param searchWord
   * @return Return the index of the word found, or -1 if not found
   */
  public int searchWordStackLifo(String searchWord) {
    String medString = Fixtures.getMediumLongString();

    String[] words = medString.split(" ");
    System.out.println("searchWordStackLifo: medString words count: %s".formatted(words.length));

    Stack<String> wordsStack = new Stack<>();
    for (String w : words) {
      wordsStack.push(w);
    }

//      for (int i=0; i<wordsStack.size(); i++) {
//        if (wordsStack.get(i).toLowerCase().equals(searchWord.toLowerCase())) {
//          return i;
//        }
//      }

    return wordsStack.search(searchWord);

//      return -1;

  }

  public int binarySearch(String searchWord) {
    String medString = Fixtures.getMediumLongString();

    String[] words = medString.split(" ");
    Arrays.sort(words);

    int low = 0;
    int high = words.length - 1;

    while (low <= high) {
      int mid = low + (high - low) / 2;
      String midValue = (String)words[mid];

      System.out.println("binarySearch midValue:" + midValue);

      if (midValue.compareToIgnoreCase(searchWord) < 0) {
        low = mid + 1;
      } else if (midValue.compareToIgnoreCase(searchWord) > 0) {
        high = mid - 1;
      } else {
        return mid;
      }

    }

    return -1;
  }

  public Integer[] selectionSort(Integer[] arr) {

    for (int i=0; i < arr.length - 1; i++) {
      int min = i;
      for (int j=i+1; j < arr.length; j++) {
        if (arr[j] < arr[min]) {
          min = j;
        }
      }
      int temp = arr[i];
      arr[i] = arr[min];
      arr[min] = temp;
    }

    return arr;
  }

  public void insertionSort(Integer[] arr) {

    for (int i=1; i < arr.length; i++) {
      int temp = arr[i];
      int j = i - 1;
      while (j >= 0 && arr[j] > temp) {
        arr[j+1] = arr[j];
        j--;
      }
      arr[j+1] = temp;
    }
  }

  public void insertionSort2(Integer[] arr) {
    for (int i=1; i < arr.length; i++) {
      int temp = arr[i];
      for (int j=i-1; j > 0; j--) {
        if (j >= 0 && arr[j] > temp) {
          arr[j+1] = arr[j];
        }
      }
    }
  }


  public void mergeSort(int[] arr) {

    if (arr.length <= 1) return;

    // Split array until single items
    int middle = arr.length / 2;
    int rightStart = middle + 1;

    int[] left = new int[middle];
    int[] right = new int[arr.length - middle];

    // left
    for (int i=0; i < middle; i++) {
      left[i] = arr[i];
    }
    // right
    for (int j=middle; j < arr.length; j++) {
      right[j - middle] = arr[j];
    }

    mergeSort(left);
    mergeSort(right);

    merge(left, right, arr);
  }

  private void merge(int[] left, int[] right, int[] arr) {

    int leftSize = arr.length / 2;
    int rightSize = arr.length - leftSize;

    int i = 0, l = 0, r = 0;

    // check conditions for merging
    while (l < leftSize && r < rightSize) {
      if (left[l] < right[r]) {
        arr[i] = left[l];
        i++;
        l++;
      } else {
        arr[i] = right[r];
        i++;
        r++;
      }
    }

    // Sort remaining single int
    while (l < leftSize) {
      arr[i] = left[l];
      i++;
      l++;
    }

    while (r < rightSize) {
      arr[i] = right[r];
      i++;
      r++;
    }
  }

  public void quickSort(int[] arr, int start, int end) {

    if (end <= start) return;

    int pivot = partition(arr, start, end);
    quickSort(arr, 0, pivot - 1);
    quickSort(arr, pivot + 1, end);

  }

  private static int partition(int[] arr, int start, int end) {
    int pivot = arr[end];
    int i = start - 1;

    for (int j=start; j <= end - 1; j++) {
      if (arr[j] < pivot) {
        i++;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
    }
    i++;
    int temp = arr[i];
    arr[i] = arr[end];
    arr[end] = temp;

    return i;
  }


  public static void main(String[] args) {

    Scratch1 app = new Scratch1();

    Random rnd = new Random();
    IntStream ints = rnd.ints(0, 15);
    ints.limit(5).forEach(i -> System.out.println(i));

    System.out.println("twoSum: " + app.twoSum(new int[]{3, 3}, 6));

    app.findSecondLargest();

    String s = "helloWorld Today";
    System.out.println("Reverse 1:" + app.reverseString(s));

    System.out.println("reverseString2: " + app.reverseString2(s));

    String searchString = "tempor";
    System.out.println("searchWordStackLifo: found word at index: %s".formatted(app.searchWordStackLifo("non")));
    System.out.println("binarySearch for word \'%s\', index:%s".formatted(searchString, app.binarySearch(searchString)));

    Integer[] ints1 = {3,4,9,6,1,5,12,2};
    System.out.println("");
    System.out.print("selectionSort for array of integers:\t");
    printArray(app.selectionSort(ints1));

    Integer[] ints2 = {3,4,9,6,1,5,12,2};
    System.out.println("");
    System.out.print("insertionSort for array of integers:\t");
    app.insertionSort2(ints2);
    printArray(ints2);

    int[] intsArray = {3,4,9,6,1,5,12,2};
    System.out.println("");
    System.out.print("mergeSort for array of ints:\t\t\t");
    app.mergeSort(intsArray);
    Arrays.stream(intsArray).forEach(i -> System.out.print(i + ", "));

    int[] intsArray2 = {3,4,9,6,14,1,5,12,2,7};
    System.out.println("");
    System.out.print("quickSort for array of ints:\t\t\t");
    app.quickSort(intsArray2, 0, intsArray2.length - 1);
    Arrays.stream(intsArray2).forEach(i -> System.out.print(i + ", "));


  }

  private static <T> void printArray(T [] arr) {
    Arrays.stream(arr)
        .forEach(a -> System.out.print(a + ", "));
  }

  public class Fixtures {

    public static String getMediumLongString() {
      return "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
    }

  }
}




