import banco.entidades.ContaSimples;
import banco.entidades.util.RecebeDados;

public class Banco5 {
    public static void main(String args[]) {
        final int DEPOSITAR = 1;
        final int SACAR = 2;
        final int SALDO = 3;
        final int SAIR = 4;

        final String fimDeLinha = System.getProperty("line.separator");

        final String prompt = "Digite a opcao desejada:" + fimDeLinha + DEPOSITAR + ". Depositar" + fimDeLinha +
                SACAR + ". Sacar" + fimDeLinha + SALDO + ". Saldo" + fimDeLinha + SAIR + ". Sair" + fimDeLinha + "Opcao: ";


        if (args.length != 2) {

            System.err.println("Sintaxe: java Banco5 titular cpf");
            System.exit(1);

        }


        ContaSimples aConta = new ContaSimples(args[0], args[1]);

        int opcao = RecebeDados.recebeInteiro(prompt);

        while (opcao != SAIR) {

            switch (opcao) {

                case DEPOSITAR:
                    double valorADepositar = RecebeDados.recebeValorMaiorQueZero("Entre com o valor a depositar: ");
                    aConta.depositar(valorADepositar);
                    break;

                case SACAR:
                    double valorASacar = RecebeDados.recebeValorMaiorQueZero("Entre com o valor a sacar: ");
                    aConta.sacar(valorASacar);
                    break;

                case SALDO:
                    System.out.println("Saldo: " + aConta.getSaldoMonetário());
                    break;

                default:
                    System.err.println("Opcao " + opcao + " desconhecida");
                    break;

            }

            opcao = RecebeDados.recebeInteiro(prompt);

        }

        System.out.println("Saldo final: " + aConta.getSaldoMonetário());

    }

}