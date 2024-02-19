import java.util.Scanner;
public class Impares {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o valor N: ");
        int n = sc.nextInt();

        for(int i = 1; i < n+1; i++){
            if(i % 2 != 0){
                System.out.println("Número ímpar: " + i);
            }

        }

    }
}
