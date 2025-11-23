public class Main {
    public static void main(String[] args) {

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
    }
}
