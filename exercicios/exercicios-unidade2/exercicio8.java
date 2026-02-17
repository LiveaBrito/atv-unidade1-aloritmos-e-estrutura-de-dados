// Maps (HashMap):
// 8 - Contagem de Palavras:
// Escreva um programa que conte a frequência das palavras em uma frase utilizando um HashMap.

import java.util.HashMap;

public class exercicio8 {
    public static void main(String[] args) {
        String frase = "java é bom e java é poderoso";
        String[] palavras = frase.split(" ");

        HashMap<String, Integer> contador = new HashMap<>();

        for (String palavra : palavras) {
            contador.put(palavra, contador.getOrDefault(palavra, 0) + 1);
        }

        System.out.println(contador);
    }
}
