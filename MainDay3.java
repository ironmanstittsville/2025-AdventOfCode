import java.util.ArrayList;
import java.util.List;

public class MainDay3 {
  
  public record ResultFromPass(String line, int big, int idx) {}

  public static void main(String[] args) {
    System.out.println("Hello, Day 3!");
    // read input-day2.txt file using the FileReaderUtil class
    String filePath = "D:\\Richard\\Projects\\2025-AdventOfCode\\input-day3.txt";
    String[] lines = new String[1];
    try {
        lines = FileReaderUtil.readFileIntoArray(filePath);
    } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
    }
    // read each character, one at a time in the line array and find the 2 highest numbers
    List<Integer> jolts = new ArrayList<>();
    for (String line: lines) {
      ResultFromPass resultFirstPass = findBiggest(line);
      String newLine = resultFirstPass.line();
      int firstBiggest = resultFirstPass.big();
      int firstIdx = resultFirstPass.idx();
      ResultFromPass resultSecondPass = findBiggest(newLine);
      int secondBiggest = resultSecondPass.big();
      int secondIdx = resultSecondPass.idx();
      if (firstIdx > secondIdx) {
        // add the second found
        jolts.add(secondBiggest);
        jolts.add(firstBiggest);
      } else {
        // add the first found
        jolts.add(firstBiggest);
        jolts.add(secondBiggest);
      }
    }
    for (Integer res : jolts) {
      System.out.println("Found ints: " + res + ".");
    }
  }

  public static ResultFromPass findBiggest(String line) {
    String newLine = new String();
    int biggest = 0;
    int index = 0;
    // check the first character
    for (int idxchar = 0; idxchar < line.length(); idxchar++) {
      int candidate = Character.getNumericValue(line.charAt(idxchar)); 
      if ( candidate > biggest) {
        // update the biggest
        biggest = candidate;
        // // remove this char from the line for a second pass
        // newLine = removeFront(line, idxchar);
        // take note of the index 
        index = idxchar;
      }
    newLine = line.substring(index+1);
    }
    return new ResultFromPass(newLine, biggest, index);
  }
  public static String removeFront(String line, int index) {
    // accept a string, create a copy but leave out the idx specified
    //StringBuilder tempStr = new StringBuilder(line);
    String newline = line.substring(index + 1);
    return newline;
  }
}
