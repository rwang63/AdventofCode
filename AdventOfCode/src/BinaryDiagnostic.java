import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BinaryDiagnostic {
    static final String filePath = "./binaryInput";

    public static void main(String[] args) {
       int result = calculatePowerConsumption(filePath);
       System.out.println("The final power consumption is: " + result);
    }

    public static int calculatePowerConsumption(String filePath) {
        String currentLine;
        int[] countZeroes = new int[12];
        int[] countOnes = new int[12];
        int[] gammaRate = new int[12];
        int[] epsilonRate = new int[12];
        int gammaAsInteger = 0;
        int epsilonAsInteger = 0;
        try {
            File myObj = new File(filePath);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                currentLine = myReader.nextLine();
                char[] lineInArray = currentLine.toCharArray();
                for (int i = 0; i < lineInArray.length; i++) {
                    if (lineInArray[i] == '0') {
                        countZeroes[i]++;
                    } else {
                        countOnes[i]++;
                    }
                }
            }
            for (int j = 0; j < countZeroes.length; j++) {
                if (countZeroes[j] > countOnes[j]) {
                    gammaRate[j] = 0;
                    epsilonRate[j] = 1;
                } else {
                    gammaRate[j] = 1;
                    epsilonRate[j] = 0;
                }
            }
            gammaAsInteger = binaryToInt(gammaRate);
            epsilonAsInteger = binaryToInt(epsilonRate);
        } catch (FileNotFoundException e) {
            System.out.println("Error in reading file");
            e.printStackTrace();
        }
        return gammaAsInteger * epsilonAsInteger;
    }

    public static int binaryToInt(int[] binary) {
        int result = 0;
        int position = binary.length;
        for (int j : binary) {
            if (j == 1) {
                result += Math.pow(2, position - 1);
            }
            position--;
        }
        return result;
    }
}
