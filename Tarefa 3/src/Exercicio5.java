import java.util.Scanner;

public class Exercicio5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Insira um número: ");
        int num = scanner.nextInt();

        int resultado = num > 0 ? num * 2 : num * 3;

        System.out.println("Resultado: " + resultado);

        scanner.close();
    }
}
