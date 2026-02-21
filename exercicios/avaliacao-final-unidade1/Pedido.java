import java.util.List;

public class Pedido {

    private int numeroPedido;
    private Cliente cliente;
    private List<Pizza> pizzas;
    private double valorTotal;

    public Pedido(int numeroPedido, Cliente cliente, List<Pizza> pizzas, double valorTotal) {
        this.numeroPedido = numeroPedido;
        this.cliente = cliente;
        this.pizzas = pizzas;
        this.valorTotal = valorTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void atualizarValorTotal() {
        valorTotal = 0;
        for (Pizza pizza : pizzas) {
            valorTotal += pizza.getPreco();
        }
    }

    public void adicionarPizza(Pizza pizza) {
        pizzas.add(pizza);
        atualizarValorTotal();
    }

    public void removerUltimaPizza() {
        if (!pizzas.isEmpty()) {
            pizzas.remove(pizzas.size() - 1);
            atualizarValorTotal();
        }
    }

    public void exibirResumo() {
        System.out.println("Pedido Nº: " + numeroPedido);
        System.out.println("Cliente: " + cliente.getNome());
        for (Pizza pizza : pizzas) {
            System.out.println("Pizza: " + pizza.getSabores() + " - " + pizza.getTamanho());
        }
        System.out.println("Total sem frete: R$ " + valorTotal);
    }
}