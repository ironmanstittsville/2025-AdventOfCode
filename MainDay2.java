public class MainDay2 {
    public static void main(String[] args) {
        System.out.println("Hello, Day 2!");
        // read input-day2.txt file using the FileReaderUtil class
        String filePath = "input-day2.txt";
        try {
            String[] lines = FileReaderUtil.readFileIntoArray(filePath);
            System.out.println("Contents of the file:");
            for (String line : lines) {
                System.out.println(line);}
    }
    
}
