import java.util.List;

public class Pizza {

    public enum TamanhoPizza {
        PEQUENA, MEDIA, GRANDE;

        public static TamanhoPizza getByIndex(int index) {
            return values()[index];
        }
    }

    private List<String> sabores;
    private double preco;
    private TamanhoPizza tamanho;

    public Pizza(List<String> sabores, double preco, TamanhoPizza tamanho) {
        this.sabores = sabores;
        this.preco = preco;
        this.tamanho = tamanho;
    }

    public double getPreco() {
        return preco;
    }

    public List<String> getSabores() {
        return sabores;
    }

    public TamanhoPizza getTamanho() {
        return tamanho;
    }
}