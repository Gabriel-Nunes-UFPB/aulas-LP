import banco.entidades.Conta;
import banco.entidades.ContaSimples;
public class Banco1 {
    public static void main(String[] args) {
        ContaSimples umaConta = new ContaSimples ("João", "309140605-06");
        umaConta.depositar(1000.00);

        System.out.println("Saldo inicial da conta" + umaConta.getNúmero() + " antes do saque é R$" + umaConta.getSaldo());

        umaConta.sacar(300.00);
        System.out.println(umaConta);
        System.out.println("Saldo da conta " + umaConta.getNúmero() + " depois do saque é R$ " + umaConta.getSaldo());
    }
}