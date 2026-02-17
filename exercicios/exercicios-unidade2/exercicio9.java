// 9 - Mesclar Mapas:
// Implemente um método para mesclar dois HashMaps e manipular possíveis conflitos de chaves.

import java.util.HashMap;

public class exercicio9 {
    public static void main(String[] args) {
        HashMap<String, Integer> mapa1 = new HashMap<>();
        mapa1.put("A", 1);
        mapa1.put("B", 2);

        HashMap<String, Integer> mapa2 = new HashMap<>();
        mapa2.put("B", 3);
        mapa2.put("C", 4);

        for (String chave : mapa2.keySet()) {
            mapa1.put(chave, mapa1.getOrDefault(chave, 0) + mapa2.get(chave));
        }

        System.out.println("Mapa mesclado: " + mapa1);
    }
}
