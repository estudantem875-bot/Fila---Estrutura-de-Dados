public class FilaEnc<T> implements Fila<T> {

    private No<T> inicio;
    private No<T> fim;
    private int tamanho;

    public FilaEnc() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    @Override
    public boolean estaVazia() {
        return inicio == null;
    }

    @Override
    public boolean enfileirar(T dado) {
        No<T> novo = new No<>(dado);
        if (estaVazia()) {
            inicio = novo;
        } else {
            fim.setProximo(novo);
        }
        fim = novo;
        tamanho++;
        return true;
    }

    @Override
    public T desenfilerar() {
        if (estaVazia())
            return null;
        T dado = inicio.getDado();
        inicio = inicio.getProximo();
        if (inicio == null)
            fim = null;
        tamanho--;
        return dado;
    }

    @Override
    public T frente() {
        if (estaVazia())
            return null;
        return inicio.getDado();
    }

    @Override
    public int tamanho() {
        return tamanho;
    }

    @Override
    public boolean enfileirarComPrioridade(T dado, int prioridade) {
        No<T> novo = new No<>(dado, prioridade);
        if (estaVazia()) {
            inicio = fim = novo;
            tamanho++;
            return true;
        }
        // inserir no começo
        if (prioridade > inicio.getPrioridade()) {
            novo.setProximo(inicio);
            inicio = novo;
            tamanho++;
            return true;
        }
        No<T> atual = inicio;
        while (atual.getProximo() != null &&
                atual.getProximo().getPrioridade() >= prioridade) {
            atual = atual.getProximo();
        }
        novo.setProximo(atual.getProximo());
        atual.setProximo(novo);

        if (novo.getProximo() == null) {
            fim = novo;
        }
        tamanho++;
        return true;
    }

    @Override
    public void limpar(){
        while(!estaVazia()){
            desenfilerar();
        }
    }

    @Override
    public void imprimirEnc() {
        if (estaVazia()) {
            System.out.println("Fila vazia");
            return;
        }
        No<T> atual = inicio;
        while (atual != null) {
            System.out.print(atual.getDado() + " ");
            atual = atual.getProximo();
        }
        System.out.println();
    }

    @Override
    public void acharValor(T valor){
        No<T> atual = inicio;
        while (!atual.getDado().equals(valor)) {
            atual = atual.getProximo();
        }
        if (atual.getDado().equals(valor)) {
            System.out.println("Valor encontrado : "+valor);
        }else{
            System.out.println("Valor não encontrado : "+valor);
        }
    }
    @Override
    public void acharValorCount(T valor){
        No<T> atual = inicio;
        int count = 0;
        while (atual.getProximo()!=null){
            if(atual.getDado().equals(valor)){
                count++;
            }
            atual = atual.getProximo();
        }
        System.out.println(valor+" valores encontrados : "+count);
    }

    @Override
    public void peekDaFila() {
        if (estaVazia()) {
            System.out.println("Fila vazia");
        }
        No<T> atual = fim ;
        System.out.println(atual.getDado());
    }

    @Override
    public void fILO() {
        if (estaVazia() || inicio == fim) {
            return;
        }
        No<T> primeiro = inicio;
        inicio = inicio.getProximo();
        fim.setProximo(primeiro);
        primeiro.setProximo(null);
        fim = primeiro;
        imprimirEnc();
    }

    @Override
    public void reverse() {
        if (estaVazia() || inicio == fim) {
            return;
        }
        No<T> anterior = null;
        No<T> atual = inicio;
        No<T> proximo;
        fim = inicio;
        while (atual != null) {
            proximo = atual.getProximo();
            atual.setProximo(anterior);
            anterior = atual;
            atual = proximo;
        }
        inicio = anterior;
        imprimirEnc();
    }

    @Override
    public void adicionarComPrioridade(T valor , int prioridade){

    }


}