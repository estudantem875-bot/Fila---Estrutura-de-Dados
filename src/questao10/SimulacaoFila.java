package questao10;

import java.util.Random;

public class SimulacaoFila {
    // Cores ANSI para deixar o console elegante e moderno
    private static final String RESET = "\u001B[0m";
    private static final String ROXO = "\u001B[35m";
    private static final String CIANO = "\u001B[36m";
    private static final String VERDE = "\u001B[32m";
    private static final String AMARELO = "\u001B[33m";
    private static final String VERMELHO = "\u001B[31m";
    private static final String NEGRITO = "\u001B[1m";

    private int tempoTotal;
    private int numGuiches;
    private int tempoMaxAtendimento;
    private int maxFansPorMinuto;

    private FilaPrioridade fila;
    private Guiche[] guiches;
    private int totalAtendidos;
    private int proximoIdFa;
    private Random random;

    public SimulacaoFila(int tempoTotal, int numGuiches, int tempoMaxAtendimento, int maxFansPorMinuto) {
        this.tempoTotal = tempoTotal;
        this.numGuiches = numGuiches;
        this.tempoMaxAtendimento = tempoMaxAtendimento;
        this.maxFansPorMinuto = maxFansPorMinuto;
        this.fila = new FilaPrioridade();
        this.guiches = new Guiche[numGuiches];
        this.totalAtendidos = 0;
        this.proximoIdFa = 1;
        this.random = new Random();
    }

    public void executar() {
        // Inicializar os guichês
        for (int i = 0; i < numGuiches; i++) {
            guiches[i] = new Guiche(i + 1);
        }

        System.out.println("\n" + ROXO + NEGRITO + "==================================================");
        System.out.println("  INICIANDO SIMULAÇÃO DE VENDAS DE INGRESSOS ");
        System.out.println("==================================================" + RESET);
        System.out.printf("Tempo Total: %d minutos | Guichês: %d\n", tempoTotal, numGuiches);
        System.out.printf("Tempo Máx. Atendimento: %d min | Máx. Chegadas/min: %d\n", tempoMaxAtendimento, maxFansPorMinuto);
        System.out.println(ROXO + "==================================================" + RESET);

        // Loop principal minuto a minuto
        for (int minuto = 1; minuto <= tempoTotal; minuto++) {
            System.out.println("\n" + NEGRITO + "--- Minuto " + minuto + " de " + tempoTotal + " ---" + RESET);

            // 1. Processar atendimento nos guichês (decrementar tempo)
            for (Guiche g : guiches) {
                if (!g.estaLivre()) {
                    Fa atendido = g.decrementarMinuto();
                    if (atendido != null) {
                        System.out.printf("%s[Guichê %d] ✔ Atendimento concluído para: %s.%s\n", 
                                VERDE, g.getId(), atendido, RESET);
                        totalAtendidos++;
                    }
                }
            }

            // 2. Chegada de novos fãs
            int novosChegados = random.nextInt(maxFansPorMinuto + 1); // 0 até maxFansPorMinuto
            if (novosChegados > 0) {
                System.out.printf("%s[Chegadas] %d novos fãs chegaram à fila!%s\n", CIANO, novosChegados, RESET);
                for (int i = 0; i < novosChegados; i++) {
                    // Quantidade de pulseiras randômica (ex: 0 a 50)
                    int pulseiras = random.nextInt(51);
                    Fa novoFa = new Fa("Fã #" + proximoIdFa++, pulseiras);
                    fila.enfileirar(novoFa); // Fila se reordena automaticamente por prioridade
                    System.out.printf("   -> %s entrou na fila com %d pulseira(s).\n", novoFa.getNome(), pulseiras);
                }
            } else {
                System.out.println(CIANO + "[Chegadas] Nenhum fã novo chegou neste minuto." + RESET);
            }

            // 3. Direcionar fãs da fila de prioridade para os guichês livres
            for (Guiche g : guiches) {
                if (g.estaLivre() && !fila.estaVazia()) {
                    Fa proximoFa = fila.desenfileirar();
                    // Sorteia tempo de atendimento entre 1 e tempoMaxAtendimento
                    int tempoAtendimento = random.nextInt(tempoMaxAtendimento) + 1;
                    g.atender(proximoFa, tempoAtendimento);
                    System.out.printf("%s[Atendimento] %s direcionado ao Guichê %d (Tempo estimado: %d min).%s\n",
                            AMARELO, proximoFa, g.getId(), tempoAtendimento, RESET);
                }
            }

            // 4. Mostrar o status atual da fila e dos guichês
            mostrarStatusGuiches();
            System.out.printf("Fãs aguardando na fila: %d\n", fila.tamanho());
            if (fila.tamanho() > 0) {
                System.out.print("Fila atualizada (prioridade ordenada por pulseiras):\n");
                fila.imprimir();
            }
        }

        // Fim da simulação
        mostrarResultadosFinais();
    }

    private void mostrarStatusGuiches() {
        System.out.print("Estado dos Guichês: [");
        for (int i = 0; i < guiches.length; i++) {
            Guiche g = guiches[i];
            if (g.estaLivre()) {
                System.out.print("G" + g.getId() + ":Livre");
            } else {
                System.out.print("G" + g.getId() + ":" + g.getFaAtual().getNome() + "(" + g.getTempoRestante() + "m)");
            }
            if (i < guiches.length - 1) {
                System.out.print(" | ");
            }
        }
        System.out.println("]");
    }

    private void mostrarResultadosFinais() {
        System.out.println("\n" + ROXO + NEGRITO + "==================================================");
        System.out.println("              RESULTADO DA SIMULAÇÃO              ");
        System.out.println("==================================================" + RESET);
        System.out.printf("%s✔ Total de Fãs Atendidos: %d%s\n", VERDE, totalAtendidos, RESET);
        System.out.printf("%s✘ Fãs Restantes na Fila: %d%s\n", VERMELHO, fila.tamanho(), RESET);
        
        if (!fila.estaVazia()) {
            System.out.println("\nLista de Fãs que ainda estão na fila (por ordem de prioridade):");
            fila.imprimir();
        }
        System.out.println(ROXO + "==================================================" + RESET);
    }
}
