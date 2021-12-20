import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SonarSweep {
    static final String filePath = "/Users/ruifengwang/JavaProjects/input";

    public static void main(String[] args) {
        countIncrements(filePath);
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
}
