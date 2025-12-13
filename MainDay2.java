import java.util.ArrayList;
import java.util.List;

public class MainDay2 {
  public static void main(String[] args) {
    System.out.println("Hello, Day 2!");
    // read input-day2.txt file using the FileReaderUtil class
    String filePath = "/home/rahoule/Projects/2025-AdventOfCode/input-day2-example.txt";
    String[] lines = new String[1];
    try {
        lines = FileReaderUtil.readFileIntoArray(filePath);
        //System.out.println("Contents of the file:");
        for (String line : lines) {
            System.out.println(line);
        }
    } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
    }
    // split the line (expect just a sinle line, actually)
    String[] ids = lines[0].split(",");
    List<Long> invalidIds = new ArrayList<>();
    long sum = 0;
    for (String idRange : ids) {
        //System.out.println("Working on this id:" + idRange);
        // for each idRange, extract the start and end
        String[] parts = idRange.split("-");
        //int start = Integer.parseInt(parts[0]);
        long start = Long.parseLong(parts[0]);
        long end = Long.parseLong(parts[1]);
        processRange(start, end, invalidIds);
    }
    System.out.println("Invalid IDs so far: " + invalidIds);
    // sum the invalid IDs
    for (long invalidId : invalidIds) {
        sum += invalidId;
    }
    System.out.println("Sum of invalid IDs: " + sum);
  }
  public static void processRange(long start, long end, List<Long> invalidIdsList) {
    for (long Id = start; Id <= end; Id++) {
        // for each Id in this sequence, break it into parts using a denominator
        String idStr = Long.toString(Id);
        for (int groupSize = 1; groupSize <= idStr.length(); groupSize++) {
            for (int i = 0; i <= idStr.length() - groupSize; i++) {
                String part = idStr.substring(i, i + groupSize);
                long partValue = Long.parseLong(part);
                System.out.println(partValue);
            }
        }
    }
  }
  public static int countDigits(long number) {
    return String.valueOf(number).length();
  }
}
