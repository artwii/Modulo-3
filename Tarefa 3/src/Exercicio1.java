import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("A: ");
        int a = scanner.nextInt();
        System.out.print("B: ");
        int b = scanner.nextInt();
        System.out.print("C: ");
        int c = scanner.nextInt();
        if (a + b > c) {
            System.out.println(a + " + " + b + " é maior que " + c);
        } else if (a + b == c) {
            System.out.println(a + " + " + b + " é igual a " + c);
        } else {
            System.out.println(a + " + " + b + " é menor que " + c);
        }
        scanner.close();
    }
}
