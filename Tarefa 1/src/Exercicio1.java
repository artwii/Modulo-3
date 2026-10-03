import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Olá, por favor informe seu nome:");
        String nome = scanner.nextLine();
        System.out.println("Agora informe sua idade:");
        int idade = scanner.nextInt();
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        scanner.close();
    }
}
