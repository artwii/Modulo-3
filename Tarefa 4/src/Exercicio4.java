import java.util.Scanner;

public class Exercicio4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int i = 1;
        int counter = 0;
        int age;

        do {
            System.out.print("Insira a idade da pessoa " + i + " : ");
            age = scanner.nextInt();
            if (age > 18) {
                counter++;
            }
            i++;
        } while (i <= 5);

        System.out.println("Quantidade de pessoas com mais de 18 anos: " + counter);

        scanner.close();
    }
}
