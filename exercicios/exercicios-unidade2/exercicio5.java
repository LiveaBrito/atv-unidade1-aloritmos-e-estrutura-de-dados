// 5 - Inversão com Pilha:
// Implemente um método para inverter a ordem dos elementos em um ArrayList utilizando uma pilha.

import java.util.ArrayList;
import java.util.Stack;

public class exercicio5 {
    public static void main(String[] args) {
        ArrayList<Integer> lista = new ArrayList<>();
        lista.add(1);
        lista.add(2);
        lista.add(3);

        Stack<Integer> pilha = new Stack<>();

        for (Integer num : lista) {
            pilha.push(num);
        }

        lista.clear();

        while (!pilha.isEmpty()) {
            lista.add(pilha.pop());
        }

        System.out.println("Lista invertida: " + lista);
    }
}
