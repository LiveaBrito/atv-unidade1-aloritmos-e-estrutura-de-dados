// 2 - Remoção de Elementos Duplicados:
// Crie um método para remover elementos duplicados de um ArrayList.

import java.util.ArrayList;

public class exercicio2 {
    public static void main(String[] args) {
        ArrayList<Integer> lista = new ArrayList<>();
        lista.add(1);
        lista.add(2);
        lista.add(2);
        lista.add(3);
        lista.add(1);

        ArrayList<Integer> semDuplicados = new ArrayList<>();

        for (Integer num : lista) {
            if (!semDuplicados.contains(num)) {
                semDuplicados.add(num);
            }
        }

        System.out.println("Lista original: " + lista);
        System.out.println("Sem duplicados: " + semDuplicados);
    }
}
