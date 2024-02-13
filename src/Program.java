import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner input = new  Scanner(System.in);
        List<Integer> binarys = new ArrayList<>();
        System.out.println("Digite os números binários (0 ou 1). Digite 'S' para encerrar:");

        while (true){
            String entrada = input.next();
            if (entrada.equalsIgnoreCase("S")){
                break;
            }
            Integer binary;
            try {
                binary = Integer.parseInt(entrada);
            }catch (NumberFormatException e){
                System.out.println("Por favor, digite apenas '0', '1' ou 'S'.");
                continue;
            }
            if (binary == 0 || binary == 1){
                binarys.add(binary);
            }else {
                System.out.println("Por favor, digite apenas '0', '1' ou 'S'.");
            }
        }
        for (int binary : binarys){
            System.out.print(binary);
        }

    }
}
