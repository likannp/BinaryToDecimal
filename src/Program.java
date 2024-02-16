import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Integer> binaries = new ArrayList<>();
        System.out.println("Enter binary numbers (0 or 1). Enter 'S' to finish:");

        StringBuilder completeSequence = new StringBuilder();
        while (true) {
            String entry = input.nextLine();
            if (entry.equalsIgnoreCase("S")) {
                break;
            }

            if (isValidBinary(entry)) {
                for (int i = 0; i < entry.length(); i++) {
                    binaries.add(Character.getNumericValue(entry.charAt(i)));
                }
                completeSequence.append(entry);
            } else {
                System.out.println("Please enter only '0', '1', or 'S'.");
                binaries.clear();
                completeSequence.setLength(0);
            }
        }

        StringBuilder complementBinary = null;
        int decimal = 0;
        if (completeSequence.length() > 0) {
            if (completeSequence.charAt(0) == '1') {
                StringBuilder invertedBinary = invertBits(completeSequence);
                complementBinary = addOne(invertedBinary);
                decimal = Integer.parseInt("-"+binaryToDecimal(complementBinary.toString()));
            } else {
                complementBinary = completeSequence;
                decimal = binaryToDecimal(completeSequence.toString());
            }
        }

        System.out.println("Representação binária: " + completeSequence);
        if (complementBinary != null) {
            System.out.println("Representação binária complemento de dois: " + complementBinary);
            System.out.println("Decimal: " + decimal);
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

    private static StringBuilder invertBits(StringBuilder binary) {
        StringBuilder invertedBinary = new StringBuilder();
        for (int i = 0; i < binary.length(); i++) {
            char c = binary.charAt(i);
            char invertedChar = (c == '0') ? '1' : '0';
            invertedBinary.append(invertedChar);
        }
        return invertedBinary;
    }

    private static StringBuilder addOne(StringBuilder binary) {
        StringBuilder complementBinary = new StringBuilder();
        int carry = 1;
        for (int i = binary.length() - 1; i >= 0; i--) {
            char c = binary.charAt(i);
            if (c == '0' && carry == 1) {
                complementBinary.insert(0, '1');
                carry = 0;
            } else if (c == '1' && carry == 1) {
                complementBinary.insert(0, '0');
                carry = 1;
            } else {
                complementBinary.insert(0, c);
            }
        }
        return complementBinary;
    }

    private static int binaryToDecimal(String binary) {
        return Integer.parseInt(binary, 2);
    }
}


