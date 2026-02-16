// Exercício 2: Estruturas Condicionais
// • Escreva um programa que leia um número e determine se ele é par ou ímpar. Imprima o
// resultado na tela. 

import java.util.Scanner;

public class exercicio2 {
    
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite um numero: ");
        int numero = scanner.nextInt();

        if (numero % 2 == 0){
            System.out.print("O numero digitado: " + numero + " é par");
        }else{
            System.out.print("O numero digitado: " + numero + " é ímpar");
        }
    }
}
