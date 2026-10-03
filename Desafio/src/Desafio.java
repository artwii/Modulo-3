import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class Desafio {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        ArrayList<Integer> easyScores = new ArrayList<>();
        int maxEasyScore = 0;
        ArrayList<Integer> mediumScores = new ArrayList<>();
        int maxMediumScore = 0;
        ArrayList<Integer> hardScores = new ArrayList<>();
        int maxHardScore = 0;
        ArrayList<Integer> sequenceScores = new ArrayList<>();
        int maxSequenceScore = 0;

        while (true) {
            System.out.println();
            System.out.println("=====Jogo da adivinhação=====");
            System.out.println("1 - Iniciar jogo");
            System.out.println("2 - Ver regras");
            System.out.println("3 - Ver histórico de pontuações");
            System.out.println("4 - Sair");
            System.out.println("=============================");
            System.out.print("Escolha uma opção: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    int mode = 0;
                    // Config: [max, attempts, startPoints]
                    int[] config = new int[3];
                    boolean valid = false;
                    while (!valid) {
                        System.out.println();
                        System.out.println("========Modos de jogo========");
                        System.out.println("1 - Fácil: Adivinhe um número entre 1 e 50, com 10 tentativas;");
                        System.out.println("2 - Médio: Adivinhe um número entre 1 e 100, com 7 tentativas;");
                        System.out.println("3 - Difícil: Adivinhe um número entre 1 e 200, com 5 tentativas;");
                        System.out.println(
                                "4 - Sequência: Adivinhe 3 números em sequência, entre 1 e 150, com 15 tentativas.");
                        System.out.println("=============================");
                        System.out.print("Escolha um modo: ");
                        mode = scanner.nextInt();

                        switch (mode) {
                            case 1:
                                valid = true;
                                config[0] = 50;
                                config[1] = 10;
                                config[2] = 100;
                                break;
                            case 2:
                                valid = true;
                                config[0] = 100;
                                config[1] = 7;
                                config[2] = 200;
                                break;
                            case 3:
                                valid = true;
                                config[0] = 200;
                                config[1] = 5;
                                config[2] = 300;
                                break;
                            case 4:
                                valid = true;
                                config[0] = 150;
                                config[1] = 15;
                                config[2] = 400;
                                break;
                            default:
                                System.out.println("Escolha uma opção válida!");
                                break;
                        }
                    }

                    switch (mode) {
                        case 1, 2, 3 -> {
                            System.out.println();
                            System.out.println("================================");
                            System.out.println("Adivinhe um número entre 1 e " + config[0]);
                            System.out.println("================================");
                            int num = random.nextInt(config[0]) + 1;
                            int attempts = config[1];
                            int points = config[2];
                            boolean correct = false;
                            boolean firstAttempt = false;
                            int attempt = 0;

                            do {
                                System.out.println();
                                System.out.println("Sua pontuação atual é " + points);
                                System.out.println("Você tem " + attempts + " tentativas");
                                int selection;
                                while (true) {
                                    System.out.println("O que você gostaria de fazer?");
                                    System.out.println("1 - Dar um palpite;");
                                    System.out.println("2 - Dica de paridade (par/ímpar): -10 pontos.");
                                    System.out.println("3 - Dica de intervalo (metade superior/inferior): -20 pontos.");
                                    System.out.println("4 - Dica de proximidade (quente/frio): -15 pontos.");
                                    System.out.print("Escolha uma opção: ");
                                    selection = scanner.nextInt();

                                    if (selection == 1 || selection == 2 || selection == 3 || selection == 4) {
                                        break;
                                    } else {
                                        System.out.println("Escolha uma opção válida!");
                                    }
                                }

                                switch (selection) {
                                    case 1:
                                        System.out.print("Insira o palpite: ");
                                        attempt = scanner.nextInt();
                                        attempts--;
                                        points -= 5;
                                        if (attempt == num) {
                                            correct = true;
                                            for (int i = 0; i < attempts; i++) {
                                                points += 50;
                                            }
                                            System.out.println();
                                            System.out.println("=============");
                                            System.out.println("Você acertou, parabéns!");
                                            System.out.println("=============");
                                        } else {
                                            System.out.println();
                                            System.out.println("============================");
                                            System.out.println("Você errou! Tente novamente.");
                                            System.out.println("============================");
                                        }

                                        firstAttempt = true;
                                        break;
                                    case 2:
                                        if (points >= 10) {
                                            points -= 10;
                                            if (num % 2 == 0) {
                                                System.out.println();
                                                System.out.println("===============");
                                                System.out.println("O número é par!");
                                                System.out.println("===============");
                                            } else {
                                                System.out.println();
                                                System.out.println("=================");
                                                System.out.println("O número é ímpar!");
                                                System.out.println("=================");
                                            }
                                        } else {
                                            System.out.println();
                                            System.out.println(
                                                    "Você não tem pontos para usar essa dica, selecione outra opção!");
                                        }
                                        break;
                                    case 3:
                                        if (points >= 20) {
                                            points -= 20;
                                            if (num > (config[0] / 2)) {
                                                System.out.println();
                                                System.out.println("=================================");
                                                System.out.println("O número está na metade superior!");
                                                System.out.println("=================================");
                                            } else {
                                                System.out.println();
                                                System.out.println("=================================");
                                                System.out.println("O número está na metade inferior!");
                                                System.out.println("=================================");
                                            }
                                        } else {
                                            System.out.println();
                                            System.out.println(
                                                    "Você não tem pontos para usar essa dica, selecione outra opção!");
                                        }
                                        break;
                                    case 4:
                                        if (firstAttempt && points >= 15) {
                                            points -= 15;
                                            if ((attempt - num <= 10 && attempt - num >= 1)
                                                    || (num - attempt <= 10 && num - attempt >= 1)) {
                                                System.out.println();
                                                System.out.println(
                                                        "==========================================================================");
                                                System.out.println(
                                                        "Quente! O seu último palpite tem até 10 unidades de diferença do objetivo.");
                                                System.out.println(
                                                        "==========================================================================");
                                            } else {
                                                System.out.println();
                                                System.out.println(
                                                        "============================================================================");
                                                System.out.println(
                                                        "Frio! O seu último palpite tem mais de 10 unidades de diferença do objetivo.");
                                                System.out.println(
                                                        "============================================================================");
                                            }
                                        } else if (firstAttempt) {
                                            System.out.println();
                                            System.out.println(
                                                    "Você não tem pontos para usar essa dica, selecione outra opção!");
                                        } else {
                                            System.out.println("Dê ao menos um palpite para poder usar essa dica");
                                        }
                                        break;
                                }

                            } while (!correct && attempts > 0 && (points > 0));

                            if (correct) {
                                System.out.println();
                                System.out.println("============================================");
                                System.out.println("Parabéns, você venceu o jogo com " + points + " pontos!");
                                System.out.println("============================================");
                            } else {
                                points = 0;
                                System.out.println();
                                System.out.println(
                                        "========================================================================");
                                System.out.println(
                                        "Você perdeu o jogo por ficar sem tentativas ou com pontos insuficientes!");
                                System.out.println(
                                        "========================================================================");
                            }

                            switch (mode) {
                                case 1:
                                    easyScores.add(0, points);
                                    if (correct) {
                                        easyScores.add(0, 1);
                                    } else {
                                        easyScores.add(0, 0);
                                    }
                                    if (easyScores.size() > 20) {
                                        easyScores.remove(easyScores.size() - 1);
                                        easyScores.remove(easyScores.size() - 1);
                                    }
                                    if (points > maxEasyScore) {
                                        maxEasyScore = points;
                                    }
                                    break;
                                case 2:
                                    mediumScores.add(0, points);
                                    if (correct) {
                                        mediumScores.add(0, 1);
                                    } else {
                                        mediumScores.add(0, 0);
                                    }
                                    if (mediumScores.size() > 20) {
                                        mediumScores.remove(mediumScores.size() - 1);
                                        mediumScores.remove(mediumScores.size() - 1);
                                    }
                                    if (points > maxMediumScore) {
                                        maxMediumScore = points;
                                    }
                                    break;
                                case 3:
                                    hardScores.add(0, points);
                                    if (correct) {
                                        hardScores.add(0, 1);
                                    } else {
                                        hardScores.add(0, 0);
                                    }
                                    if (hardScores.size() > 20) {
                                        hardScores.remove(hardScores.size() - 1);
                                        hardScores.remove(hardScores.size() - 1);
                                    }
                                    if (points > maxHardScore) {
                                        maxHardScore = points;
                                    }
                                    break;
                            }
                        }
                        case 4 -> {
                            System.out.println();
                            System.out.println("======================================================");
                            System.out.println("Adivinhe os 3 números da sequência, cada um de 1 a 150");
                            System.out.println("======================================================");
                            int[] numbers = { (random.nextInt(150) + 1), (random.nextInt(150) + 1),
                                    (random.nextInt(150) + 1) };
                            int attempts = config[1];
                            int points = config[2];
                            int num = numbers[0];
                            int correct = 0;
                            boolean firstAttempt = false;
                            int attempt = 0;

                            do {
                                System.out.println();
                                System.out.println("Sua pontuação atual é " + points);
                                System.out.println("Você tem " + attempts + " tentativas");
                                System.out.println("Você está adivinhando o " + (correct + 1) + "° número");
                                int selection;
                                while (true) {
                                    System.out.println("O que você gostaria de fazer?");
                                    System.out.println("1 - Dar um palpite;");
                                    System.out.println("2 - Dica de paridade (par/ímpar): -10 pontos.");
                                    System.out.println("3 - Dica de intervalo (metade superior/inferior): -20 pontos.");
                                    System.out.println("4 - Dica de proximidade (quente/frio): -15 pontos.");
                                    System.out.print("Escolha uma opção: ");
                                    selection = scanner.nextInt();

                                    if (selection == 1 || selection == 2 || selection == 3 || selection == 4) {
                                        break;
                                    } else {
                                        System.out.println("Escolha uma opção válida!");
                                    }
                                }

                                switch (selection) {
                                    case 1:
                                        firstAttempt = true;
                                        System.out.print("Insira o palpite: ");
                                        attempt = scanner.nextInt();
                                        attempts--;
                                        points -= 5;
                                        if (attempt == num) {
                                            firstAttempt = false;
                                            correct++;
                                            if (correct != 3) {
                                                num = numbers[correct];
                                            }
                                            System.out.println();
                                            System.out.println("=============");
                                            System.out.println("Você acertou o " + correct + "° número, parabéns!");
                                            System.out.println("=============");
                                        } else {
                                            System.out.println();
                                            System.out.println("============================");
                                            System.out.println("Você errou! Tente novamente.");
                                            System.out.println("============================");
                                        }
                                        break;
                                    case 2:
                                        if (points >= 10) {
                                            points -= 10;
                                            if (num % 2 == 0) {
                                                System.out.println();
                                                System.out.println("===============");
                                                System.out.println("O número é par!");
                                                System.out.println("===============");
                                            } else {
                                                System.out.println();
                                                System.out.println("=================");
                                                System.out.println("O número é ímpar!");
                                                System.out.println("=================");
                                            }
                                        } else {
                                            System.out.println();
                                            System.out.println(
                                                    "Você não tem pontos para usar essa dica, selecione outra opção!");
                                        }
                                        break;
                                    case 3:
                                        if (points >= 20) {
                                            points -= 20;
                                            if (num > (config[0] / 2)) {
                                                System.out.println();
                                                System.out.println("=================================");
                                                System.out.println("O número está na metade superior!");
                                                System.out.println("=================================");
                                            } else {
                                                System.out.println();
                                                System.out.println("=================================");
                                                System.out.println("O número está na metade inferior!");
                                                System.out.println("=================================");
                                            }
                                        } else {
                                            System.out.println();
                                            System.out.println(
                                                    "Você não tem pontos para usar essa dica, selecione outra opção!");
                                        }
                                        break;
                                    case 4:
                                        if (firstAttempt && points >= 15) {
                                            points -= 15;
                                            if ((attempt - num <= 10 && attempt - num >= 1)
                                                    || (num - attempt <= 10 && num - attempt >= 1)) {
                                                System.out.println();
                                                System.out.println(
                                                        "==========================================================================");
                                                System.out.println(
                                                        "Quente! O seu último palpite tem até 10 unidades de diferença do objetivo.");
                                                System.out.println(
                                                        "==========================================================================");
                                            } else {
                                                System.out.println();
                                                System.out.println(
                                                        "============================================================================");
                                                System.out.println(
                                                        "Frio! O seu último palpite tem mais de 10 unidades de diferença do objetivo.");
                                                System.out.println(
                                                        "============================================================================");
                                            }
                                        } else if (firstAttempt) {
                                            System.out.println();
                                            System.out.println(
                                                    "Você não tem pontos para usar essa dica, selecione outra opção!");
                                        } else {
                                            System.out.println("Dê ao menos um palpite para poder usar essa dica");
                                        }
                                        break;
                                }
                            } while (correct != 3 && attempts > 0 && (points > 0));

                            if (correct == 3) {
                                for (int i = 0; i < attempts; i++) {
                                    points += 50;
                                }
                                System.out.println();
                                System.out.println("============================================");
                                System.out.println("Parabéns, você venceu o jogo com " + points + " pontos!");
                                System.out.println("============================================");
                            } else {
                                points = 0;
                                System.out.println();
                                System.out.println(
                                        "========================================================================");
                                System.out.println(
                                        "Você perdeu o jogo por ficar sem tentativas ou com pontos insuficientes!");
                                System.out.println(
                                        "========================================================================");
                            }

                            if (points > maxSequenceScore) {
                                maxSequenceScore = points;
                            }

                            sequenceScores.add(0, points);
                            if (correct == 3) {
                                sequenceScores.add(0, 1);
                            } else {
                                sequenceScores.add(0, 0);
                            }
                            if (sequenceScores.size() > 20) {
                                sequenceScores.remove(sequenceScores.size() - 1);
                                sequenceScores.remove(sequenceScores.size() - 1);
                            }
                        }
                    }
                    break;
                case 2:
                    System.out.println();
                    System.out.println("========Regras========");
                    System.out.println("Ao iniciar o jogo selecione um modo: ");
                    System.out.println("- Fácil: Adivinhe um número entre 1 e 50, com 10 tentativas;");
                    System.out.println("- Médio: Adivinhe um número entre 1 e 100, com 7 tentativas;");
                    System.out.println("- Difícil: Adivinhe um número entre 1 e 200, com 5 tentativas;");
                    System.out
                            .println("- Sequência: Adivinhe 3 números em sequência, entre 1 e 150, com 15 tentativas.");
                    System.out.println();
                    System.out.println("Após selecionar o modo, o jogo começa.");
                    System.out.println("Dê palpites inserindo um número.");
                    System.out.println();
                    System.out.println("Pontuação: ");
                    System.out.println("- Fácil: A pontuação inicial é 100;");
                    System.out.println("- Médio: A pontuação inicial é 200;");
                    System.out.println("- Difícil: A pontuação inicial é 300;");
                    System.out.println("- Sequência: A pontuação inicial é 400.");
                    System.out.println("Cada tentativa usada desconta 5 pontos.");
                    System.out.println("Um bônus de 50 pontos é dado ao final do jogo para cada tentativa não usada.");
                    System.out.println("Descontos na pontuação também occorrem pelo uso de dicas.");
                    System.out.println();
                    System.out.println("Dicas: ");
                    System.out.println("- Dica de paridade (par/ímpar): -10 pontos.");
                    System.out.println("- Dica de intervalo (metade superior/inferior): -20 pontos.");
                    System.out.println("- Dica de proximidade (quente/frio): -15 pontos.");
                    System.out.println();
                    System.out.println(
                            "Você perde se ficar sem tentativas ou se chegar a 0 pontos sem ter acertado o número.");
                    System.out.println(
                            "Ao acertar o número, você vence a partida, mesmo que o palpite tenha zerado seus pontos.");
                    System.out.println(
                            "Nesse caso, o bônus de tentativas restantes é concedido normalmente.");
                    System.out.println("======================");
                    break;
                case 3:
                    System.out.println();
                    System.out.println("=========================");
                    System.out.println("Histórico de pontuações: ");
                    System.out.println("=========================");
                    System.out.println();
                    System.out.println("Modo fácil: ");
                    System.out.println();
                    if (easyScores.size() > 0) {
                        for (int i = 0; i < (easyScores.size() / 2); i++) {
                            System.out.println((easyScores.get(i * 2) == 1 ? "Vitória " : "Derrota ") + "- Pontuação: "
                                    + easyScores.get((i * 2) + 1));
                        }
                        System.out.println();
                        System.out.println("Recorde: " + maxEasyScore);
                    } else {
                        System.out.println("Ainda não existem pontuações registradas nesse modo.");
                    }
                    System.out.println();
                    System.out.println("Modo médio: ");
                    System.out.println();
                    if (mediumScores.size() > 0) {
                        for (int i = 0; i < (mediumScores.size() / 2); i++) {
                            System.out.println((mediumScores.get(i * 2) == 1 ? "Vitória " : "Derrota ")
                                    + "- Pontuação: " + mediumScores.get((i * 2) + 1));
                        }
                        System.out.println();
                        System.out.println("Recorde: " + maxMediumScore);
                    } else {
                        System.out.println("Ainda não existem pontuações registradas nesse modo.");
                    }
                    System.out.println();
                    System.out.println("Modo difícil: ");
                    System.out.println();
                    if (hardScores.size() > 0) {
                        for (int i = 0; i < (hardScores.size() / 2); i++) {
                            System.out.println((hardScores.get(i * 2) == 1 ? "Vitória " : "Derrota ") + "- Pontuação: "
                                    + hardScores.get((i * 2) + 1));
                        }
                        System.out.println();
                        System.out.println("Recorde: " + maxHardScore);
                    } else {
                        System.out.println("Ainda não existem pontuações registradas nesse modo.");
                    }
                    System.out.println();
                    System.out.println("Modo sequência: ");
                    System.out.println();
                    if (sequenceScores.size() > 0) {
                        for (int i = 0; i < (sequenceScores.size() / 2); i++) {
                            System.out.println((sequenceScores.get(i * 2) == 1 ? "Vitória " : "Derrota ")
                                    + "- Pontuação: " + sequenceScores.get((i * 2) + 1));
                        }
                        System.out.println();
                        System.out.println("Recorde: " + maxSequenceScore);
                    } else {
                        System.out.println("Ainda não existem pontuações registradas nesse modo.");
                    }

                    break;
                case 4:
                    System.out.println("Até mais!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }
}
