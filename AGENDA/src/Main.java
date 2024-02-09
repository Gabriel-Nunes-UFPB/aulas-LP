import java.util.Scanner;

public class Main {

    private static final int tamanhoDaAgenda = 50;
    private static String[] nomesDaAgenda = new String[tamanhoDaAgenda];
    private static String[] numerosDaAgenda = new String[tamanhoDaAgenda];
    private static String[] emailsDaAgenda = new String[tamanhoDaAgenda];
    private static int poxicaoAtualAgenda = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.printf("Você deseja:%n1 - Adicionar novo contato%n2 - Pesquisar um contato%n3 - Encerrar%n");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    adicionarContato();
                    break;
                case 2:
                    pesquisarContato();
                    break;
                case 3:
                    System.out.println("Encerrando a agenda. Obrigado pelo tempo de uso :)");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 3);
    }

    private static void adicionarContato() {
        if (poxicaoAtualAgenda < tamanhoDaAgenda) {
            Scanner adicao = new Scanner(System.in);

            boolean nomeValido = false;
            do {
                System.out.println("Digite o nome do contato (sem números):");
                String nome = adicao.nextLine();
                if (nome.matches(".*\\d.*")) {
                    System.out.println("Nome inválido. Não deve conter números.");
                } else {
                    nomesDaAgenda[poxicaoAtualAgenda] = nome;
                    nomeValido = true;
                }
            } while (!nomeValido);

            boolean numeroValido = false;
            do {
                System.out.println("Digite o número do contato (apenas números):");
                String numero = adicao.nextLine();
                if (!numero.matches("\\d+")) {
                    System.out.println("Número inválido. Deve conter apenas números.");
                } else {
                    numerosDaAgenda[poxicaoAtualAgenda] = numero;
                    numeroValido = true;
                }
            } while (!numeroValido);

            boolean emailValido = false;
            do {
                System.out.println("Digite o e-mail do contato (lembre-se do @):");
                String email = adicao.nextLine();
                if (!email.contains("@")) {
                    System.out.println("E-mail inválido. Deve conter '@'.");
                } else {
                    emailsDaAgenda[poxicaoAtualAgenda] = email;
                    emailValido = true;
                }
            } while (!emailValido);

            poxicaoAtualAgenda++;

            System.out.println("Contato adicionado com sucesso!");
        } else {

            System.out.println("A agenda está cheia. Não é possível adicionar mais contatos.");
        }
    }

    private static void pesquisarContato() {
        Scanner pesquisa = new Scanner(System.in);

        System.out.println("Digite o nome do contato que deseja pesquisar:");
        String nomePesquisado = pesquisa.nextLine();

        boolean contatoEncontrado = false;

        for (int i = 0; i < poxicaoAtualAgenda; i++) {
            if (nomesDaAgenda[i].equalsIgnoreCase(nomePesquisado)) {
                System.out.println("Contato encontrado:");
                System.out.println("Nome: " + nomesDaAgenda[i]);
                System.out.println("Número: " + numerosDaAgenda[i]);
                System.out.println("E-mail: " + emailsDaAgenda[i]);
                contatoEncontrado = true;
                break;
            }
        }

        if (!contatoEncontrado) {
            System.out.println("Contato não encontrado.");
        }
    }
}
