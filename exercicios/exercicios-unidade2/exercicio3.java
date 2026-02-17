// 3 - Mesclar Listas:
// Implemente uma função que receba duas ArrayLists e retorne uma nova lista que contenha todos os elementos
// das listas originais intercalados.

import java.util.ArrayList;

public class exercicio3 {
    public static void main(String[] args) {
        ArrayList<Integer> lista1 = new ArrayList<>();
        ArrayList<Integer> lista2 = new ArrayList<>();

        lista1.add(1);
        lista1.add(3);
        lista1.add(5);

        lista2.add(2);
        lista2.add(4);
        lista2.add(6);

        ArrayList<Integer> mesclada = new ArrayList<>();

        int tamanho = Math.min(lista1.size(), lista2.size());

        for (int i = 0; i < tamanho; i++) {
            mesclada.add(lista1.get(i));
            mesclada.add(lista2.get(i));
        }

        System.out.println("Lista mesclada: " + mesclada);
    }
}
