
public class MainDay3 {
  public record DataResult(String line, int big) {}
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
    for (String line: lines) {
      //System.out.println("Here is a line from the file" + line);
      System.out.println("Current biggest is: " + biggest);
      DataResult resultFirstPass = findBiggest(line);
      String newLine = resultFirstPass.line();
      int firstBiggest = resultFirstPass.big();
      DataResult resultSecondPass = findBiggest(newLine);
      }
    }
  }

  public static DataResult findBiggest(String line) {
    int biggest = 0;
    // check the first character
    for (int idxchar = 0; idxchar < line.length(); idxchar++) {
      int candidate = Character.getNumericValue(line.charAt(idxchar)); 
      if ( candidate > biggest) {
        // update the biggest
        biggest = candidate;
        // remove this char from the line for a second pass
        newLine = removeChar(line, idxchar)
      }
    return new DataResult(biggest, newLine);

  }
  public static String removeChar(String line, int idx) {
    // accept a string, create a copy but leave out the idx specified
    StringBuilder tempStr = new StringBuilder(line);
    tempStr.deleteCharAt(idx);
    newLine = tempStr;
    return newLine;
  }
  // public static void processRange(long start, long end, List<Long> invalidIdsList) {
  //   for (long Id = start; Id <= end; Id++) {
  //       // for each Id in this sequence, break it into parts using a denominator
  //       String idStr = Long.toString(Id);
  //       for (int groupSize = 1; groupSize <= idStr.length(); groupSize++) {
  //           for (int i = 0; i <= idStr.length() - groupSize; i++) {
  //               String part = idStr.substring(i, i + groupSize);
  //               long partValue = Long.parseLong(part);
  //               System.out.println(partValue);
  //           }
  //       }
  //   }
  // }
  // public static int countDigits(long number) {
  //   return String.valueOf(number).length();
  // }
}
