// 7 - Ordem de Chegada:
// Crie um programa para simular a ordem de chegada de elementos em uma fila e exiba a ordem de saída.

import java.util.LinkedList;
import java.util.Queue;

public class exercicio7 {
    public static void main(String[] args) {
        Queue<Integer> fila = new LinkedList<>();

        fila.add(10);
        fila.add(20);
        fila.add(30);

        System.out.println("Ordem de chegada: " + fila);

        while (!fila.isEmpty()) {
            System.out.println("Saindo: " + fila.poll());
        }
    }
}
