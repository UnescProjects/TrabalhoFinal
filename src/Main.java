void main(String[] args) {

    List<Pacote> pacotes = LeitorDados.lerPacotes("data/pacotes.txt");
    Grafo mapa = LeitorDados.lerGrafo("data/mapa_exemplo.txt");

    // Programação Dinâmica
    List<Pacote> selecionados = ProgramacaoDinamica.resolverMochila(pacotes, 100); // capacidade = 100kg

    // Algoritmo Guloso
    List<Pacote> ordenados = Guloso.ordenarPorPrazo(selecionados);

    // Dijkstra
    double custoTotal = CaminhoMinimo.calcularRota(mapa, ordenados);

    ImpressaoResultados.mostrarRelatorio(selecionados, ordenados, custoTotal);
}
