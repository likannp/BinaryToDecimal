import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Integer> binaries = new ArrayList<>();
        System.out.println("Enter binary numbers (0 or 1). Enter 'S' to finish:");

         // String para armazenar a sequência completa de bits/
        // String to store the complete sequence of bits
        StringBuilder completeSequence = new StringBuilder();

        while (true) {
            String entry = input.nextLine();
            if (entry.equalsIgnoreCase("S")) {
                break;
            }

            // Verifica se a entrada atual é um número binário válido
            // Check if the current entry is a valid binary number
            boolean valid = true;
            for (int i = 0; i < entry.length(); i++) {
                char digit = entry.charAt(i);
                if (digit != '0' && digit != '1') {
                    valid = false;
                    System.out.println("Please enter only '0', '1', or 'S'.");
                    completeSequence.setLength(0); // Clear the complete sequence if there's an error
                    break;
                } else {
                    // Add the bit to the list if it's valid
                    binaries.add(Character.getNumericValue(digit));
                }
            }

            // Se todos os bits forem válidos, adicione a sequência completa à string
            // If all bits are valid, add the complete sequence to the string
            if (valid) {
                completeSequence.append(entry);
            }
        }
        int cont = completeSequence.length() - 1;
        List<Integer> decimal = new ArrayList<>();
        for (int i = 0; i < completeSequence.length(); i++) {
            char c = completeSequence.charAt(i);
            int value = c - '0';
            int result = value * (int) Math.pow(2, cont);
            decimal.add(result);
            cont--;
        }
        int soma = 0;
        for (int valor : decimal) {
            soma += valor;
        }
        System.out.println(soma + " decimais");

        System.out.println("Individual bits entered: " + binaries);

        System.out.println("Complete sequence of bits entered: " + completeSequence.toString());

        input.close();
    }
}
