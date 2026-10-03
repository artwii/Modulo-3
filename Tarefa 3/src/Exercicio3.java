import java.util.Scanner;

public class Exercicio3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Insira um número: ");
        double num = scanner.nextDouble();

        String paridade = num %2 == 0 ? (num + " é par!") : (num + " é ímpar");

        System.out.println(paridade);

        scanner.close();
    }
}
