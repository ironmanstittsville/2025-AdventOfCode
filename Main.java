import java.io.File;                  // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.Scanner;             // Import the Scanner class to read text files


class Dial {
  int position = 0; // starting position
  public Dial(int startingPosn) {
    position = startingPosn;
  } 
  public int add(int number) {
    position += number;
    while (position >= 99) {
      // position must wrap around
      position -= 100;
    }
    return position;
  }
  public int subtract(int number) {
    position -= number;
    while (position < 0) {
      // position must wrap around
      position += 100;
    }
    return position;
  }
} //Dial

class Main {
    public static void main(String[] args) {
        //System.out.println("Hello, World!");
        Dial dialLocation = new Dial(50);
        int zeroCtr = 0;
        // for every line read in, R or L, increment or decrement zero_ctr
      File myObj = new File("input.txt");
      int readLineIdx = 0;
      try (Scanner myReader = new Scanner(myObj)) {
        while (myReader.hasNextLine()) {
          String data = myReader.nextLine();
          // slice data to get R or L
          String direction = data.substring(0,1);
          System.out.println("Direction:" + direction + ".");
          // slice data to get number of rotations
          String rotationS = data.substring(1);
          int rotations = Integer.parseInt(rotationS);
          System.out.println("Rotations: " + rotations);
          switch (direction) {
            case "R":
              dialLocation.add(rotations);
              break;
            case "L":
              dialLocation.subtract(rotations);
              break;
            default:
              System.out.println("Unknown direction:" + direction);
          }
          System.out.println("------------------------- Dial location: " + dialLocation.position);
          if (dialLocation.position == 0) {
            // count this as a zero hit
            zeroCtr += 1;
          }
          readLineIdx += 1;
        }
      } catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }
      System.out.println("Total lines read in from file: " + readLineIdx);
      System.out.println("Number of zero dial occurences: " + zeroCtr);
    }
}
