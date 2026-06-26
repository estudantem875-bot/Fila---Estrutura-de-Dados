package questao10;

public class No10<T> {
    private T dado;
    private No10<T> proximo;

    public No10(T dado) {
        this.dado = dado;
        this.proximo = null;
    }

    public No10(T dado, No10<T> proximo) {
        this.dado = dado;
        this.proximo = proximo;
    }

    public T getDado() {
        return dado;
    }

    public void setDado(T dado) {
        this.dado = dado;
    }

    public No10<T> getProximo() {
        return proximo;
    }

    public void setProximo(No10<T> proximo) {
        this.proximo = proximo;
    }
}
