public interface Fila <T>{
    boolean enfileirar(T dado);
    T desenfilerar();
    T frente();
    boolean estaVazia();
    int tamanho();
    boolean enfileirarComPrioridade( T dado, int prioridade);
   void imprimirEnc();
   void limpar();
   void acharValor(T valor);
   void acharValorCount(T valor);
   void peekDaFila();
   void fILO();
   void reverse();

}
