import banco.entidades.Agencia;
import banco.entidades.ContaSimples;
import banco.entidades.Pessoa;
import banco.entidades.util.RecebeDados;
public class Banco3 {
    public static void main(String[] args) {
        Pessoa oTitular1 = new Pessoa("Joao", "30914060506");
        Pessoa oTitular2 = new Pessoa("Ana", "12345678901");

        ContaSimples umaConta = new ContaSimples(oTitular1);
        ContaSimples outraConta = new ContaSimples(oTitular2);

        double valorADepositar = RecebeDados.recebeValorMaiorQueZero("Entre com o valor a depositar: ");

        System.out.println("Vou depositar " + valorADepositar);

        umaConta.depositar(valorADepositar);
        double ValorATransferir = RecebeDados.recebeValorMaiorQueZero("Valor para transferir a Ana: ");
        System.out.println("Foi transferido R$" + ValorATransferir + " para Ana.");
        umaConta.transferir(outraConta, ValorATransferir);

        Agencia.fecharCaixa();
        System.out.println("OK. Caixa fechado.");

    }
}
