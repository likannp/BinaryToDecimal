import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter binary numbers. Enter 'S' to finish:");

        while (true) {
            String binaryInput = input.nextLine().trim();
            if (binaryInput.equalsIgnoreCase("S")) {
                System.out.println("Exiting program.");
                break;
            }
            if (binaryInput.isEmpty()) {
                System.out.println("Invalid input. Please enter a binary number or 'S' to finish.");
                continue;
            }

            if (!isValidBinary(binaryInput)) {
                System.out.println("Invalid binary input. Please enter a valid binary number.");
                continue;
            }

            int decimal = binaryToDecimal(binaryInput);
            if (binaryInput.charAt(0) == '1') {
                // Calcula o valor negativo usando o complemento de dois
                int negativeEquivalent = (int) (Math.pow(2, binaryInput.length()) - decimal);                System.out.println("Binary representation: " + binaryInput);
                System.out.println("Binary representation: " + binaryInput);
                System.out.println("Equivalent: " + (-negativeEquivalent));
                System.out.println("Positive: " + decimal);
            } else {
                System.out.println("Binary representation: " + binaryInput);
                System.out.println("Decimal: " + decimal);
            }
        }

        input.close();
    }

    private static boolean isValidBinary(String binary) {
        for (int i = 0; i < binary.length(); i++) {
            char digit = binary.charAt(i);
            if (digit != '0' && digit != '1') {
                return false;
            }
        }
        return true;
    }

    private static int binaryToDecimal(String binary) {
        return Integer.parseInt(binary, 2);
    }
}
