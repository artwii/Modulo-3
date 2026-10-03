import java.util.Scanner;
import java.util.Locale;

public class Exercicio3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Olá, informe seu salário:");
        double salary = scanner.nextDouble();
        System.out.printf(Locale.of("pt", "BR"), "Salário: R$ %.2f\n", salary);
        scanner.close();
    }
}
