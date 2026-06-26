
public class No<T> {

    private No<T> proximo;
    private T dado;

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    private int prioridade;

    public No(T dado, int prioridade) {
        this.dado = dado;
        this.prioridade = prioridade;
    }
    public No(T dado) {
        this.dado = dado;
        this.proximo = null;
    }

    public No(No<T> proximo, T dado) {
        this.proximo = proximo;
        this.dado = dado;
    }

    public No<T> getProximo() {
        return proximo;
    }

    public void setProximo(No<T> proximo) {
        this.proximo = proximo;
    }

    public T getDado() {
        return dado;
    }

    public void setDado(T dado) {
        this.dado = dado;
    }
}