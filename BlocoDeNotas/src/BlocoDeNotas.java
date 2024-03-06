import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BlocoDeNotas {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {


        System.out.printf("Escolha uma opção: %n 1 - Adicionar nova anotação %n 2 - Editar anotações existentes %n 3 - Buscar anotações a partir de um texto de busca " +
                "%n 4 - Listar todas as anotações %n 5 - Finalizar programa %n");

        int opcao = 0;

        while (opcao != 5) {
            opcao = sc.nextInt();

            switch (opcao) {
                case (1):
                    System.out.println("=+=+=+=+=+=+=+=+=// Digite a nova anotação: //=+=+=+=+=+=+=+=+=");
                    String anotacao = sc.nextLine();
                    break;

                case (2):
                    System.out.println("=+=+=+=+=+=+=+=+=// Qual anotação você deseja editar? //=+=+=+=+=+=+=+=+=");
                    int editar = sc.nextInt();
                    break;

                case (3):
                    System.out.println("=+=+=+=+=+=+=+=+=// Digite o texto de busca: //=+=+=+=+=+=+=+=+=");
                    String textoDeBusca = sc.nextLine();
                    break;

                case (4):
                    System.out.println("=+=+=+=+=+=+=+=+=// Anotações sendo exibidas: //=+=+=+=+=+=+=+=+=");
                    break;

                case (5):
                    System.out.println("=+=+=+=+=+=+=+=+=// Finalizando programa. //=+=+=+=+=+=+=+=+=");
                    break;

                default:
                    System.err.println("Opção " + opcao + " desconhecida");
                    break;
            }


        }
    }
}