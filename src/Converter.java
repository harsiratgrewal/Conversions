import java.util.Scanner;

public class Converter {
    public static float convCalculation(String initialUnit, String targetUnit, Float initialNum) {
        float targetNum = 0;
        switch (initialUnit) {
            case "kg":
                switch (targetUnit) {
                    case "lb":
                        targetNum = initialNum * (float) 2.21;
                }
                break;
            case "lb":
                switch (targetUnit) {
                    case "kg":
                        targetNum = initialNum / (float) 2.21;
                }
                break;
            case "km":
                switch (targetUnit) {
                    case "mi":
                        targetNum = initialNum * (float) 0.621;
                }
                break;
            case "mi":
                switch (targetUnit) {
                    case "km":
                        targetNum = initialNum / (float) 0.621;
                }
                break;
            case "*C":
                switch (targetUnit) {
                    case "*F":
                        targetNum = (initialNum * ((float) 9 / (float) 5)) + (float) 32;
                }
                break;
            case "*F":
                switch (targetUnit) {
                    case "*C":
                        targetNum = (initialNum - (float) 32) * ((float) 5 / (float) 9);
                }
                break;
            case "m":
                switch (targetUnit) {
                    case "ft":
                        targetNum = initialNum * (float) 3.28;
                }
                break;
            case "ft":
                switch (targetUnit) {
                    case "m":
                        targetNum = initialNum / (float) 3.28;
                }
                break;
            default:
                System.out.println("ERROR: Please enter the correct input!");
        }
        System.out.printf("%.02f %s = %.02f %s%n", initialNum, initialUnit, targetNum, targetUnit);
        return targetNum;
    }

    public static void main(String[] args) throws Exception {
        String initialUnit, targetUnit, convType;
        Float initialNum;
        Scanner scnr = new Scanner(System.in);
        System.out.println("    Conversion types");
        System.out.println(
                "1. kg to lb\n2. lb to kg\n3. km to mi\n4. mi to km\n5. *C to *F\n6. *F to *C\n7. m to ft\n8. ft to m\nType 'exit' to exit the program");
        while (true) {
            System.out.print(
                    "Please enter the conversion type with the value (For example: Type 'lb to kg' to convert from lb to kg): ");
            convType = scnr.nextLine();
            if (convType.equals("exit")) {
                System.out.println("Thank you! Have a good day!");
                scnr.close();
                return;
            }
            String[] scnrArray = convType.split(" ");
            if (scnrArray.length != 3) {
                System.out.print("Invalid input! ");
                continue;
            } else {
                initialUnit = scnrArray[0];
                targetUnit = scnrArray[2];
                do {
                    System.out.print("How many " + initialUnit + " would you like to convert? (Enter a number): ");
                    while (!scnr.hasNextFloat()) {
                        System.out.print("Invalid Entery! Please enter an integer: ");
                        scnr.next();
                    }
                    initialNum = scnr.nextFloat();
                    break;
                } while (initialNum != null);
                scnr.nextLine();
            }
            Converter.convCalculation(initialUnit, targetUnit, initialNum);
        }
    }
}