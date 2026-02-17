// Pilhas:
// 4 - Verificação de Expressões:
// Utilizando pilhas, desenvolva um programa para verificar se uma expressão matemática 
// contendo parênteses está balanceada.

import java.util.Stack;

public class exercicio4 {
    public static void main(String[] args) {
        String expressao = "(2 + (3 * 4))";
        Stack<Character> pilha = new Stack<>();
        boolean balanceada = true;

        for (char c : expressao.toCharArray()) {
            if (c == '(') {
                pilha.push(c);
            } else if (c == ')') {
                if (pilha.isEmpty()) {
                    balanceada = false;
                    break;
                }
                pilha.pop();
            }
        }

        if (!pilha.isEmpty()) {
            balanceada = false;
        }

        if (balanceada) {
            System.out.println("Expressão balanceada.");
        } else {
            System.out.println("Expressão não balanceada.");
        }
    }
}
