import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int opcao;
        int recorde = 0;
        String jogadorRecorde = "";

        do {
            System.out.println("\n==============================");
            System.out.println("       JOGO DO MARCIANO");
            System.out.println("==============================");
            System.out.println("1 - Iniciar jogo");
            System.out.println("2 - Ver recorde");
            System.out.println("3 - Como jogar");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();

            if (opcao == 1) {

                System.out.println("\n--- ESCOLHA A DIFICULDADE ---");
                System.out.println("D - Difícil (7 tentativas)");
                System.out.println("M - Médio   (8 tentativas)");
                System.out.println("F - Fácil   (10 tentativas)");
                System.out.print("Dificuldade: ");

                char dificuldade = scanner.next().toUpperCase().charAt(0);

                // Verifica se a dificuldade escolhida é válida
                while (dificuldade != 'D' && dificuldade != 'M' && dificuldade != 'F') {
                    System.out.print("Opção inválida. Digite D, M ou F: ");
                    dificuldade = scanner.next().toUpperCase().charAt(0);
                }

                int limite;

                if (dificuldade == 'D') {
                    limite = 7;
                } else if (dificuldade == 'M') {
                    limite = 8;
                } else {
                    limite = 10;
                }

                int arvoreMarciano = random.nextInt(100) + 1;
                int tentativa = 0;
                int contador = 0;

                System.out.println("\n--- MISSÃO ---");
                System.out.println("Um marciano pousou na Terra e resolveu se esconder");
                System.out.println("em uma das 100 árvores da floresta.");
                System.out.println("Sua missão é descobrir onde ele está!");
                System.out.println("Você terá " + limite + " tentativas.");

                if (recorde == 0) {
                    System.out.println("Ainda não temos um recordista.");
                } else {
                    System.out.println("Recorde atual: " + jogadorRecorde +
                            " com " + recorde + " tentativa(s).");
                }

                while (tentativa != arvoreMarciano && contador < limite) {

                    System.out.print("\nEscolha uma árvore de 1 a 100: ");
                    tentativa = scanner.nextInt();

                    if (tentativa < 1 || tentativa > 100) {
                        System.out.println("Essa árvore não existe! Escolha um número de 1 a 100.");
                        continue;
                    }

                    contador++;

                    if (tentativa < arvoreMarciano) {
                        System.out.println("O marciano está em uma árvore MAIOR!");
                    } else if (tentativa > arvoreMarciano) {
                        System.out.println("O marciano está em uma árvore MENOR!");
                    } else {
                        System.out.println("\nVocê encontrou o marciano!");
                        System.out.println("Ele estava escondido na árvore " + arvoreMarciano + ".");
                        System.out.println("Você precisou de " + contador + " tentativa(s).");
                    }

                    if (tentativa != arvoreMarciano) {
                        System.out.println("Tentativas restantes: " + (limite - contador));
                    }
                }

                if (tentativa == arvoreMarciano) {

                    if (recorde == 0 || contador < recorde) {

                        System.out.println("\nNovo recorde!");

                        scanner.nextLine();

                        System.out.print("Digite seu nome: ");
                        jogadorRecorde = scanner.nextLine();

                        recorde = contador;

                        System.out.println("Recorde registrado para " + jogadorRecorde + "!");
                    }

                } else {
                    System.out.println("\nFim de jogo!");
                    System.out.println("Suas tentativas acabaram.");
                    System.out.println("O marciano estava na árvore " + arvoreMarciano + ".");
                }

            } else if (opcao == 2) {

                System.out.println("\n--- RECORDE ---");

                if (recorde == 0) {
                    System.out.println("Nenhum jogador conseguiu registrar um recorde ainda.");
                } else {
                    System.out.println("Jogador: " + jogadorRecorde);
                    System.out.println("Melhor resultado: " + recorde + " tentativa(s).");
                }

            } else if (opcao == 3) {

                System.out.println("\n--- COMO JOGAR ---");
                System.out.println("O marciano está escondido entre as árvores 1 e 100.");
                System.out.println("A cada tentativa, você escolhe uma árvore.");
                System.out.println("O jogo dará uma dica dizendo se o número correto");
                System.out.println("é maior ou menor que o número escolhido.");
                System.out.println();
                System.out.println("D - Difícil: 7 tentativas");
                System.out.println("M - Médio: 8 tentativas");
                System.out.println("F - Fácil: 10 tentativas");

            } else if (opcao == 0) {

                System.out.println("\nJogo encerrado. Até a próxima!");

            } else {

                System.out.println("\nOpção inválida. Tente novamente.");
            }

        } while (opcao != 0);

        scanner.close();
    }
}