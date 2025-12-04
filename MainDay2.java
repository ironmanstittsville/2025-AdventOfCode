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
    for (String idRange : ids) {
        System.out.println("Working on this id:" + idRange);
        // for each idRange, extract the start and end
        String[] parts = idRange.split("-");
        int start = Integer.parseInt(parts[0]);
        int end = Integer.parseInt(parts[1]);
        System.out.println("Start: " + start + ", End: " + end);
        // // process all the numbers in the range
        // for (int i = start; i <= end; i++) {
        //     System.out.println("Number: " + i);}
        processRange(start, end);
    }
  }
  public static void processRange(int start, int end) {
    for (int i = start; i <= end; i++) {
        System.out.println("Number: " + i);
    }
  }
}
