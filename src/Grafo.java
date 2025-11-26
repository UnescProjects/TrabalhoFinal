import java.util.ArrayList;
import java.util.List;

public class Grafo {

    private List<List<Aresta>> adj;

    public Grafo(int numVertices) {
        adj = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public void adicionarAresta(int origem, int destino, int peso) {
        adj.get(origem).add(new Aresta(destino, peso));
        adj.get(destino).add(new Aresta(origem, peso)); 
    }

    public List<Aresta> getAdj(int v) {
        return adj.get(v);
    }

    public int getNumeroVertices() {
        return adj.size();
    }
}
