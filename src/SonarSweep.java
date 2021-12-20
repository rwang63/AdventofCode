import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SonarSweep {
    static final String filePath = "/Users/ruifengwang/JavaProjects/sonarInput";

    public static void main(String[] args) {
        countIncrements(filePath);
        tripleSlidingWindow(filePath);
    }

    public static void countIncrements(String filePath) {
        int counter = 0;
        String nextDataPoint;
        try {
            File myObj = new File(filePath);
            Scanner myReader = new Scanner(myObj);
            String currentDataPoint = myReader.nextLine();
            while(myReader.hasNextLine()) {
                nextDataPoint = myReader.nextLine();
                if(Integer.parseInt(nextDataPoint) > Integer.parseInt(currentDataPoint)) {
                    counter++;
                }
                currentDataPoint = nextDataPoint;
            }
            System.out.println("There are " + counter + " instances of increasing in the file.");
        } catch (FileNotFoundException e) {
            System.out.println("Error in reading file");
            e.printStackTrace();
        }
    }

    public static void tripleSlidingWindow(String filePath) {
        int counter = 0;
        int currentTriplet;
        int nextTriplet;
        int nextDataPoint;
        try {
            File myObj = new File(filePath);
            Scanner myReader = new Scanner(myObj);
            int firstOfThree = myReader.nextInt();
            int secondOfThree = myReader.nextInt();
            int thirdOfThree = myReader.nextInt();
            currentTriplet = firstOfThree + secondOfThree + thirdOfThree;
            while(myReader.hasNextLine()) {
                nextDataPoint = myReader.nextInt();
                nextTriplet = currentTriplet - firstOfThree + nextDataPoint;
                if(nextTriplet > currentTriplet) {
                    counter++;
                }
                firstOfThree = secondOfThree;
                secondOfThree = thirdOfThree;
                thirdOfThree = nextDataPoint;
                currentTriplet = nextTriplet;
            }
            System.out.println("There are " + counter + " instances of three-measurement increases in the file.");
        } catch (FileNotFoundException e) {
            System.out.println("Error in reading file");
            e.printStackTrace();
        }
    }
}
