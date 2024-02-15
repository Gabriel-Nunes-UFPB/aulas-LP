import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CaixaChatBot {
    private static List<Conta> listaContas = new ArrayList<>();
    private static Map<Integer, Conta> contas = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int opcao;

        do{
            System.out.printf("Escolha uma opção:%n 1.Criar nova conta%n 2.Acessar conta existente%n 3.Sair%n");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao){
                case 1:
                    criarNovaConta();
                    break;
                case 2:
                    acessarContaExistente();
                    break;
                case 3:
                    System.out.println("Fechando.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 3);

        System.out.println("Saldo final das contas: ");
        for (Integer numeroConta : contas.keySet()) {
            Conta conta = contas.get(numeroConta);
            System.out.println("Conta " + numeroConta + ": " + conta.getSaldo());
        }

    }

    class Conta {
        private double saldo;
        private List<String> transacoes;
        public Conta(){
            this.saldo = 0.0;
            this.transacoes = new ArrayList<>();
        }
        public double getSaldo() {
            return saldo;
        }
        public void depositar(double valor){
            saldo += valor;
            transacoes.add("Depósito: R$" + valor);
            System.out.printf("Depósito de R$%.2f realizado com sucesso.%n", valor);
        }
        public void sacar(double valor) {
            if (saldo >= valor) {
                saldo -= valor;
                System.out.printf("Saque de R$%.2f realizado com sucesso.%n", valor);
                transacoes.add("Saque: - R$" + valor);

            } else {
                System.out.println("Saldo insuficiente.");
            }
        }
        public void extrato() {
            System.out.println("Extrato da conta:");
            System.out.println("Saldo atual: " + saldo);
            System.out.println("Transações:");
            for (String extrato : transacoes) {
                System.out.println(extrato);
            }
        }
        public void transferir (Conta destino, double valor){
            if (saldo >= valor){
                saldo -= valor;
                destino.depositar(valor);
                transacoes.add("Transferência para conta " + System.identityHashCode(destino) + ": - " + valor);
            } else {
                System.out.println("Saldo insuficiente para transferência.");
            }
        }

    }

    public static void criarNovaConta() {
        System.out.println("Digite o número da conta: ");
        int numeroConta = scanner.nextInt();
        scanner.nextLine();

        if (contas.containsKey(numeroConta)){
            System.out.println("Essa conta já existe.");
        } else {
            CaixaChatBot caixa = new CaixaChatBot();
            Conta novaConta = caixa.new Conta();
            contas.put(numeroConta, novaConta);
            System.out.println("Conta criada com sucesso.");

        }
    }

    private static void acessarContaExistente(){
        System.out.println("Digite o número da conta: ");
        int numeroConta = scanner.nextInt();
        scanner.nextLine();

        Conta conta = contas.get(numeroConta);

        if (conta == null){
            System.out.println("Conta não encontrada.");
            return;
        }
        int opcao;
        do{
            System.out.printf("Escolha uma opção:%n 1.Depositar%n 2.Sacar%n 3.Extrato%n 4.Transferir%n 5.Saldo%n 6. Voltar%n");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao){
                case 1:
                    System.out.println("Digite o valor a depositar:");
                    double valorDeposito = scanner.nextDouble();
                    scanner.nextLine();
                    conta.depositar(valorDeposito);
                    break;
                case 2:
                    System.out.println("Digite o valor a sacar:");
                    double valorSaque = scanner.nextDouble();
                    scanner.nextLine();
                    conta.sacar(valorSaque);
                    break;
                case 3:
                    conta.extrato();
                    break;
                case 4:
                    System.out.println("Digite o número da conta de destino:");
                    int numeroContaDestino = scanner.nextInt();
                    scanner.nextLine();
                    if (numeroContaDestino < 1 || numeroContaDestino > contas.size()) {
                        System.out.println("Número de conta de destino inválido.");
                        break;
                    }

                    Conta contaDestino = contas.get(numeroContaDestino);
                    System.out.println("Digite o valor a transferir:");
                    double valorTransferencia = scanner.nextDouble();
                    scanner.nextLine();
                    conta.transferir(contaDestino, valorTransferencia);
                    break;

                case 5:
                    System.out.println("Saldo atual: " + conta.getSaldo());
                    break;
                case 6:
                    System.out.println("Retornando ao menu principal.");
                    break;
                default:
                    System.out.println("Opção Inválida.");
            }

        } while (opcao != 6);


    }
}
