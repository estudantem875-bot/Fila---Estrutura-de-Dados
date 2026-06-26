public class FilaArray<T> {

    private ItemFila<T>[] data;
    private int tamanho;

    @SuppressWarnings("unchecked")
    public FilaArray(int capacidade) {
        data = (ItemFila<T>[]) new ItemFila[capacidade];
        tamanho = 0;
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public boolean estaCheio() {
        return tamanho == data.length;
    }

    public int tamanho() {
        return tamanho;
    }
    public int capacidade (){
            return data.length;
    }

    @SuppressWarnings("unchecked")
    private void aumentarCapacidade() {
        ItemFila<T>[] novoArray =
                (ItemFila<T>[]) new ItemFila[data.length * 2];
        for (int i = 0; i < tamanho; i++) {
            novoArray[i] = data[i];
        }
        data = novoArray;
    }

    public boolean enfileirarComPrioridade(T dado) {
        return enfileirarComPrioridade(dado, 0);
    }

    public boolean enfileirarComPrioridade(T dado, int prioridade) {
        if (estaCheio()) {
            aumentarCapacidade();
        }
        int i = tamanho - 1;
        while (i >= 0 &&
                data[i].getPrioridade() < prioridade) {
            data[i + 1] = data[i];
            i--;
        }
        data[i + 1] = new ItemFila<>(dado, prioridade);
        tamanho++;
        return true;
    }

    public T desenfileirar() {
        if (estaVazia())
            return null;
        T removido = data[0].getDado();
        for (int i = 0; i < tamanho - 1; i++) {
            data[i] = data[i + 1];
        }
        data[tamanho - 1] = null;
        tamanho--;
        return removido;
    }

    public T primeiro() {
        if (estaVazia())
            return null;
        return data[0].getDado();
    }

    public void limpar() {
        for (int i = 0; i < tamanho; i++) {
            data[i] = null;
        }
        tamanho = 0;
    }

    public void imprimir() {
        if (estaVazia()) {
            System.out.println("Fila vazia");
            return;
        }
        for (int i = 0; i < tamanho; i++) {
            System.out.print(
                    "[" + data[i].getDado() + " | prioridade=" + data[i].getPrioridade() + "] "
            );
        }
        System.out.println();
    }
}