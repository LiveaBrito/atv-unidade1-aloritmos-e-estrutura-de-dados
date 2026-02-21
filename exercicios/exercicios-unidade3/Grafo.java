// Grafos, BFS e DFS
// 5 - Representação de Grafos:
// Crie uma classe que represente um grafo em Java utilizando lista de adjacências
// ou matriz de adjacências.

import java.util.*;

public class Grafo {

    private Map<Integer, List<Integer>> listaAdj;

    public Grafo() {
        listaAdj = new HashMap<>();
    }

    // Adicionar vértice
    public void adicionarVertice(int vertice) {
        listaAdj.putIfAbsent(vertice, new ArrayList<>());
    }

    // Adicionar aresta
    public void adicionarAresta(int origem, int destino) {
        listaAdj.get(origem).add(destino);
    }

    // =========================
    // EXERCÍCIO 5 - BFS
    // =========================
    public void bfs(int inicio) {
        Set<Integer> visitados = new HashSet<>();
        Queue<Integer> fila = new LinkedList<>();

        visitados.add(inicio);
        fila.add(inicio);

        while (!fila.isEmpty()) {
            int atual = fila.poll();
            System.out.print(atual + " ");

            for (int vizinho : listaAdj.get(atual)) {
                if (!visitados.contains(vizinho)) {
                    visitados.add(vizinho);
                    fila.add(vizinho);
                }
            }
        }
        System.out.println();
    }

    // =====================================
    // EXERCÍCIO 6 - Busca de Caminho (BFS)
    // =====================================
    public boolean existeCaminho(int origem, int destino) {
        Set<Integer> visitados = new HashSet<>();
        Queue<Integer> fila = new LinkedList<>();

        fila.add(origem);
        visitados.add(origem);

        while (!fila.isEmpty()) {
            int atual = fila.poll();

            if (atual == destino) {
                return true;
            }

            for (int vizinho : listaAdj.get(atual)) {
                if (!visitados.contains(vizinho)) {
                    visitados.add(vizinho);
                    fila.add(vizinho);
                }
            }
        }

        return false;
    }

    // =========================
    // EXERCÍCIO 7 - DFS
    // =========================
    public void dfs(int inicio) {
        Set<Integer> visitados = new HashSet<>();
        dfsRec(inicio, visitados);
        System.out.println();
    }

    private void dfsRec(int vertice, Set<Integer> visitados) {
        visitados.add(vertice);
        System.out.print(vertice + " ");

        for (int vizinho : listaAdj.get(vertice)) {
            if (!visitados.contains(vizinho)) {
                dfsRec(vizinho, visitados);
            }
        }
    }

    // =========================================
    // EXERCÍCIO 9 - Caminho mais curto (BFS)
    // ==========================================
    public List<Integer> caminhoMaisCurto(int origem, int destino) {
        Map<Integer, Integer> anterior = new HashMap<>();
        Queue<Integer> fila = new LinkedList<>();
        Set<Integer> visitados = new HashSet<>();

        fila.add(origem);
        visitados.add(origem);

        while (!fila.isEmpty()) {
            int atual = fila.poll();

            if (atual == destino) {
                break;
            }

            for (int vizinho : listaAdj.get(atual)) {
                if (!visitados.contains(vizinho)) {
                    visitados.add(vizinho);
                    anterior.put(vizinho, atual);
                    fila.add(vizinho);
                }
            }
        }

        List<Integer> caminho = new ArrayList<>();
        Integer passo = destino;

        while (passo != null) {
            caminho.add(passo);
            passo = anterior.get(passo);
        }

        Collections.reverse(caminho);
        return caminho;
    }

    // =====================================
    // EXERCÍCIO 10 - Ordenação Topológica
    // ======================================
    public void ordenacaoTopologica() {
        Set<Integer> visitados = new HashSet<>();
        Stack<Integer> pilha = new Stack<>();

        for (Integer vertice : listaAdj.keySet()) {
            if (!visitados.contains(vertice)) {
                topoRec(vertice, visitados, pilha);
            }
        }

        while (!pilha.isEmpty()) {
            System.out.print(pilha.pop() + " ");
        }
        System.out.println();
    }

    private void topoRec(int vertice, Set<Integer> visitados, Stack<Integer> pilha) {
        visitados.add(vertice);

        for (int vizinho : listaAdj.get(vertice)) {
            if (!visitados.contains(vizinho)) {
                topoRec(vizinho, visitados, pilha);
            }
        }

        pilha.push(vertice);
    }

    // MAIN PARA TESTE
    public static void main(String[] args) {
        Grafo grafo = new Grafo();

        for (int i = 1; i <= 6; i++) {
            grafo.adicionarVertice(i);
        }

        grafo.adicionarAresta(1, 2);
        grafo.adicionarAresta(1, 3);
        grafo.adicionarAresta(2, 4);
        grafo.adicionarAresta(3, 5);
        grafo.adicionarAresta(4, 6);

        System.out.println("BFS:");
        grafo.bfs(1);

        System.out.println("DFS:");
        grafo.dfs(1);

        System.out.println("Existe caminho 1 -> 6:");
        System.out.println(grafo.existeCaminho(1, 6));

        System.out.println("Caminho mais curto 1 -> 6:");
        System.out.println(grafo.caminhoMaisCurto(1, 6));

        System.out.println("Ordenação Topológica:");
        grafo.ordenacaoTopologica();
    }
}
