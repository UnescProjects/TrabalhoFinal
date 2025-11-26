import java.util.ArrayList;
import java.util.List;

public class Roteirizacao {

    public static class RotaFinal {
        public List<Integer> rota;
        public int custoTotal;

        public RotaFinal(List<Integer> rota, int custoTotal) {
            this.rota = rota;
            this.custoTotal = custoTotal;
        }
    }

    public static RotaFinal calcularRota(Grafo grafo, List<Integer> ordem) {

        List<Integer> rotaCompleta = new ArrayList<>();
        int custoTotal = 0;

        for (int i = 0; i < ordem.size() - 1; i++) {
            int origem = ordem.get(i);
            int destino = ordem.get(i + 1);

            CaminhoMinimo.Resultado r = CaminhoMinimo.dijkstra(grafo, origem);

            List<Integer> trecho = CaminhoMinimo.reconstruirCaminho(destino, r.pai);

            if (i > 0) trecho.remove(0); 

            rotaCompleta.addAll(trecho);
            custoTotal += r.distancia[destino];
        }

        return new RotaFinal(rotaCompleta, custoTotal);
    }
}
