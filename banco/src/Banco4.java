import banco.entidades.Agencia;
import banco.entidades.Conta;
import banco.entidades.ContaSimples;
import banco.entidades.Extrato;
import banco.entidades.util.Data;
import banco.entidades.util.RecebeDados;

public class Banco4 {
    public static void main(String[] args) {
        ContaSimples umaConta;
        Extrato umExtrato;
        Data hoje, ontem;

        umaConta = (ContaSimples) Agencia.localizarConta(1);
        System.out.println("Você tem " + umaConta.getSaldoMonetário() + " na conta!");

        double valor = RecebeDados.recebeValorMaiorQueZero("Quanto você quer sacar? ");
        umaConta.sacar(valor);

        hoje = new Data();
        ontem = new Data();
        ontem.somarDia(-1);
        umExtrato = umaConta.criarExtrato(ontem, hoje);

        System.out.printf("O Extrato é:%n" + umExtrato.formatar());
        System.out.println("Saldo: " + umaConta.getSaldoMonetário());

        Agencia.fecharCaixa();
    }
}
