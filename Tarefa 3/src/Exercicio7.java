import java.util.Scanner;

public class Exercicio7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Insira o primeiro número: ");
        int num = scanner.nextInt();

        System.out.print("Insira o segundo número: ");
        int num2 = scanner.nextInt();

        while (num == num2) {
            System.out.print("Insira um número diferente do primeiro: ");
            num2 = scanner.nextInt();
        }

        System.out.print("Insira o terceiro número: ");
        int num3 = scanner.nextInt();

        while (num3 == num2 || num3 == num) {
            System.out.print("Insira um número diferente do primeiro e do segundo: ");
            num3 = scanner.nextInt();
        }

        if (num > num2 && num2 > num3) {
            System.out.println(num);
            System.out.println(num2);
            System.out.println(num3);
        } else if (num2 > num && num > num3) {
            System.out.println(num2);
            System.out.println(num);
            System.out.println(num3);
        } else if (num3 > num2 && num2 > num) {
            System.out.println(num3);
            System.out.println(num2);
            System.out.println(num);
        } else if (num3 > num && num > num2) {
            System.out.println(num3);
            System.out.println(num);
            System.out.println(num2);
        } else if (num > num3 && num3 > num2) {
            System.out.println(num);
            System.out.println(num3);
            System.out.println(num2);
        } else {
            System.out.println(num2);
            System.out.println(num3);
            System.out.println(num);
        }

        scanner.close();
    }
}
