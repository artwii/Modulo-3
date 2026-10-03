import java.util.Scanner;

public class Exercicio3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Insira um número inteiro de 1 a 10: ");
        int num = scanner.nextInt();

        while (num > 10 || num < 0) {
            System.out.print("Tente novamente: ");
            num = scanner.nextInt();
        }

        for (int i = 0; i <= 10; i++) {
            System.out.println(num + " X " + i + " = " + (num * i));
        }

        scanner.close();
    }
}
