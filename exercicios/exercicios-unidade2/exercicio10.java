// Algoritmos de Ordenação:
// 10 - Implementação de Algoritmo de Ordenação:
// Escolha um algoritmo de ordenação (ex: Bubble Sort, Quick Sort, Merge Sort) e implemente-o
// para ordenar um ArrayList de números inteiros de forma decrescente.

import java.util.ArrayList;

public class exercicio10 {
    public static void main(String[] args) {
        ArrayList<Integer> lista = new ArrayList<>();
        lista.add(5);
        lista.add(2);
        lista.add(9);
        lista.add(1);

        for (int i = 0; i < lista.size(); i++) {
            for (int j = 0; j < lista.size() - 1; j++) {
                if (lista.get(j) < lista.get(j + 1)) {
                    int temp = lista.get(j);
                    lista.set(j, lista.get(j + 1));
                    lista.set(j + 1, temp);
                }
            }
        }

        System.out.println("Lista ordenada decrescente: " + lista);
    }
}
