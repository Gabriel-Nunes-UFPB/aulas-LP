import banco.entidades.ContaSimples;
public class Banco2 {
    public static void main(String[] args) {
        ContaSimples contaJoao = new ContaSimples("João", "309140605-06");
        contaJoao.depositar(1000.00);

        ContaSimples contaAna = new ContaSimples("Ana", "123456789-01");
        contaJoao.transferir(contaAna, 400);

        System.out.println(contaJoao);
        System.out.println(contaAna);
    }
}
