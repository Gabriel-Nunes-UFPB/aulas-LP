import banco.entidades.ContaSimples;
import java.util.Random;
public class Loteria {
    public static void main(String[] args) {
        ContaSimples marina = new ContaSimples("Marina", "111222333-44");
        marina.depositar(1000.00);

        int valorGanhoLoteria = loteria(1500000);

        System.out.println("O Saldo de Marina antes da loteria é: R$" + marina.getSaldo());
        System.out.println("Valor adquirido na loteria: R$" + valorGanhoLoteria );
        marina.depositar(valorGanhoLoteria);
        System.out.println("O saldo de Marina é: R$" + marina.getSaldo());


    }

    private static int loteria(int premioMaximo) {

        Random rand = new Random();

        return rand.nextInt(premioMaximo);

    }
}