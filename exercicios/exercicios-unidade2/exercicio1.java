// Listas (ArrayList):
// 1 - Inversão de Lista:
// Escreva um programa para inverter os elementos de um ArrayList sem usar métodos prontos do java.

import java.util.ArrayList;

public class exercicio1 {
    public static void main(String[] args) {
        ArrayList<Integer> lista = new ArrayList<>();

        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.add(4);

        System.out.println("Lista original: " + lista);

        // Inversão manual
        for (int i = 0; i < lista.size() / 2; i++) {
            int temp = lista.get(i);
            lista.set(i, lista.get(lista.size() - 1 - i));
            lista.set(lista.size() - 1 - i, temp);
        }

        System.out.println("Lista invertida: " + lista);
    }
}

