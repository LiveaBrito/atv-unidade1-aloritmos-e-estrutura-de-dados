// import java.util.HashMap;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Cardapio {

    private Map<String, Double> cardapio;

    public Cardapio() {

        cardapio = new HashMap<>();

        cardapio.put("Margherita", 30.00);
        cardapio.put("Pepperoni", 35.00);
        cardapio.put("Quatro queijos", 37.00);
        cardapio.put("Calabresa", 33.00);
        cardapio.put("Frango com Catupiry", 36.50);
        cardapio.put("Portuguesa", 33.40);
        cardapio.put("Mussarela", 28.00);
        cardapio.put("Atum", 38.70);
        cardapio.put("Vegetariana", 34.30);
        cardapio.put("Especial da casa", 42.20);
    }

    public Map<String, Double> getCardapio() {
        return cardapio;
    }

    public double getPrecoJusto(List<String> sabores) {

        double maior = 0;

        for (String sabor : sabores) {

            if (cardapio.containsKey(sabor)) {

                if (cardapio.get(sabor) > maior) {
                    maior = cardapio.get(sabor);
                }
            }
        }

        return maior;
    }
}
