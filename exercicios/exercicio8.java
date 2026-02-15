// Exercício 8: Estruturas Condicionais e Listas
// • Crie um programa que solicite ao usuário que insira uma lista de números inteiros e, em
// seguida, encontre e exiba o número que mais se repete.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class exercicio8 {

     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> lista = new ArrayList<>();

        System.out.println("Quantos números você deseja inserir?");
        int quantidade = scanner.nextInt();

        // Lendo os números
        for (int i = 0; i < quantidade; i++) {
            System.out.print("Digite o número " + (i + 1) + ": ");
            int numero = scanner.nextInt();
            lista.add(numero);
        }

        // Contando as repetições
        HashMap<Integer, Integer> contador = new HashMap<>();

        for (Integer num : lista) {
            contador.put(num, contador.getOrDefault(num, 0) + 1);
        }

        // Encontrando o número mais repetido
        int numeroMaisRepetido = lista.get(0);
        int maiorFrequencia = 0;

        for (Map.Entry<Integer, Integer> entry : contador.entrySet()) {
            if (entry.getValue() > maiorFrequencia) {
                maiorFrequencia = entry.getValue();
                numeroMaisRepetido = entry.getKey();
            }
        }

        System.out.println("\nNúmero que mais se repete: " + numeroMaisRepetido);
        System.out.println("Quantidade de vezes: " + maiorFrequencia);

        scanner.close();
    }
}
    
