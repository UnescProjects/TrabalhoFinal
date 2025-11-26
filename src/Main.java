import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try{
        Pacote[] pacotes = {
                new Pacote(5, 10, 7),
                new Pacote(8, 14, 6),
                new Pacote(2, 5, 10),
                new Pacote(6, 7, 5),
                new Pacote(7, 9, 2)
        };

        int capacidade = 15;

        Resultado r = MochilaPD.MochilaPD(pacotes, capacidade);

        System.out.println("Valor máximo: " + r.valorMaximo);

        System.out.println("Pacotes escolhidos:");
        for (Pacote p : r.selecionados) {
            System.out.println("- Peso: " + p.peso + " | Valor: " + p.valor + " | Prazo: " + p.prazo);
        }

        Grafo grafo = new Grafo(6);
            grafo.adicionarAresta(0, 1, 4);
            grafo.adicionarAresta(0, 2, 2);
            grafo.adicionarAresta(2, 3, 1);
            grafo.adicionarAresta(1, 3, 5);
            grafo.adicionarAresta(3, 4, 3);
            grafo.adicionarAresta(4, 5, 2);

            System.out.println("\n=== (ROTA FINAL) ===");

            List<Integer> ordem = new ArrayList<>();
            ordem.add(0);
            ordem.add(2);
            ordem.add(3);
            ordem.add(4);
            ordem.add(5);

            Roteirizacao.RotaFinal rota = Roteirizacao.calcularRota(grafo, ordem);

            System.out.println("\nRota final(Ordem): " + rota.rota);
            System.out.println("Custo total da rota: " + rota.custoTotal);

        } catch (Exception e) {
            e.printStackTrace();
    }
}
}

