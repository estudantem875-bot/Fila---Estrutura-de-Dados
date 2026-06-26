package questao10;

public class Guiche {
    private int id;
    private Fa faAtual;
    private int tempoRestante;

    public Guiche(int id) {
        this.id = id;
        this.faAtual = null;
        this.tempoRestante = 0;
    }

    public int getId() {
        return id;
    }

    public boolean estaLivre() {
        return faAtual == null;
    }

    public Fa getFaAtual() {
        return faAtual;
    }

    public int getTempoRestante() {
        return tempoRestante;
    }

    /**
     * Inicia o atendimento de um fã com um tempo específico.
     */
    public void atender(Fa fa, int tempoAtendimento) {
        this.faAtual = fa;
        this.tempoRestante = tempoAtendimento;
    }

    /**
     * Decrementa o tempo restante de atendimento em 1 minuto.
     * Retorna o fã atendido caso o atendimento termine, caso contrário retorna null.
     */
    public Fa decrementarMinuto() {
        if (estaLivre()) {
            return null;
        }

        tempoRestante--;

        if (tempoRestante <= 0) {
            Fa finalizado = faAtual;
            faAtual = null;
            tempoRestante = 0;
            return finalizado;
        }

        return null;
    }
}
