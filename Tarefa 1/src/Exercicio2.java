import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Olá, informe o primeiro número:");
        double num1 = scanner.nextDouble();
        System.out.println("Agora informe o segundo número:");
        double num2 = scanner.nextDouble();
        System.out.println("O resultado do produto dos números é: " + (num1 * num2));
        scanner.close();
    }
}
