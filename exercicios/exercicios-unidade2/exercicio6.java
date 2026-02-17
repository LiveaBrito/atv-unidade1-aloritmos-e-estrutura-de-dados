// Filas:
// 6 - Implementação de um Sistema de Fila de Espera:
// Crie um sistema simples de fila de espera com funcionalidades de adicionar, remover e exibir elementos.

import java.util.LinkedList;
import java.util.Queue;

public class exercicio6 {
    public static void main(String[] args) {
        Queue<String> fila = new LinkedList<>();

        fila.add("Cliente 1");
        fila.add("Cliente 2");
        fila.add("Cliente 3");

        System.out.println("Fila: " + fila);

        fila.poll();
        System.out.println("Após atender um cliente: " + fila);
    }
}
