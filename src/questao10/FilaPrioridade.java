package questao10;

public class FilaPrioridade {
    private No10<Fa> inicio;
    private No10<Fa> fim;
    private int tamanho;

    public FilaPrioridade() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    public boolean estaVazia() {
        return inicio == null;
    }

    public int tamanho() {
        return tamanho;
    }

    public void enfileirar(Fa fa) {
        No10<Fa> novo = new No10<>(fa);
        if (estaVazia()) {
            inicio = novo;
            fim = novo;
        } else {
            fim.setProximo(novo);
            fim = novo;
        }
        tamanho++;

        // Reordena a fila a cada momento que um novo fã chega
        reordenar();
    }

    public Fa desenfileirar() {
        if (estaVazia()) {
            return null;
        }
        Fa fa = inicio.getDado();
        inicio = inicio.getProximo();
        if (inicio == null) {
            fim = null;
        }
        tamanho--;
        return fa;
    }

    public Fa frente() {
        if (estaVazia()) {
            return null;
        }
        return inicio.getDado();
    }

    public void reordenar() {
        if (inicio == null || inicio.getProximo() == null) {
            return;
        }
        boolean trocou;
        do {
            trocou = false;
            No10<Fa> atual = inicio;
            while (atual.getProximo() != null) {
                No10<Fa> proximo = atual.getProximo();
                // Prioridade para quem tem MAIS pulseiras
                if (atual.getDado().getPulseiras() < proximo.getDado().getPulseiras()) {
                    // Troca os dados dos nós
                    Fa temp = atual.getDado();
                    atual.setDado(proximo.getDado());
                    proximo.setDado(temp);
                    trocou = true;
                }
                atual = proximo;
            }
        } while (trocou);

        // Atualiza a referência de fim após a ordenação
        No10<Fa> atual = inicio;
        while (atual != null && atual.getProximo() != null) {
            atual = atual.getProximo();
        }
        fim = atual;
    }


    public void imprimir() {
        if (estaVazia()) {
            System.out.println("Fila vazia.");
            return;
        }
        No10<Fa> atual = inicio;
        int pos = 1;
        while (atual != null) {
            System.out.printf("  %d. %s\n", pos++, atual.getDado());
            atual = atual.getProximo();
        }
    }
}
