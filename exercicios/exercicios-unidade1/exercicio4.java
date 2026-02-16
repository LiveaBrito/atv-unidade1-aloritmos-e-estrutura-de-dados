// Exercício 4: Listas (ArrayList)
// • Implemente um programa que permita ao usuário adicionar e remover elementos de uma
// lista dinâmica (por exemplo, ArrayList) de números inteiros. 

import java.util.ArrayList;
import java.util.Scanner;

public class exercicio4 {

    public static void main(String[] args) throws Exception{
        
        ArrayList<Integer> listaNumeros = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        int opcao;

        do{
            System.out.println("Escolha uma das opções: ");
            System.out.println("1 - para adicionar um numero");
            System.out.println("2 - para remover um numero");
            System.out.println("3 - para ver a lista de numeros digitados");
            System.out.println("4 - para sair do programa");
            System.out.println("Opção: ");
            opcao = scanner.nextInt();

            switch(opcao){
                case 1:
                    System.out.print("Digite um numero: ");
                    int numero = scanner.nextInt();
                    listaNumeros.add(numero);
                    System.out.println("...adicionando numero");
                    System.out.println("Numero adicionado com sucesso");
                    break;
                case 2:
                    if(listaNumeros.isEmpty()){
                        System.out.println("Ainda não há valores digitados na lista para remover");
                    }else{
                        System.out.print("Digite qual o índice do numero que deseja remover da lista: ");
                        int indiceNumero = scanner.nextInt();
                        if(indiceNumero >= 0 && indiceNumero < listaNumeros.size()) {
                            listaNumeros.remove(indiceNumero);
                            System.out.println("Número removido da lista.");
                        } else {
                            System.out.println("Índice inválido. Tente novamente.");
                        }
                    }
                    break;
                case 3:
                    if (listaNumeros.isEmpty()) {
                        System.out.println("A lista está vazia.");
                    } else {
                        System.out.println("Lista de números:");
                        for (int i = 0; i < listaNumeros.size(); i++) {
                            System.out.println(i + " - " + listaNumeros.get(i));
                        }
                    }
                    break;
                case 4:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;

            }

        }while(opcao != 4);

    }

}