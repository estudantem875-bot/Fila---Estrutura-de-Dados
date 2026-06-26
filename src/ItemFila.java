public class ItemFila<T> {

    private T dado;
    private int prioridade;

    public ItemFila(T dado, int prioridade) {
        this.dado = dado;
        this.prioridade = prioridade;
    }

    public T getDado() {
        return dado;
    }

    public int getPrioridade() {
        return prioridade;
    }
}