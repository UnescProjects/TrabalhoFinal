import java.util.*;

public class CaminhoMinimo {

    public static class Resultado {
        public int[] distancia;
        public int[] pai;

        public Resultado(int[] distancia, int[] pai) {
            this.distancia = distancia;
            this.pai = pai;
        }
    }

    public static Resultado dijkstra(Grafo grafo, int origem) {
        int n = grafo.getNumeroVertices();
        int[] distancia = new int[n];
        int[] pai = new int[n];
        boolean[] visitado = new boolean[n];

        Arrays.fill(distancia, Integer.MAX_VALUE);
        Arrays.fill(pai, -1);
        distancia[origem] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{origem, 0});

        while (!pq.isEmpty()) {
            int[] atual = pq.poll();
            int u = atual[0];

            if (visitado[u]) continue;
            visitado[u] = true;

            for (Aresta a : grafo.getAdj(u)) {
                int v = a.destino;
                int peso = a.peso;

                if (distancia[u] + peso < distancia[v]) {
                    distancia[v] = distancia[u] + peso;
                    pai[v] = u;
                    pq.add(new int[]{v, distancia[v]});
                }
            }
        }

        return new Resultado(distancia, pai);
    }

    public static List<Integer> reconstruirCaminho(int destino, int[] pai) {
        List<Integer> caminho = new ArrayList<>();
        for (int v = destino; v != -1; v = pai[v]) {
            caminho.add(v);
        }
        Collections.reverse(caminho);
        return caminho;
    }
}
