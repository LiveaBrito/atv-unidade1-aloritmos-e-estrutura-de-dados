// Árvore Binária e BST (Árvore Binária de Busca)
// Árvore Binária e BST (Árvore Binária de Busca)
// 1 - Implementação da Árvore Binária:
// Crie uma classe em Java para representar uma árvore binária e implemente métodos para inserir elementos, percorrer a árvore em pré-ordem, pós-ordem e em ordem.
// 2 - Validação de BST:
// Escreva um método para verificar se uma árvore binária é uma árvore binária de busca (BST).

class No {
    int valor;
    No esquerda;
    No direita;

    public No(int valor) {
        this.valor = valor;
        esquerda = null;
        direita = null;
    }
}

public class ArvoreBST {

    private No raiz;

    // EXERCÍCIO 1 - Inserção em BST
    public void inserir(int valor) {
        raiz = inserirRec(raiz, valor);
    }

    private No inserirRec(No atual, int valor) {
        if (atual == null) {
            return new No(valor);
        }

        if (valor < atual.valor) {
            atual.esquerda = inserirRec(atual.esquerda, valor);
        } else if (valor > atual.valor) {
            atual.direita = inserirRec(atual.direita, valor);
        }

        return atual;
    }

    // EXERCÍCIO 2 - Busca em BST
    public boolean buscar(int valor) {
        return buscarRec(raiz, valor);
    }

    private boolean buscarRec(No atual, int valor) {
        if (atual == null) {
            return false;
        }

        if (valor == atual.valor) {
            return true;
        }

        if (valor < atual.valor) {
            return buscarRec(atual.esquerda, valor);
        } else {
            return buscarRec(atual.direita, valor);
        }
    }

    // EXERCÍCIO 8 - Encontrar menor valor na BST
    public int encontrarMinimo() {
        if (raiz == null) {
            throw new IllegalStateException("Árvore vazia");
        }

        No atual = raiz;

        while (atual.esquerda != null) {
            atual = atual.esquerda;
        }

        return atual.valor;
    }

    // Método para exibir em ordem
    public void emOrdem() {
        emOrdemRec(raiz);
        System.out.println();
    }

    private void emOrdemRec(No atual) {
        if (atual != null) {
            emOrdemRec(atual.esquerda);
            System.out.print(atual.valor + " ");
            emOrdemRec(atual.direita);
        }
    }

    // MAIN PARA TESTE
    public static void main(String[] args) {
        ArvoreBST arvore = new ArvoreBST();

        arvore.inserir(50);
        arvore.inserir(30);
        arvore.inserir(70);
        arvore.inserir(20);
        arvore.inserir(40);

        System.out.println("Árvore em ordem:");
        arvore.emOrdem();

        System.out.println("Buscar 40: " + arvore.buscar(40));
        System.out.println("Menor valor: " + arvore.encontrarMinimo());
    }
}