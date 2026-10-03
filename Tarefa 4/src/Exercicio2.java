import java.util.Scanner;
import java.util.Random;

public class Exercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int num = random.nextInt(101);
        int chosenNum;

        System.out.println("Jogo da adivinhação - Adivinhe um número inteiro de 0 a 100");
        do {
            System.out.print("Insira o número inteiro: ");
            chosenNum = scanner.nextInt();
            if (num > chosenNum) {
                System.out.println("O número certo é maior!");
            } else {
                System.out.println("O número certo é menor!");
            }
        } while (num != chosenNum);

        System.out.println("Parabéns, você acertou!");

        scanner.close();
    }
}
