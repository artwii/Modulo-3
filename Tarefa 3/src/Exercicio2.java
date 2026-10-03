import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Insira seu nome: ");
        String nome = scanner.nextLine();
        System.out.print("Insira seu sexo (M/F): ");
        String sexo = scanner.nextLine();
        System.out.print("Insira seu estado civil: ");
        String civil = scanner.nextLine();

        if (sexo.equalsIgnoreCase("F") && civil.equalsIgnoreCase("casada")) {
            System.out.print("Insira os anos de casada: ");
            int anos = scanner.nextInt();
            System.out.println("=============");
            System.out.println("Nome: " + nome);
            System.out.println("Sexo: " + sexo);
            System.out.println("Estado civil: " + civil);
            System.out.println("Anos de casada: " + anos);
            System.out.println("=============");

        } else {
            System.out.println("=============");
            System.out.println("Nome: " + nome);
            System.out.println("Sexo: " + sexo);
            System.out.println("Estado civil: " + civil);
            System.out.println("=============");
        }
        scanner.close();
    }
}
