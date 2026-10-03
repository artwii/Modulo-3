import java.util.Scanner;

public class Exercicio6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Insira um número: ");
        double num = scanner.nextDouble();

        boolean paridade = num %2 == 0;

        double resultado = paridade ? num + 5 : num + 8;

        System.out.println(resultado);

        scanner.close();
    }
}
