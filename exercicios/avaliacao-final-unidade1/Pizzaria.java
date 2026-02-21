import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pizzaria {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Cliente> listaClientes = new ArrayList<>();
        List<Pedido> listaPedidos = new ArrayList<>();
        Cardapio cardapio = new Cardapio();

        boolean continuar = true;

        while (continuar) {

            System.out.println("\n===== PIZZARIA =====");
            System.out.println("1 - Fazer novo pedido");
            System.out.println("2 - Alterar pedido");
            System.out.println("3 - Adicionar cliente");
            System.out.println("4 - Gerar relatório");
            System.out.println("5 - Listar clientes");
            System.out.println("9 - Sair");
            System.out.print("Opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:
                    fazerPedido(scanner, listaPedidos, listaClientes, cardapio);
                    break;

                case 2:
                    alterarPedido(scanner, listaPedidos);
                    break;

                case 3:
                    listaClientes.add(adicionarCliente(scanner));
                    System.out.println("Cliente adicionado!");
                    break;

                case 4:
                    gerarRelatorio(listaPedidos, scanner);
                    break;

                case 5:
                    gerarListaClientes(listaClientes);
                    break;

                case 9:
                    continuar = false;
                    break;
            }
        }

        scanner.close();
        System.out.println("Sistema encerrado.");
    }

    private static void fazerPedido(Scanner scanner, List<Pedido> listaPedidos,
                                    List<Cliente> listaClientes, Cardapio cardapio) {

        if (listaClientes.isEmpty()) {
            System.out.println("Cadastre um cliente primeiro.");
            return;
        }

        System.out.println("Selecione o cliente:");
        for (int i = 0; i < listaClientes.size(); i++) {
            System.out.println((i + 1) + " - " + listaClientes.get(i).getNome());
        }

        int clienteIndex = scanner.nextInt() - 1;
        scanner.nextLine();

        List<Pizza> pizzas = new ArrayList<>();

        boolean continuar = true;
        while (continuar) {

            List<String> saboresList = new ArrayList<>(cardapio.getCardapio().keySet());

            for (int i = 0; i < saboresList.size(); i++) {
                System.out.println((i + 1) + " - " + saboresList.get(i));
            }

            System.out.print("Escolha sabor: ");
            int saborIndex = scanner.nextInt() - 1;
            scanner.nextLine();

            List<String> sabores = new ArrayList<>();
            sabores.add(saboresList.get(saborIndex));

            Pizza pizza = new Pizza(
                    sabores,
                    cardapio.getPrecoJusto(sabores),
                    Pizza.TamanhoPizza.MEDIA
            );

            pizzas.add(pizza);

            System.out.print("Adicionar outra pizza? 1-Sim 2-Não: ");
            continuar = scanner.nextInt() == 1;
            scanner.nextLine();
        }

        Pedido pedido = new Pedido(
                listaPedidos.size() + 1,
                listaClientes.get(clienteIndex),
                pizzas,
                0
        );

        pedido.atualizarValorTotal();
        listaPedidos.add(pedido);

        System.out.println("Pedido cadastrado com sucesso!");
    }

    private static void alterarPedido(Scanner scanner, List<Pedido> listaPedidos) {

        if (listaPedidos.isEmpty()) {
            System.out.println("Nenhum pedido cadastrado.");
            return;
        }

        System.out.print("Digite o nome do cliente: ");
        String nome = scanner.nextLine();

        for (Pedido pedido : listaPedidos) {

            if (pedido.getCliente().getNome().equalsIgnoreCase(nome)) {

                System.out.println("1 - Adicionar pizza");
                System.out.println("2 - Remover última pizza");

                int opcao = scanner.nextInt();
                scanner.nextLine();

                if (opcao == 2) {
                    pedido.removerUltimaPizza();
                    System.out.println("Pizza removida.");
                }

                pedido.exibirResumo();
                return;
            }
        }

        System.out.println("Pedido não encontrado.");
    }

    private static void gerarRelatorio(List<Pedido> listaPedidos, Scanner scanner) {

        if (listaPedidos.isEmpty()) {
            System.out.println("Nenhuma venda registrada.");
            return;
        }

        System.out.print("Digite a distância média de entrega (km): ");
        double distancia = scanner.nextDouble();
        scanner.nextLine();

        double faturamentoTotal = 0;

        for (Pedido pedido : listaPedidos) {

            int qtdPizzas = pedido.getPizzas().size();
            double frete = calcularFrete(distancia, qtdPizzas);
            double totalComFrete = pedido.getValorTotal() + frete;

            faturamentoTotal += totalComFrete;

            pedido.exibirResumo();
            System.out.println("Frete: R$ " + frete);
            System.out.println("Total com frete: R$ " + totalComFrete);
            System.out.println("------------------------");
        }

        System.out.println("Faturamento total: R$ " + faturamentoTotal);
    }

    private static void gerarListaClientes(List<Cliente> listaClientes) {

        if (listaClientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }

        for (Cliente cliente : listaClientes) {
            System.out.println(cliente.getNome());
            System.out.println(cliente.getEndereco());
            System.out.println(cliente.getTelefone());
            System.out.println(cliente.getEmail());
            System.out.println("----------------");
        }
    }

    private static Cliente adicionarCliente(Scanner scanner) {

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();

        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        return new Cliente(nome, endereco, telefone, email);
    }

    private static double calcularFrete(double distancia, int quantidadePizzas) {
        double valorPorKm = 2.0;
        double valorPorPizza = 5.0;
        return (distancia * valorPorKm) + (quantidadePizzas * valorPorPizza);
    }
}