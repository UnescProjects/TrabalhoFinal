public class MochilaPD {

    public static Resultado MochilaPD(Pacote[] pacotes, int capacidade) {
        int n = pacotes.length;
        int[][] dp = new int[n + 1][capacidade + 1];

        for (int i = 1; i <= n; i++) {
            int peso = pacotes[i - 1].peso;
            int valor = pacotes[i - 1].valor;

            for (int w = 1; w <= capacidade; w++) {

                if (peso > w) {
                    dp[i][w] = dp[i - 1][w];
                } else {
                    dp[i][w] = Math.max(
                            dp[i - 1][w],
                            valor + dp[i - 1][w - peso]
                    );
                }
            }
        }

        java.util.List<Pacote> escolhidos = new java.util.ArrayList<>();
        int w = capacidade;

        for (int i = n; i > 0; i--) {
            if (dp[i][w] != dp[i - 1][w]) {
                escolhidos.add(pacotes[i - 1]);
                w -= pacotes[i - 1].peso;
            }
        }

        return new Resultado(dp[n][capacidade], escolhidos);
    }
}
