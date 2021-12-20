import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Dive {
    static final String filePath = "/Users/ruifengwang/JavaProjects/diveInput";

    public static void main(String[] args) {
        int result = calculatePosition(filePath);

        System.out.println("Multiplying the horizontal position with the final depth gives us: " + result + ".");
    }

    public static int calculatePosition(String filePath) {
        int finalResult = 0;
        String direction;
        int amount;
        int horizontalPosition = 0;
        int depth = 0;
        try {
            File myObj = new File(filePath);
            Scanner myReader = new Scanner(myObj);
            while(myReader.hasNextLine()) {
                direction = myReader.next();
                amount = myReader.nextInt();
                switch(direction) {
                    case "forward":
                        horizontalPosition += amount;
                        break;
                    case "up":
                        depth -= amount;
                        break;
                    case "down":
                        depth += amount;
                        break;
                }
            }
            finalResult = horizontalPosition * depth;
        } catch (FileNotFoundException e) {
            System.out.println("Error in reading file");
            e.printStackTrace();
        }
        return finalResult;
    }
}
